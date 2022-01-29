object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if(list.isEmpty()) throw NoSuchElementException()

        var start = 0
        var end = list.lastIndex
        while(start <= end) {
            var mid = (start + end) / 2
            when {
                list[mid] == item -> return mid
                list[mid] < item  -> start = mid + 1
                list[mid] > item  -> end = mid - 1
            }
        }
        throw NoSuchElementException()
    }
}
