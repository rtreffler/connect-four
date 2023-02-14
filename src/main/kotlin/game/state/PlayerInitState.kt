package connectfour.game.state

import connectfour.game.Game
import connectfour.game.player.Factory as PlayerFactory

class PlayerInitState(game: Game): BaseState(game) {
    private val factory = PlayerFactory()
    private var playerNumber = 0

    override fun handle() {
        if (game.players.size == factory.maxPlayers()) {
            game.changeState(BoardInitState(game))
            return
        }

        game.ui.promptPlayerName(playerNumber)
        game.players.add(factory.createPlayer(game.input.get(), playerNumber++))
    }
}
