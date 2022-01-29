object Atbash {

    fun encode(input: String): String = input
        .mapNotNull { code(it) }
        .chunked(5) { it.joinToString("") }
        .joinToString(" ")

    fun decode(input: String): String = input
        .mapNotNull { code(it) }
        .joinToString("")

    private fun code(ch: Char): Char? = when {
        ch.isLetter() ->'a' + (25 - (ch.lowercaseChar() - 'a'))
        ch.isDigit() -> ch
        else -> null
    }
}
