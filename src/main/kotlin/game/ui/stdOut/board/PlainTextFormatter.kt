package connectfour.game.ui.stdOut.board

class PlainTextFormatter: Formatter {
    override fun draw(board: Array<Array<Char>>) {
        val head = " " + (1..board.size).joinToString(" ")
        val foot = "=".repeat(2 * board.size + 1)

        println(head)
        for (i in board[0].indices) {
            print("|")
            for (col in board) {
                print("${col[i]}|")
            }
            println()
        }
        println(foot)
    }
}