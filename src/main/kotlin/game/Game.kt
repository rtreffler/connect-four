package connectfour.game

import connectfour.game.player.Player
import connectfour.game.board.Board
import connectfour.game.input.Input
import connectfour.game.state.IntroState
import connectfour.game.state.State
import connectfour.game.ui.UI
import kotlin.math.max
import kotlin.math.min

class Game(val input: Input, val ui: UI) {
    private object Consts {
        const val NUMBER_OF_DISKS_TO_WIN = 4
    }

    private var isRunning = false
    private val states = mutableListOf<State>()

    internal var board: Board? = null
    internal var players: MutableList<Player> = mutableListOf()
    internal val score: MutableList<Int> = mutableListOf()
    internal var numberOfGames = 0
    internal var gameNumber = 1
    private var turn = 0

    fun init() {
        isRunning = true
        changeState(IntroState(this))
    }

    fun cleanup() {
        while (states.isNotEmpty()) {
            states.removeLast()
        }
    }

    internal fun changeState(state: State) {
        if (states.isNotEmpty()) {
            states.removeLast()
        }

        states.add(state)
    }

    fun handleState() {
        states.last().handle()
    }

    fun isRunning(): Boolean = isRunning

    fun quit() {
        isRunning = false
    }

    internal fun addDisc(col: Int): Int = board!!.addDisc(col, getPlayer())

    internal fun nextTurn() {
        turn = (turn + 1) % players.size
    }

    internal fun nextGame() = ++gameNumber

    internal fun getPlayer(): Player = players[turn % players.size]

    internal fun isDraw(): Boolean = board!!.isFull()

    internal fun isPlayerWinning(row: Int, col: Int): Boolean {
        return isPlayerWinningInCol(col, row) ||
                isPlayerWinningInRow(col, row) ||
                isPlayerWinningDiagonally(col, row)
    }

    private fun isPlayerWinningDiagonally(col: Int, row: Int): Boolean {
        val maxCols = board!!.cols - 1
        val maxRows = board!!.rows - 1

        val diff = col - row
        val minCol1 = col - min(min(row, col), Consts.NUMBER_OF_DISKS_TO_WIN)
        val maxCol1 = col + min(min(maxRows - row, maxCols - col), Consts.NUMBER_OF_DISKS_TO_WIN)
        if (maxCol1 - minCol1 + 1 >= Consts.NUMBER_OF_DISKS_TO_WIN) {
            var count = 0
            var j: Int
            for (i in minCol1..maxCol1) {
                j = i - diff

                if (board!!.hasPlayerDiscAt(getPlayer(), i, j)) {
                    ++count
                } else {
                    count = 0
                }
                if (count == Consts.NUMBER_OF_DISKS_TO_WIN) {
                    return true
                }
            }
        }

        val sum = row + col
        val minCol2 = col - min(min(maxRows - row, col), Consts.NUMBER_OF_DISKS_TO_WIN)
        val maxCol2 = min(col + min(row, Consts.NUMBER_OF_DISKS_TO_WIN), maxCols)
        if (maxCol2 - minCol2 + 1 >= Consts.NUMBER_OF_DISKS_TO_WIN) {
            var count = 0
            var j: Int
            for (i in minCol2..maxCol2) {
                j = sum - i

                if (board!!.hasPlayerDiscAt(getPlayer(), i, j)) {
                    ++count
                } else {
                    count = 0
                }
                if (count == Consts.NUMBER_OF_DISKS_TO_WIN) {
                    return true
                }
            }
        }

        return false
    }

    private fun isPlayerWinningInCol(col: Int, row: Int): Boolean {
        val minRow = max(row - Consts.NUMBER_OF_DISKS_TO_WIN, 0)
        val maxRow = min(row + Consts.NUMBER_OF_DISKS_TO_WIN, board!!.rows - 1)
        var count = 0

        for (i in minRow..maxRow) {
            if (board!!.hasPlayerDiscAt(getPlayer(), col, i)) {
                ++count
            } else {
                count = 0
            }
            if (count == Consts.NUMBER_OF_DISKS_TO_WIN) {
                return true
            }
        }

        return false
    }

    private fun isPlayerWinningInRow(col: Int, row: Int): Boolean {
        val minCol = max(col - Consts.NUMBER_OF_DISKS_TO_WIN, 0)
        val maxCol = min(col + Consts.NUMBER_OF_DISKS_TO_WIN, board!!.cols - 1)
        var count = 0

        for (i in minCol..maxCol) {
            if (board!!.hasPlayerDiscAt(getPlayer(), i, row)) {
                ++count
            } else {
                count = 0
            }
            if (count == Consts.NUMBER_OF_DISKS_TO_WIN) {
                return true
            }
        }

        return false
    }
}
