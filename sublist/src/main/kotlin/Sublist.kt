enum class Relationship {
    EQUAL, SUBLIST, SUPERLIST, UNEQUAL
}

fun <E> List<E>.relationshipTo(other: List<E>): Relationship = when {
    other.sublistOf(this) && this.sublistOf(other) -> Relationship.EQUAL
    other.sublistOf(this) -> Relationship.SUPERLIST
    this.sublistOf(other) -> Relationship.SUBLIST
    else -> Relationship.UNEQUAL
}

private fun <E> List<E>.sublistOf(other: List<E>): Boolean =
    this.isEmpty() || other.windowed(this.size).any { it == this }
