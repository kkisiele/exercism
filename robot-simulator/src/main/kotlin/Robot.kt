class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = Orientation.NORTH) {

    fun simulate(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> move()
            }
        }
    }

    private fun turnRight() {
        orientation = orientation.turnRight()
    }

    private fun turnLeft() {
        orientation = orientation.left()
    }

    private fun move() {
        gridPosition = gridPosition.move(orientation)
    }
}
