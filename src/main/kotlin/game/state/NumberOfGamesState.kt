package connectfour.game.state

import connectfour.game.Game

class NumberOfGamesState(game: Game): BaseState(game) {
    override fun handle() {
        if (game.numberOfGames > 0) {
            game.ui.showPlayersInfo(game.players)
            game.ui.showBoardInfo(game.board!!)
            if (game.numberOfGames == 1) {
                game.ui.showSingleGame()
            } else {
                game.ui.showTotalGames(game.numberOfGames)
            }
            game.changeState(GameStartState(game))
            return
        }

        game.ui.showQuestionNumberOfGames()
        game.ui.showHintNumberOfGames()
        game.ui.promptNumberOfGames()

        val input = game.input.get()
        if (input.isEmpty()) {
            game.numberOfGames = 1
        } else {
            val numberOfGames = input.toIntOrNull()
            if (numberOfGames !== null && numberOfGames > 0) {
                game.numberOfGames = numberOfGames
            } else {
                game.ui.showInvalidNumberOfGames()
            }
        }
    }
}