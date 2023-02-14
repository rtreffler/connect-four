package connectfour.game.input

class StdIn: Input {
    override fun get(): String {
        return readln()
    }
}