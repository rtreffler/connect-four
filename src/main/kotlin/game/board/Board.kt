package connectfour.game.board

import connectfour.game.ui.stdOut.board.Formatter
import connectfour.game.player.Player

class Board (val rows: Int = 6, val cols: Int = 7) {
    private object Consts {
        const val EMPTY_CELL = ' '
    }

    private val board: Array<Array<Char>> = Array(cols) { Array(rows) { Consts.EMPTY_CELL } }

    fun draw(formatter: Formatter) {
        formatter.draw(board)
    }

    fun hasCol(col: Int): Boolean = col in board.indices

    fun isColFull(col: Int): Boolean {
        if (!hasCol(col)) {
            throw IndexOutOfBoundsException("The column number is out of range (1 - $cols)")
        }
        return board[col].count { it != Consts.EMPTY_CELL } == board[col].size
    }

    fun addDisc(col: Int, player: Player): Int {
        return board[col].lastIndexOf(Consts.EMPTY_CELL).also {
            board[col][it] = player.disc
        }
    }

    fun isFull(): Boolean {
        var sum = 0

        board.forEach { col -> sum += col.count { it != Consts.EMPTY_CELL } }

        return sum == board.size * board[0].size
    }

    fun hasPlayerDiscAt(player: Player, col: Int, row: Int): Boolean = board[col][row] == player.disc

    fun clear() = board.forEach { it.fill(Consts.EMPTY_CELL) }
}