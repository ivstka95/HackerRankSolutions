import java.util.*

// Complete the countingValleys function below.
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

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
