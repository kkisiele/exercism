import java.lang.IllegalArgumentException

class PhoneNumber(input: String) {
    var normalized: String

    init {
        normalized = input.filter { it.isDigit() }.let {
            when (Regex("^(1?)([2-9][0-9]{2})([2-9][0-9]{6})$").matches(it)) {
                true -> it
                false -> throw IllegalArgumentException()
            }
        }
    }

    val number: String = when (normalized.length) {
        11 -> normalized.drop(1)
        else -> normalized
    }
}
