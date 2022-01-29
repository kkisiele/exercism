import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val amount = (input[0].ordinal * 10 + input[1].ordinal) * 10.0.pow(input[2].ordinal).toInt()
        val zeros = amount.toString().count { it == '0' }
        val unit = Unit.values()[zeros / 3]
        return "${amount / 1_000.0.pow(unit.ordinal).toInt()} ${unit.name.lowercase()}"
    }
}

