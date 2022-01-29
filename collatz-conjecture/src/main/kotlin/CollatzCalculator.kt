object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0)
        return generateSequence(start) {
            when {
                it == 1 -> null
                it % 2 == 0 -> it / 2
                else -> 3 * it + 1
            }
        }.count()
    }

}
