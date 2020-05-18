import java.util.*
import kotlin.math.max
import kotlin.math.min

// Complete the maxMin function below.
fun maxMin(k: Int, arr: Array<Int>): Int {
    var minUnFairness = Int.MAX_VALUE
    arr.sort()
    for (i in 0..arr.size - k)
        minUnFairness = min(minUnFairness, max(arr[i], arr[i + k - 1]) - min(arr[i], arr[i + k - 1]))
    return minUnFairness
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val k = scan.nextLine().trim().toInt()

    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}
