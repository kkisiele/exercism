class RotationalCipher(private val n: Int) {

    fun encode(text: String): String {
        return text.toCharArray()
            .map { it.shift(n)}
            .joinToString(separator = "")
    }
}

fun Char.shift(n: Int): Char {
    if (isLetter()) {
        if (isLowerCase()) {
            return 'a' + ((this - 'a' + n) % 26)
        }
        if (isUpperCase()) {
            return 'A' + ((this - 'A' + n) % 26)
        }
    }
    return this
}