import java.util.*

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    var anagrams = 0
    for (i in 1 until s.length) {
        val stringMap = mutableMapOf<String, Int>()
        for (j in 0..s.length - i) {
            val substring = s.substring(j, j + i).toCharArray().sorted().joinToString("")
            stringMap.merge(substring, 1) { i1, i2 -> i1 + i2 }
        }
        stringMap.values.forEach { value -> anagrams += value * (value - 1) / 2 }
    }
    return anagrams
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()
        val result = sherlockAndAnagrams(s)
        println(result)
    }
}
