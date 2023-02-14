package connectfour.game.state

import connectfour.game.Game

class FinishState(game: Game): BaseState(game) {
    override fun handle() {
        game.ui.showGameOver()
        game.quit()
    }
}