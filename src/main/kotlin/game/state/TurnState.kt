package connectfour.game.state

import connectfour.game.Game

class TurnState(game: Game): BaseState(game) {
    private object Consts {
        const val END_CHOICE = "end"
    }

    override fun handle() {
        game.ui.promptPlayerTurn(game.getPlayer())
        val choice = game.input.get()
        if (choice == Consts.END_CHOICE) {
            game.changeState(FinishState(game))
            return
        }

        if (choice.toIntOrNull() == null) {
            game.ui.showInvalidBoardColumn()
            return
        }

        val col = choice.toInt() - 1
        if (!game.board!!.hasCol(col)) {
            game.ui.showColumnOutOfRange(1..game.board!!.cols)
        } else if (game.board!!.isColFull(col)) {
            game.ui.showBoardColumnIsFull(col + 1)
        } else {
            val row = game.addDisc(col)

            game.ui.showBoard(game.board!!)

            if (game.isPlayerWinning(row, col)) {
                game.getPlayer().score += 2
                game.ui.showIsPlayerWinning(game.getPlayer())
                game.nextTurn()
                game.changeState(GameEndState(game))
                return
            } else if (game.isDraw()) {
                game.players.forEach { ++it.score }
                game.ui.showIsDraw()
                game.nextTurn()
                game.changeState(GameEndState(game))
                return
            }

            game.nextTurn()
        }
    }
}