class BinarySearchTree<T : Comparable<T>> {

    data class Node<T : Comparable<T>>(val data: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null

        val children: List<Node<T>>
            get() = listOfNotNull(left, right)

        fun insert(value: T) {
            when {
                value <= data -> if(left == null) this.left = Node(value) else left!!.insert(value)
                else          -> if(right == null) this.right = Node(value) else right!!.insert(value)
            }
        }
    }

    var root: Node<T>? = null

    fun insert(value: T) {
        if (root == null) root = Node(value)
        else root!!.insert(value)
    }

    fun asSortedList(): List<T> = asLevelOrderList().sorted()

    fun asLevelOrderList(): List<T> {
        var process = listOfNotNull(root).toMutableList()
        var result = mutableListOf<T>()
        while (process.isNotEmpty()) {
            val node = process.removeFirst()
            result.add(node.data)
            process += node.children
        }
        return result.toList()
    }
}
