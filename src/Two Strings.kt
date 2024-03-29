import java.util.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    for (c in 'a'..'z')
        if (s1.contains(c) && s2.contains(c))
            return "YES"
    return "NO"
}

fun main() {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}