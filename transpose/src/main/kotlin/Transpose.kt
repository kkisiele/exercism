object Transpose {

    fun transpose(input: List<String>): List<String> {
        val width = input.maxOfOrNull { it.length } ?: 0
        return 0.until(width).mapIndexed { index, _ ->
            transposed(input, index)
        }
    }

    private fun transposed(input: List<String>, columnIndex: Int) = input
        .map { it.getOrNull(columnIndex) }
        .dropLastWhile { it == null }
        .map { it ?: ' ' }
        .joinToString("")
}
