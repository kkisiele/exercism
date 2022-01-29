class Allergies(val score: Int) {
    fun getList(): List<Allergen> {
        return Allergen.values().filter(::isAllergicTo)
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return (score and allergen.score) == allergen.score
    }
}
