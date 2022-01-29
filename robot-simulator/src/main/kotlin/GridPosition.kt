data class GridPosition(val x: Int, val y: Int) {
    fun move(orientation: Orientation): GridPosition = when (orientation) {
        Orientation.NORTH -> GridPosition(x, y + 1)
        Orientation.SOUTH -> GridPosition(x, y - 1)
        Orientation.WEST -> GridPosition(x - 1, y)
        Orientation.EAST -> GridPosition(x + 1, y)
    }
}
