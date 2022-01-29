class Matrix(input: String) {
    private val matix: List<List<Int>> = input.lines().map { row ->
        row.trim().split("\\s+".toRegex()).map { it.toInt() }
    }

    fun column(colNr: Int): List<Int> {
        return matix.map { row -> row[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matix[rowNr - 1]
    }
}
