package connectfour.game.translations

abstract class BaseTranslations: Translations {
    protected val translations = mutableMapOf<String, String>()

    override fun get(key: String): String = translations.getOrDefault(key, key)

    override fun get(key: String, params: Map<String, String>): String {
        var translation = translations.getOrDefault(key, key)

            params.forEach { (key, value) ->
                translation = translation.replace("{$key}", value)
            }

        return translation
    }
}