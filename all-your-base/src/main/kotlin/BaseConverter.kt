import kotlin.math.pow

class BaseConverter(base: Int, input: IntArray) {
    private val number: Int

    init {
        require(base >= 2) {"Bases must be at least 2."}
        require(input.isNotEmpty()) {"You must supply at least one digit."}
        if(input.size > 1) require(input.first() != 0) {"Digits may not contain leading zeros."}
        require(input.all { it < base }) {"All digits must be strictly less than the base."}
        require(input.all { it >= 0 }) {"Digits may not be negative."}
        number = input.reversed().mapIndexed { index, number -> number * base.toDouble().pow(index).toInt() }.sum()
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase >= 2) {"Bases must be at least 2."}
        val result = mutableListOf<Int>()
        var current = number
        do {
            result += current % newBase
            current /= newBase
        } while(current != 0)
        return result.reversed().toIntArray()
    }
}
