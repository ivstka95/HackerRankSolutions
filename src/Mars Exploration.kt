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
 * Complete the 'marsExploration' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */
//https://www.hackerrank.com/challenges/three-month-preparation-kit-mars-exploration/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-two
fun marsExploration(s: String): Int {
    // Write your code here
    var counter = 0
    for (i in 0..<s.length) {
        if (s[i] != "SOS"[i % 3])
            counter++
    }
    return counter
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = marsExploration(s)

    println(result)
}
