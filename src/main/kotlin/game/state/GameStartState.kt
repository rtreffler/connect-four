package connectfour.game.state

import connectfour.game.Game

class GameStartState(game: Game): BaseState(game) {
    override fun handle() {
        if (game.gameNumber > game.numberOfGames) {
            game.changeState(FinishState(game))
            return
        }

        if (game.numberOfGames > 1) {
            game.ui.showGameNumber(game.gameNumber)
        }
        game.board!!.clear()
        game.ui.showBoard(game.board!!)

        game.changeState(TurnState(game))
    }
}