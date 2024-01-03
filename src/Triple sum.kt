import java.util.*

// Complete the triplets function below.
fun triplets(a: Array<Int>, b: Array<Int>, c: Array<Int>): Long {
    var a = a.toSet().toIntArray().sorted()
    var b = b.toSet().toIntArray().sorted()
    var c = c.toSet().toIntArray().sorted()

    var ai = 0
    var bi = 0
    var ci = 0
    var ans: Long = 0

    while (bi < b.size) {
        while (ai < a.size && b[bi] >= a[ai])
            ai++

        while (ci < c.size && b[bi] >= c[ci])
            ci++

        ans += ai.toLong() * ci.toLong()
        bi += 1
    }
    return ans
}

fun main() {
    val scan = Scanner(System.`in`)

    val lenaLenbLenc = scan.nextLine().split(" ")

    val lena = lenaLenbLenc[0].trim().toInt()

    val lenb = lenaLenbLenc[1].trim().toInt()

    val lenc = lenaLenbLenc[2].trim().toInt()

    val arra = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val arrb = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val arrc = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val ans = triplets(arra, arrb, arrc)

    println(ans)
}
