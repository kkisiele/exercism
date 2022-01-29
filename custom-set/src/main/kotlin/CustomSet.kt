class CustomSet(vararg input: Int) {

    private var elements = IntArray(0)

    init {
        input.forEach(::add)
    }

    fun isEmpty(): Boolean = size == 0

    private val size: Int
        get() = elements.size

    fun isSubset(other: CustomSet): Boolean = elements.all { other.contains(it) }

    fun isDisjoint(other: CustomSet): Boolean = elements.none() { other.contains(it) }

    fun contains(other: Int): Boolean = elements.any { it == other }

    fun intersection(other: CustomSet): CustomSet = CustomSet(
        *this.elements.filter { other.contains(it) }.toIntArray(),
        *other.elements.filter { this.contains(it) }.toIntArray()
    )

    fun add(other: Int) {
        if (!contains(other)) {
            elements += other
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is CustomSet) {
            return this.size == other.size && this.isSubset(other)
        }
        return false
    }

    operator fun plus(other: CustomSet): CustomSet = CustomSet(*this.elements, *other.elements)

    operator fun minus(other: CustomSet): CustomSet = CustomSet(*this.elements.filter { !other.contains(it) }.toIntArray())

    override fun toString(): String = elements.joinToString(separator = ", ", prefix = "[", postfix = "]")
}
