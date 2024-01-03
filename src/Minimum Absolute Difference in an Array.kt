import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.min

// Complete the minimumAbsoluteDifference function below.
fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    arr.sort()
    var minDiff = (arr[0] - arr[1]).absoluteValue
    for (i in 1 until arr.lastIndex)
        minDiff = min(minDiff, (arr[i] - arr[i + 1]).absoluteValue)
    return minDiff
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}
