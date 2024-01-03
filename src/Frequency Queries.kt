// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val numbersToCount = mutableMapOf<Int, Int>()
    val countToNumbers = mutableMapOf<Int, MutableSet<Int>>()
    val result = mutableListOf<Int>()

    fun updateCountToNumbers(number: Int, oldCount: Int, newCount: Int) {
        countToNumbers[oldCount]?.remove(number)
        var newCountNumbers = countToNumbers[newCount]
        if (newCountNumbers == null) {
            newCountNumbers = mutableSetOf(number)
            countToNumbers[newCount] = newCountNumbers
        } else newCountNumbers.add(number)
    }

    queries.forEach { query ->
        val operation = query[0]
        val number = query[1]
        when (operation) {
            1 -> {
                val oldNumberCount = numbersToCount[number] ?: 0
                val newNumberCount = oldNumberCount + 1
                numbersToCount[number] = newNumberCount
                updateCountToNumbers(number, oldNumberCount, newNumberCount)
            }
            2 -> {
                val oldNumberCount = numbersToCount[number] ?: 0
                val newNumberCount = if (oldNumberCount > 0) oldNumberCount - 1 else 0
                numbersToCount[number] = newNumberCount
                updateCountToNumbers(number, oldNumberCount, newNumberCount)
            }
            3 -> result.add(if (countToNumbers[number]?.isNotEmpty() == true) 1 else 0)
        }
    }
    return result.toTypedArray()
}

fun main() {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}