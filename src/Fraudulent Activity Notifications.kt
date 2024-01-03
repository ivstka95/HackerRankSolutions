import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    if (d >= expenditure.size) return 0
    var numNotifications = 0
    val trailingArr = IntArray(d)
    for (i in trailingArr.indices) {
        trailingArr[i] = expenditure[i]
    }
    Arrays.sort(trailingArr)
    for (i in d until expenditure.size) {
        val median = findMedian(trailingArr)
        if (expenditure[i] >= 2.0 * median) {
            numNotifications += 1
        }
        val nextToRemoveElement = expenditure[i - d]
        val toInsertElement = expenditure[i]
        adjustTrailingArray(trailingArr, nextToRemoveElement, toInsertElement)
    }
    return numNotifications
}

fun findMedian(a: IntArray): Double {
    val n = a.size
    return if (n % 2 != 0) a[n / 2].toDouble() else (a[(n - 1) / 2] + a[n / 2]).toDouble() / 2.0
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

//This whole thing is O(d) time. Note that we are not sorting again as trailing array was already sorted
// as preprocessing and now only one new element has to find its position in sorted array.

//This whole thing is O(d) time. Note that we are not sorting again as trailing array was already sorted
// as preprocessing and now only one new element has to find its position in sorted array.
private fun adjustTrailingArray(trailingArr: IntArray, elementToRemove: Int, elementToInsert: Int) {
    if (elementToInsert == elementToRemove) return
    var foundIndex = 0

    //The first element of unsorted trailing array will move out of the sliding window
    //Since the trailing array was sorted by us, we have lost the position of its first element in original array.
    //Hence, I search linearly for it and replace it with the new element.
    while (foundIndex < trailingArr.size) {
        if (trailingArr[foundIndex] != elementToRemove) {
            foundIndex++
        } else {
            trailingArr[foundIndex] = elementToInsert
            break
        }
    }

    //Now we bubble the new element just inserted using bubble sort to left/right based on whether it was bigger
    //or smaller than the element that got removed.
    if (elementToInsert > elementToRemove) {
        var i = foundIndex
        while (i < trailingArr.size - 1) {
            i += if (trailingArr[i] > trailingArr[i + 1]) {
                swap(trailingArr, i, i + 1)
                1
            } else break
        }
    } else {
        var i = foundIndex
        while (i > 0) {
            i -= if (trailingArr[i] < trailingArr[i - 1]) {
                swap(trailingArr, i, i - 1)
                1
            } else break
        }
    }
}
