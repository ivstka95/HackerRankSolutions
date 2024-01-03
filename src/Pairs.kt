import java.util.*

// Complete the pairs function below.
fun pairs(k: Int, arr: Array<Int>): Int {
    var arr = arr.sortedArray()
    var i = 0
    var j = 1
    var count = 0

    while (j < arr.size) {
        val diff = arr[j] - arr[i]

        when {
            diff == k -> {
                count++
                j++
            }
            diff > k -> {
                i++
            }
            diff < k -> {
                j++
            }
        }
    }
    return count
}

fun main() {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val arr = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = pairs(k, arr)

    println(result)
}
