import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val m = scan.nextInt()

    //This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
    val arr = LongArray(n)

    var lower: Int
    var upper: Int
    var sum: Long

    for (i in 0 until n) arr[i] = 0

    for (i in 0 until m) {
        lower = scan.nextInt()
        upper = scan.nextInt()
        sum = scan.nextInt().toLong()
        arr[lower - 1] += sum
        if (upper < n) arr[upper] -= sum
    }

    var max: Long = 0
    var temp: Long = 0

    for (i in 0 until n) {
        temp += arr[i]
        if (temp > max) max = temp
    }

    println(max)
}