class Triangle<out T : Number>(a: T, b: T, c: T) {
    init {
        val sides = listOf(a.toDouble(), b.toDouble(), c.toDouble())
        val sidesGreaterThanZero = sides.all { it > 0 }
        val triangleInequality = sides.all { sides.minus(it).sum() > it }
        require(sidesGreaterThanZero && triangleInequality)
    }

    val isEquilateral: Boolean = a == b && b == c
    val isIsosceles: Boolean = a == b || b == c || a == c
    val isScalene: Boolean = !isIsosceles
}
