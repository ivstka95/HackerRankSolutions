import java.util.*

// Complete the whatFlavors function below.
fun whatFlavors(cost: Array<Int>, money: Int): Unit {
    val values = mutableSetOf<Int>()
    for (i in cost.indices) {
        if (values.contains(money - cost[i])) {
            println(listOf(cost.indexOfFirst { it == cost[i] } + 1,
                cost.indexOfLast { it == money - cost[i] } + 1)
                .sorted()
                .joinToString(
                    separator = " ",
                    prefix = "",
                    postfix = ""
                ))
            return
        }
        values.add(cost[i])
    }
}

fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()
    val costs = mutableListOf<Array<Int>>()
    val moneys = mutableListOf<Int>()
    for (tItr in 1..t) {
        val money = scan.nextLine().trim().toInt()
        moneys.add(money)

        val n = scan.nextLine().trim().toInt()

        val cost = scan.nextLine().split(" ").filter { it.isNotBlank() }.map { it.trim().toInt() }.toTypedArray()
        costs.add(cost)
    }
    for (i in 0 until t)
        whatFlavors(costs[i], moneys[i])
}
