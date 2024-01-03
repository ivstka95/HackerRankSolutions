import java.util.*
import kotlin.math.max

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var hourglassSum = Int.MIN_VALUE
    for (i in 1 until arr.lastIndex)
        for (j in 1 until arr.lastIndex)
            hourglassSum = max(hourglassSum, calculateHourglassSum(i, j, arr))
    return hourglassSum
}

fun calculateHourglassSum(i: Int, j: Int, arr: Array<Array<Int>>): Int {
    var sum = 0
    sum += arr[i - 1][j - 1]
    sum += arr[i - 1][j]
    sum += arr[i - 1][j + 1]
    sum += arr[i][j]
    sum += arr[i + 1][j - 1]
    sum += arr[i + 1][j]
    sum += arr[i + 1][j + 1]
    return sum
}

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
