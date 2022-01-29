data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val values: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            return values.mapIndexed { row, values ->
                values.mapIndexedNotNull { column, value ->
                    if (saddlePoint(row, column, value)) MatrixCoordinate(row + 1, column + 1) else null
                }
            }.flatten().toSet()
        }

    private fun saddlePoint(r: Int, c: Int, value: Int): Boolean {
        fun rowValues(r: Int): List<Int> = values[r]
        fun columnValues(c: Int): List<Int> = values.map { it[c] }
        return rowValues(r).all { it <= value } && columnValues(c).all { it >= value }
    }


}