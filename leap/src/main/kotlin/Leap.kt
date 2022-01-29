data class Year(val value: Int) {

    val isLeap: Boolean
        get() {
            return value % 4 == 0 && (value % 100 != 0 || value % 400 == 0)
        }
}
