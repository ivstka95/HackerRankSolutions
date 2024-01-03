import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var cloud = 0
    var jumps = 0
    var move: Int
    while (cloud < c.lastIndex) {
        if (cloud + 2 > c.lastIndex || c[cloud + 2] == 1) {
            move = 1
        } else {
            move = 2
        }
        cloud += move
        jumps++
    }
    return jumps
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
