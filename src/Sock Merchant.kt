import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val missingPairColors = mutableSetOf<Int>()
    ar.forEach {
        if (missingPairColors.contains(it)) {
            missingPairColors.remove(it)
        } else {
            missingPairColors.add(it)
        }
    }
    return (n - missingPairColors.size) / 2
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
