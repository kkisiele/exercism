object Bob {
    fun hey(input: String): String = with(input) {
        when {
            yell() -> if(question()) "Calm down, I know what I'm doing!" else "Whoa, chill out!"
            silence() -> "Fine. Be that way!"
            question() -> "Sure."
            else -> "Whatever."
        }
    }

    private fun String.yell(): Boolean = any(Char::isLetter) && filter(Char::isLetter).all(Char::isUpperCase)
    private fun String.question(): Boolean = trimEnd().endsWith("?")
    private fun String.silence(): Boolean = isBlank()
}
