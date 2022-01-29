private const val STARTING_CHARACTER = 'A'

class DiamondPrinter {
    fun printToList(ch: Char): List<String> {
        fun printLine(c: Char) = buildString {
            val offset = c - STARTING_CHARACTER
            val width = 2 * (ch - STARTING_CHARACTER) + 1
            append(" ".repeat(width))
            replaceChar(width / 2 - offset, c)
            replaceChar(width / 2 + offset, c)
        }
        return (STARTING_CHARACTER.until(ch) + ch.downTo(STARTING_CHARACTER)).map(::printLine)
    }

    private fun StringBuilder.replaceChar(position: Int, ch: Char) {
        replace(position, position + 1, ch.toString())
    }
}

