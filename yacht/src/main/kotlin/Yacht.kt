object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            YachtCategory.ONES -> dices.count { it == 1 } * 1
            YachtCategory.TWOS -> dices.count { it == 2 } * 2
            YachtCategory.THREES -> dices.count { it == 3 } * 3
            YachtCategory.FOURS -> dices.count { it == 4 } * 4
            YachtCategory.FIVES -> dices.count { it == 5 } * 5
            YachtCategory.SIXES -> dices.count { it == 6 } * 6
            YachtCategory.YACHT -> if (dices.occurrenceCounts().any { it.occurrenceCount == 5 }) 50 else 0
            YachtCategory.FULL_HOUSE -> if (dices.occurrenceCounts().any { it.occurrenceCount == 2 } && dices.occurrenceCounts().any { it.occurrenceCount == 3 }) dices.sum() else 0
            YachtCategory.FOUR_OF_A_KIND -> dices.occurrenceCounts().firstOrNull { it.occurrenceCount >= 4 }.let {
                if (it != null) 4 * it.number
                else 0
            }
            YachtCategory.LITTLE_STRAIGHT -> if (dices.sorted() == listOf(1, 2, 3, 4, 5)) 30 else 0
            YachtCategory.BIG_STRAIGHT -> if (dices.sorted() == listOf(2, 3, 4, 5, 6)) 30 else 0
            YachtCategory.CHOICE -> dices.sum()
        }
    }
}

private fun IntArray.occurrenceCounts(): List<NumberCount> {
    return groupBy { it }.map { NumberCount(it.key, it.value.size) }
}
data class NumberCount(val number: Int, val occurrenceCount: Int)