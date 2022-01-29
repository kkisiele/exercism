import kotlin.IllegalStateException

class BankAccount {
    private var closed = false
    private var current: Long = 0

    val balance: Long
        @Synchronized
        get() {
            if(closed) throw IllegalStateException()
            return current
        }

    @Synchronized
    fun adjustBalance(amount: Long){
        if(closed) throw IllegalStateException()
        current += amount
    }

    @Synchronized
    fun close() {
        closed = true
    }
}
