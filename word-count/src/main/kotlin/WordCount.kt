import java.util.regex.Pattern

object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase
            .lowercase()
            .split(Pattern.compile("[\\s,]+"))
            .mapNotNull(::normalize)
            .groupingBy { it }
            .eachCount()
    }

    private fun normalize(word: String): String? {
        return word
            .replace(Regex("^[^\\w]+"), "")
            .replace(Regex("[^\\w]+$"), "")
            .ifBlank { return null }
    }
}
