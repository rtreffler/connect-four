package connectfour.game.translations

interface Translations {
    fun get(key: String): String
    fun get(key: String, params: Map<String, String>): String
}