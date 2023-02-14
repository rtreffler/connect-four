package connectfour.game.state

import connectfour.game.Game

class IntroState(game: Game): BaseState(game) {
    override fun handle() {
        game.ui.showTitle()

        game.changeState(PlayerInitState(game))
    }
}
