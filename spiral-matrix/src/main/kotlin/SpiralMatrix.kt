object SpiralMatrix {
    private const val NOT_INITIALIZED_CELL = -1
    private val EMPTY_ROW = IntArray(0)

    fun _NOT_MINE_ofSize(size: Int): Array<IntArray> {
        val grid = Array(size, { IntArray(size) })
        var count = 0
        var start = 0
        var end = size - 1
        while (start <= end) {
            (start..end).forEach { grid[start][it] = ++count }
            (start + 1..end).forEach { grid[it][end] = ++count }
            (end - 1 downTo start).forEach { grid[end][it] = ++count }
            (end - 1 downTo start + 1).forEach { grid[it][start] = ++count }
            ++start
            --end
        }
        return grid
    }

    fun ofSize(size: Int): Array<IntArray> {
        var list = Array(size) { IntArray(size) { NOT_INITIALIZED_CELL } }
        var number = 1
        var rotateCount = 0
        do {
            val rowIndex = rotateCount / 4
            val row =  list.getOrNull(rowIndex) ?: EMPTY_ROW
            for (i in row.indices) {
                if (row[i] == NOT_INITIALIZED_CELL) row[i] = number++
            }
            list = rotate(list)
            rotateCount += 1
        } while (countOfInitializedCells(list) < size * size || rotateCount % 4 != 0)
        return list
    }

    private fun countOfInitializedCells(matrix: Array<IntArray>): Int = matrix.sumOf { row -> row.count { it != NOT_INITIALIZED_CELL } }

    private fun rotate(matrix: Array<IntArray>): Array<IntArray> =
        matrix.indices.reversed().map { column -> matrix.columnValues(column) }.toTypedArray()

    private fun Array<IntArray>.columnValues(column: Int): IntArray = this.map { it[column] }.toIntArray()
}
