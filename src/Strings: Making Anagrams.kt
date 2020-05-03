import java.util.*
import kotlin.math.absoluteValue

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    val chars = mutableMapOf<Char, Int>()
    for (c in a) {
        chars.merge(c, 1) { i, i2 ->
            i + i2
        }
    }
    for (c in b) {
        chars.merge(c, -1) { i, i2 ->
            i + i2
        }
    }
    var deletions = 0
    chars.forEach { (c, i) -> deletions += i.absoluteValue }
    return deletions
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val a = scan.nextLine()

    val b = scan.nextLine()

    val res = makeAnagram(a, b)

    println(res)
}
