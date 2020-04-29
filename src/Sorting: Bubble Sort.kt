import java.util.*

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>): Unit {
    var swaps = 0
    for (i in a.indices) {
        for (j in 0 until a.lastIndex) {
            // Swap adjacent elements if they are in decreasing order
            if (a[j] > a[j + 1]) {
                swaps++
                a[j] = a[j + 1].also { a[j + 1] = a[j] }
            }
        }
    }
    println("Array is sorted in $swaps swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    countSwaps(a)
}
