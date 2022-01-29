class ChangeCalculator(private val coins: List<Int>) {
    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }
        val resultCoins = fewestCoins(grandTotal)
        if (grandTotal > 0) require(resultCoins.isNotEmpty()) { "The total $grandTotal cannot be represented in the given currency." }
        return resultCoins
    }

    private fun fewestCoins(grandTotal: Int): List<Int> {
        val cache: MutableMap<Int, List<Int>> = mutableMapOf()

        fun calculateFewestCoins(grandTotal: Int): List<Int> {
            if (!cache.containsKey(grandTotal)) {
                cache[grandTotal] = coins.filter { it <= grandTotal }
                    .map { calculateFewestCoins(grandTotal - it) + it }
                    .filter { it.sum() == grandTotal }
                    .minByOrNull { it.size } ?: emptyList()
            }
            return cache.getValue(grandTotal)
        }
        return calculateFewestCoins(grandTotal)
    }
}
