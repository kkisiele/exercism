import java.lang.IllegalArgumentException

object PigLatin {
    private val vowels = setOf("aeiou")
    private val consonants = setOf("bcdfghjklmnpqrstvwxyz")
    private var groups = listOf<String>()

    fun translate(phrase: String): String {
        return phrase.split("\\s+".toRegex())
            .joinToString(" ") { translateWord(it) }
    }

    private fun String.matches(regexp: String): Boolean {
        val result = Regex(regexp).find(this)
        groups = result?.groupValues ?: listOf()
        return result != null
    }

    private fun translateWord(phrase: String): String = when {
        phrase.matches("^([$vowels]+.*)") -> "${groups[0]}ay"
        phrase.matches("^(xr|yt)(.+)") -> "${groups[0]}ay"
        phrase.matches("^(.)(y)") -> "${groups[2]}${groups[1]}ay"
        phrase.matches("^([$consonants]?qu)(.*)") -> "${groups[2]}${groups[1]}ay"
        phrase.matches("^([$consonants]+)(y.*)") -> "${groups[2]}${groups[1]}ay"
        phrase.matches("^([$consonants]+)(.*)") -> "${groups[2]}${groups[1]}ay"
        else -> throw IllegalArgumentException()
    }

}
