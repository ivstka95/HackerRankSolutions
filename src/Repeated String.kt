import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long) =
    (n / s.length) * s.count { it == 'a' } +
            if (n % s.length > 0)
                s.substring(0, (n % s.length).toInt()).count { it == 'a' }
            else 0

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
