package connectfour.game.player

class Factory {
    private val playerSymbolLookup = arrayOf('o', '*')

    fun createPlayer(name: String, playerNumber: Int): Player {
        return Player(name, playerSymbolLookup[playerNumber])
    }

    fun maxPlayers(): Int = playerSymbolLookup.size
}