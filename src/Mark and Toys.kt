import java.util.*

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
    prices.sort()
    var moneyLeft = k
    var toysCount = 0
    var i = 0
    while (moneyLeft > 0) {
        if (moneyLeft - prices[i] >= 0) {
            moneyLeft -= prices[i]
            toysCount++
            i++
        } else break
    }
    return toysCount
}

fun main() {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val prices = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}
