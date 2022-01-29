class Deque<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(value: T) { //insert value at back
        val node =  Node(value)
        if(head == null) {
            head = node
            tail = node
        } else {
            node.prev = tail
            tail?.next = node
            tail = node
        }
    }

    fun pop(): T? { //remove value at back
        if(tail == null) {
            return null;
        }

        val node = tail
        tail = node?.prev
        tail?.next = null
        return node?.value
    }

    fun unshift(value: T) { //insert value at front
        val node =  Node(value)
        if(head == null) {
            head = node
            tail = node
        } else {
            node.next = head
            head?.prev = node
            head = node
        }
    }

    fun shift(): T? { //remove value at front
        if (head == null) {
            return null
        }
        val node = head
        head = node?.next
        head?.prev = null
        return node?.value
    }

    class Node<T>(val value: T) {
        var prev: Node<T>? = null
        var next: Node<T>? = null
    }
}
