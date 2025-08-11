import java.util.*

// Complete the countingValleys function below.
//https://www.hackerrank.com/challenges/three-month-preparation-kit-counting-valleys/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-two
fun countingValleys(n: Int, s: String): Int {
    var currentAltitude = 0
    var valleys = 0
    s.forEach {
        when (it) {
            'D' -> currentAltitude--
            'U' -> {
                currentAltitude++
                if (currentAltitude == 0)
                    valleys++
            }
        }
    }
    return valleys
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
