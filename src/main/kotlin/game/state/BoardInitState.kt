package connectfour.game.state

import connectfour.game.Game
import connectfour.game.board.Board
import connectfour.game.board.Factory as BoardFactory

class BoardInitState(game: Game): BaseState(game) {
    private val factory = BoardFactory()

    override fun handle() {
        if (game.board is Board) {
            game.changeState(NumberOfGamesState(game))
            return
        }

        game.ui.showBoardSizeTitle()
        game.ui.promptBoardSize(factory.defaultRows, factory.defaultCols)
        val boardSize = game.input.get()
            .lowercase().replace(" ", "").replace("\t", "")

        if (boardSize.isEmpty()) {
            game.board = factory.createBoard(factory.defaultRows, factory.defaultCols)
            return
        }

        try {
            boardSize.split('x').also {
                if (it.first().toInt() !in factory.minRows..factory.maxRows) {
                    game.ui.showInvalidBoardSizeRow(factory.minRows, factory.maxRows)
                } else if (it.last().toInt() !in factory.minCols..factory.maxCols) {
                    game.ui.showInvalidBoardSizeCol(factory.minCols, factory.maxCols)
                } else {
                    game.board = factory.createBoard(it.first().toInt(), it.last().toInt())
                }
            }
        } catch (_: Throwable) {
            game.ui.showInvalidBoardSizeInput()
        }
    }
}
