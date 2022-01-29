import java.math.BigInteger
import kotlin.random.Random

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger = Random.nextLong(1, prime.toLong()).toBigInteger()

    fun publicKey(prime: BigInteger, g: BigInteger, privateKey: BigInteger): BigInteger =
        g.modPow(privateKey, prime)

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger =
        publicKey.modPow(privateKey, prime)
}
