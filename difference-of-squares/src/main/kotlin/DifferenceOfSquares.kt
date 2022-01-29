class Squares (private val n: Int) {
    fun sumOfSquares(): Int = (1..n).sumOf { it.squared() }
    fun squareOfSum(): Int = (1..n).sum().squared()
    fun difference(): Int = squareOfSum() - sumOfSquares()
}

private fun Int.squared(): Int = this * this
