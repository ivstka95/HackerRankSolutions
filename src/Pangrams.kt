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
 * Complete the 'pangrams' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
//https://www.hackerrank.com/challenges/three-month-preparation-kit-pangrams/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-two
fun pangrams(s: String): String {
    // Write your code here
    val az = ('a'..'z').toMutableSet()
    var i = 0
    while (az.isNotEmpty() && i < s.length) {
        az.remove(s[i].lowercaseChar())
        i++
    }
    return when (az.isEmpty()) {
        true -> "pangram"
        false -> "not pangram"
    }
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = pangrams(s)

    println(result)
}
