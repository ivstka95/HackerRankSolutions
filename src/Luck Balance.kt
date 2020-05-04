import java.util.*

// Complete the luckBalance function below.
fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    var k = k
    val imp = PriorityQueue(Collections.reverseOrder<Int>())
    var luck = 0
    for (row in contests.indices) {
        if (contests[row][1] == 0)
            luck += contests[row][0]
        else
            imp.offer(contests[row][0])
    }
    var decreaseLuck = false
    while (!imp.isEmpty()) {
        if (k == 0) decreaseLuck = true
        if (decreaseLuck)
            luck -= imp.poll()
        else
            luck += imp.poll()
        k--
    }
    return luck
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
