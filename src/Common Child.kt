import java.util.*

// Complete the commonChild function below.
fun commonChild(s1: String, s2: String): Int {
    val mat =
        Array(s1.length + 1) { IntArray(s2.length + 1) }
    for (i in 0..s1.length) {
        mat[i][0] = 0
        mat[0][i] = 0
    }
    for (i in s1.indices) {
        for (j in s2.indices) {
            if (s1[i] == s2[j]) {
                mat[i + 1][j + 1] = mat[i][j] + 1
            } else {
                mat[i + 1][j + 1] =
                    if (mat[i + 1][j] > mat[i][j + 1]) mat[i + 1][j] else mat[i][j + 1]
            }
        }
    }
    return mat[s1.length][s1.length]
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s1 = scan.nextLine()

    val s2 = scan.nextLine()

    val result = commonChild(s1, s2)

    println(result)
}
