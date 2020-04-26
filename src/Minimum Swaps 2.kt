import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    for (i in arr.indices) {
        while (arr[i] != i + 1) {
            arr.swap(i, arr[i] - 1)
            swaps++
        }
    }
    return swaps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}
