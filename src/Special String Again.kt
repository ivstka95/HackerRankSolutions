import java.util.*

// Complete the substrCount function below.
fun substrCount(n: Int, s: String): Long {
    val s = "$s "
    val l = ArrayList<Point>()
    var count: Long = 1
    var ch = s[0]
    for (i in 1..n) {
        if (ch == s[i]) count++ else {
            l.add(Point(ch, count))
            count = 1
            ch = s[i]
        }
    }
    count = 0
    if (l.size >= 3) {
        val itr: Iterator<Point> = l.iterator()
        var prev: Point
        var curr: Point
        var next: Point
        curr = itr.next()
        next = itr.next()
        count = curr.count * (curr.count + 1) / 2
        for (i in 1 until l.size - 1) {
            prev = curr
            curr = next
            next = itr.next()
            count += curr.count * (curr.count + 1) / 2
            if (prev.key == next.key && curr.count == 1L) count += Math.min(prev.count, next.count)
        }
        count += next.count * (next.count + 1) / 2
    } else {
        for (curr in l) {
            count += curr.count * (curr.count + 1) / 2
        }
    }
    return count
}

private val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(n, s)

    println(result)
}


internal class Point(var key: Char, var count: Long)