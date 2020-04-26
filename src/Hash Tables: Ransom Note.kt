import java.util.*

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val magazineWords = magazine.groupingBy { it }.eachCount()
    val noteWords = note.groupingBy { it }.eachCount()
    noteWords.forEach { (s, i) ->
        val countInMagazine = magazineWords[s]
        if (countInMagazine == null || countInMagazine < i) {
            println("No")
            return
        }
    }
    println("Yes")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    scan.nextLine()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}