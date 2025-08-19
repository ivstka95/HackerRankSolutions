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
 * Complete the 'twoArrays' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY A
 *  3. INTEGER_ARRAY B
 */
//https://www.hackerrank.com/challenges/three-month-preparation-kit-two-arrays/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-three
fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {
    // Write your code here
    A.sort()
    B.sortDescending()
    for (i in A.indices) {
        if (A[i] + B[i] < k)
            return "NO"
    }
    return "YES"
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val k = first_multiple_input[1].toInt()

        val A = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val B = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = twoArrays(k, A, B)

        println(result)
    }
}
