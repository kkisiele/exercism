import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.math.pow

object Wordy {
    private var groups = listOf<String>()

    fun answer(input: String): Int =
        when {
            input.matches("What is ([+-]?[0-9]+)\\?") ->
                groups[1].toInt()
            input.matches("What is ([+-]?[0-9]+) (plus|minus|multiplied by|divided by) ([+-]?[0-9]+)\\?") ->
                calculate(groups[2], groups[1].toInt(), groups[3].toInt())
            input.matches("What is ([+-]?[0-9]+) (plus|minus|multiplied by|divided by) ([+-]?[0-9]+) (plus|minus|multiplied by|divided by) ([+-]?[0-9]+)\\?") ->
                calculate(groups[4], calculate(groups[2], groups[1].toInt(), groups[3].toInt()), groups[5].toInt())
            input.matches("What is ([+-]?[0-9]+) raised to the ([+-]?[0-9]+)(st|nd|rd|th) power\\?") ->
                groups[1].toDouble().pow(groups[2].toInt()).toInt()
            else -> throw Exception("Unknown question")
        }

    private fun calculate(operation: String, arg1: Int, arg2: Int) = when (operation) {
        "plus" -> arg1 + arg2
        "minus" -> arg1 - arg2
        "multiplied by" -> arg1 * arg2
        "divided by" -> arg1 / arg2
        else -> throw IllegalArgumentException()
    }

    private fun String.matches(regexp: String): Boolean {
        val result = Regex(regexp).find(this)
        groups = result?.groupValues ?: listOf()
        return result != null
    }
}
