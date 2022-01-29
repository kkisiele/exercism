object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        return generateSequence(listOf(1)) { prev ->
            listOf(prev.first()) + prev.windowed(2, partialWindows = false).map { it.sum() } + listOf(prev.last())
        }.take(rows).toList()
    }
}
