import kotlin.math.sqrt

object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        val result = (2..upperBound).toMutableList()
        for (i in 2..sqrt(upperBound.toDouble()).toInt()) {
            result.removeAll { it > i && it % i == 0 }
        }
        return result
    }
}
