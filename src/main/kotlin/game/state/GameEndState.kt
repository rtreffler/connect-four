package connectfour.game.state

import connectfour.game.Game

class GameEndState(game: Game): BaseState(game) {
    override fun handle() {
        if (game.numberOfGames == 1) {
            game.changeState(FinishState(game))
            return
        }

        game.ui.showScoreTitle()
        game.ui.showScore(game.players, game.score)
        game.nextGame()
        game.changeState(GameStartState(game))
    }
}