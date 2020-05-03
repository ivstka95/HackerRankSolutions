import java.util.*

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {
    var count = 0
    for (j in 0 until s.length - 1) {
        if (s[j] == s[j + 1]) count++
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = alternatingCharacters(s)

        println(result)
    }
}
