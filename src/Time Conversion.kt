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
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
//https://www.hackerrank.com/challenges/three-month-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
fun timeConversion(s: String): String {
    var result = s.substringBeforeLast("PM").substringBeforeLast("AM")
    var isPM = s.endsWith("PM")
    var hour = result.substringBefore(":")
    hour = when {
        isPM -> {
            when (hour) {
                "12" -> "12"
                else -> (hour.toInt() + 12).toString()
            }
        }

        else -> {
            when (hour) {
                "12" -> "00"
                else -> hour
            }
        }
    }
    result = hour + ":" + result.substringAfter(":")
    return result
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
