package connectfour.game.ui

import connectfour.game.board.Board
import connectfour.game.player.Player

interface UI {
    // IntroState
    fun showTitle()
    // PlayerInitState
    fun promptPlayerName(playerNumber: Int)
    // BoardInitState
    fun showBoardSizeTitle()
    fun promptBoardSize(defaultRows: Int, defaultCols: Int)
    fun showInvalidBoardSizeRow(min: Int, max: Int)
    fun showInvalidBoardSizeCol(min: Int, max: Int)
    fun showInvalidBoardSizeInput()
    // NumberOfGamesState
    fun showQuestionNumberOfGames()
    fun showHintNumberOfGames()
    fun promptNumberOfGames()
    fun showInvalidNumberOfGames()
    fun showPlayersInfo(players: List<Player>)
    fun showBoardInfo(board: Board)
    fun showSingleGame()
    fun showTotalGames(numberOfGames: Int)
    // GamesStartState
    fun showGameNumber(gameNumber: Int)
    fun showBoard(board: Board)
    // TurnState
    fun promptPlayerTurn(player: Player)
    fun showInvalidBoardColumn()
    fun showColumnOutOfRange(range: IntRange)
    fun showBoardColumnIsFull(column: Int)
    fun showIsPlayerWinning(player: Player)
    fun showIsDraw()
    // EndGameState
    fun showScoreTitle()
    fun showScore(players: MutableList<Player>, scores: MutableList<Int>)
    // FinishState
    fun showGameOver()
}