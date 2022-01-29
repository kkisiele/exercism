class KindergartenGarden(private val diagram: String) {
    private var students = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")
    private var plants = mapOf('V' to "violets", 'R' to "radishes", 'C' to "clover", 'G' to "grass")

    fun getPlantsOfStudent(student: String): List<String> {
        return diagram.split(Regex("\\s+"))
            .map {
                it
                    .subSequence(students.indexOf(student) * 2, students.indexOf(student) * 2 + 2)
                    .map(plants::getValue)
            }.flatten()
    }
}
