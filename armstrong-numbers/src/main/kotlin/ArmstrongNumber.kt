import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val str = input.toString()
        return str.map { it - '0' }.sumOf { it.toDouble().pow(str.length).toInt() } == input
    }

}
