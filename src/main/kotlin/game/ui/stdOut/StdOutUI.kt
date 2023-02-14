package connectfour.game.ui.stdOut

import connectfour.game.board.Board
import connectfour.game.player.Player
import connectfour.game.translations.Translations
import connectfour.game.ui.UI
import connectfour.game.ui.stdOut.board.Formatter

class StdOutUI(private val translations: Translations, private val boardFormatter: Formatter): UI {
    override fun showTitle() {
        println(translations.get("title"))
    }

    override fun promptPlayerName(playerNumber: Int) {
        println(translations.get("prompt_player_name_${playerNumber + 1}"))
    }

    override fun showBoardSizeTitle() {
        println(translations.get("board_size_title"))
    }

    override fun promptBoardSize(defaultRows: Int, defaultCols: Int) {
        println(translations.get(
            "prompt_board_size",
            mapOf("defaultRows" to defaultRows.toString(), "defaultCols" to defaultCols.toString())
        ))
    }

    override fun showInvalidBoardSizeRow(min: Int, max: Int) {
        println(translations.get("invalid_board_size_row", mapOf("min" to min.toString(), "max" to max.toString())))
    }

    override fun showInvalidBoardSizeCol(min: Int, max: Int) {
        println(translations.get("invalid_board_size_col", mapOf("min" to min.toString(), "max" to max.toString())))
    }

    override fun showInvalidBoardSizeInput() {
        println(translations.get("invalid_board_size_input"))
    }

    override fun showQuestionNumberOfGames() {
        println(translations.get("question_number_of_games"))
    }

    override fun showHintNumberOfGames() {
        println(translations.get("hint_number_of_games"))
    }

    override fun promptNumberOfGames() {
        println(translations.get("prompt_number_of_games"))
    }

    override fun showInvalidNumberOfGames() {
        println(translations.get("invalid_number_of_games"))
    }

    override fun showSingleGame() {
        println(translations.get("single_game"))
    }

    override fun showTotalGames(numberOfGames: Int) {
        println(translations.get("total_games", mapOf("number" to numberOfGames.toString())))
    }

    override fun showGameNumber(gameNumber: Int) {
        println(translations.get("game_number", mapOf("number" to gameNumber.toString())))
    }

    override fun showPlayersInfo(players: List<Player>) {
        println(translations.get("players_info", mapOf("name1" to players[0].name, "name2" to players[1].name)))
    }

    override fun showBoardInfo(board: Board) {
        println(translations.get("board_info", mapOf("rows" to board.rows.toString(), "cols" to board.cols.toString())))
    }

    override fun showBoard(board: Board) {
        board.draw(boardFormatter)
    }

    override fun promptPlayerTurn(player: Player) {
        println(translations.get("prompt_player_turn", mapOf("name" to player.name)))
    }

    override fun showColumnOutOfRange(range: IntRange) {
        println(translations.get("column_out_of_range", mapOf("left" to range.first.toString(), "right" to range.last.toString())))
    }

    override fun showInvalidBoardColumn() {
        println(translations.get("invalid_column"))
    }

    override fun showBoardColumnIsFull(column: Int) {
        println(translations.get("column_is_full", mapOf("column" to column.toString())))
    }

    override fun showIsPlayerWinning(player: Player) {
        println(translations.get("player_won", mapOf("name" to player.name)))
    }

    override fun showIsDraw() {
        println(translations.get("is_draw"))
    }

    override fun showScoreTitle() {
        println(translations.get("score_title"))
    }

    override fun showScore(players: MutableList<Player>, scores: MutableList<Int>) {
        players.joinToString(separator = " ") {
            translations.get("score", mapOf("name" to it.name, "score" to it.score.toString()))
        }.also { println(it) }
    }

    override fun showGameOver() {
        println(translations.get("game_over"))
    }
}