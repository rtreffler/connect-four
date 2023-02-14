package connectfour

import connectfour.game.Game
import connectfour.game.input.StdIn
import connectfour.game.translations.English
import connectfour.game.ui.stdOut.StdOutUI
import connectfour.game.ui.stdOut.board.AsciiFormatter

fun main() {
    val game = Game(StdIn(), StdOutUI(English(), AsciiFormatter()))

    game.init()
    while (game.isRunning()) {
        game.handleState()
    }
    game.cleanup()
}
