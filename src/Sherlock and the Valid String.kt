import java.util.*

// Complete the isValid function below.
fun isValid(s: String): String {
    val count = IntArray(26) { 0 }
    for (c in s)
        count[c - 'a']++
    var first = -1
    var firstCount = 0
    var second = -1
    var secondCount = 0

    for (i in count) {
        if (i != 0) {
            if (first == -1 || first == i) {
                first = i
                firstCount++
            } else if (second == -1 || second == i) {
                second = i
                secondCount++
            } else {
                return "NO"
            }
        }
    }
    return when {
        second == -1 -> "YES"
        first > second -> if (firstCount == 1 && first - second == 1)
            "YES"
        else if (secondCount == 1)
            "YES"
        else
            "NO"
        else -> if (secondCount == 1 && second - first == 1)
            "YES"
        else if (firstCount == 1)
            "YES"
        else
            "NO"
    }
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
