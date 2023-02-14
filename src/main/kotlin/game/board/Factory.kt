package connectfour.game.board

class Factory {
    val defaultRows = 6
    val defaultCols = 7
    val minRows = 5
    val maxRows = 9
    val minCols = 5
    val maxCols = 9

    fun createBoard(rows: Int, cols: Int): Board {
        return Board(rows, cols)
    }
}