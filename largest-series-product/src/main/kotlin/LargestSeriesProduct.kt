class Series(val input: String) {
    init {
        if (input.any { !it.isDigit() }) throw IllegalArgumentException()
    }

    fun getLargestProduct(span: Int): Long {
        if (span > input.length) throw IllegalArgumentException()
        if (span == 0) return 1
        return input
            .map { it - '0' }
            .windowed(span) {
                it.reduce { acc, current -> acc * current }
            }.maxOf { it.toLong() }
    }
}
