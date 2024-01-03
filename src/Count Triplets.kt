// Complete the countTriplets function below.
fun countTriplets(arr: IntArray, r: Int): Long {
    var count: Long = 0
    val map2 = mutableMapOf<Int, Long>()
    val map3 = mutableMapOf<Int, Long>()
    for (i in arr) {
        val dupletsCount = map3[i]
        if (dupletsCount != null)
            count += dupletsCount
        val singlesCount = map2[i]
        if (singlesCount != null)
            map3.merge(i * r, singlesCount) { i1, i2 -> i1 + i2 }
        map2.merge(i * r, 1) { i1, i2 -> i1 + i2 }
    }
    return count
}

fun main() {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray().toIntArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
