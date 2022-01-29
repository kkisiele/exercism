class School {
    private val students = mutableMapOf<Int, MutableList<String>>()

    fun add(student: String, grade: Int) {
        students.getOrPut(grade) { mutableListOf() }.add(student)
    }

    fun grade(grade: Int): List<String> = students.getOrDefault(grade, emptyList()).sorted()

    fun roster(): List<String> = students.toSortedMap().flatMap{ it.value.sorted() }
}
