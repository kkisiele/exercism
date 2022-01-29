object ScrabbleScore {

    fun scoreWord(word: String): Int {
        fun scoreLetter(c: Char): Int = when (c.uppercaseChar()) {
            'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
            'D', 'G' -> 2
            'B', 'C', 'M', 'P' -> 3
            'F', 'H', 'V', 'W', 'Y' -> 4
            'K' -> 5
            'J', 'X' -> 8
            'Q', 'Z' -> 10
            else -> 0
        }
        return word.sumOf { scoreLetter(it) }
    }

    fun scoreWord2(word: String): Int {
        return word.uppercase().sumOf { score[it] ?: 0 }
    }

    private val score: Map<Char, Int> = "AEIOULNRST".associateWith { 1 } +
            "DG".associateWith { 2 } +
            "BCMP".associateWith { 3 } +
            "FHVWY".associateWith { 4 } +
            "K".associateWith { 5 } +
            "JX".associateWith { 8 } +
            "QZ".associateWith { 10 }

}
