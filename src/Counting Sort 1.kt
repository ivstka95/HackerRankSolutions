import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'countingSort' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */
//https://www.hackerrank.com/challenges/three-month-preparation-kit-countingsort1/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-two
fun countingSort(arr: Array<Int>): Array<Int> {
    val frequency = Array<Int>(100) { 0 }
    arr.forEach { frequency[it] = frequency[it] + 1 }
    return frequency
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = countingSort(arr)

    println(result.joinToString(" "))
}
