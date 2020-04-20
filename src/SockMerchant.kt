import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val colorToCount = IntArray(101)
    for (color in ar)
        colorToCount[color]++
    var result = 0
    for (countOfColor in colorToCount)
        if (countOfColor > 0)
            result += countOfColor / 2
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
