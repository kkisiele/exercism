enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification = naturalNumber
    .let { require(it > 0); it }
    .compareTo(naturalNumber.aliquotSum())
    .let {
        when (it) {
            0 -> Classification.PERFECT
            -1 -> Classification.ABUNDANT
            else -> Classification.DEFICIENT
        }
    }

private fun Int.aliquotSum(): Int = 1.rangeTo(this / 2)
    .filter { this % it == 0 }
    .sum()

fun classify2(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    val aliquotSum = 1.rangeTo(naturalNumber / 2)
        .filter { naturalNumber % it == 0 }
        .sum()
    return when (aliquotSum.compareTo(naturalNumber)) {
        0 -> Classification.PERFECT
        1 -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
