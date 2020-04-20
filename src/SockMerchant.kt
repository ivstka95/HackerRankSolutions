import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val missingPairColors = mutableListOf<Int>()
    ar.forEach {
        if (missingPairColors.contains(it)) {
            missingPairColors.remove(it)
        } else {
            missingPairColors.add(it)
        }
    }
    return (n - missingPairColors.size) / 2
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
