import java.util.*

// Complete the countInversions function below.
fun countInversions(arr: Array<Int>): Long {
    return mergeSortAndCount(arr.toIntArray(), 0, arr.lastIndex)
}

// Function to count the number of inversions
// during the merge process
private fun mergeAndCount(arr: IntArray, l: Int, m: Int, r: Int): Long {

    // Left subarray
    val left = Arrays.copyOfRange(arr, l, m + 1)

    // Right subarray
    val right = Arrays.copyOfRange(arr, m + 1, r + 1)
    var i = 0
    var j = 0
    var k = l
    var swaps: Long = 0
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) arr[k++] = left[i++] else {
            arr[k++] = right[j++]
            swaps += m + 1 - (l + i)
        }
    }

    // Fill from the rest of the left subarray
    while (i < left.size) arr[k++] = left[i++]

    // Fill from the rest of the right subarray
    while (j < right.size) arr[k++] = right[j++]
    return swaps
}

// Merge sort function
private fun mergeSortAndCount(arr: IntArray, l: Int, r: Int): Long {

    // Keeps track of the inversion count at a
    // particular node of the recursion tree
    var count: Long = 0
    if (l < r) {
        val m = (l + r) / 2

        // Total inversion count = left subarray count
        // + right subarray count + merge count

        // Left subarray count
        count += mergeSortAndCount(arr, l, m)

        // Right subarray count
        count += mergeSortAndCount(arr, m + 1, r)

        // Merge count
        count += mergeAndCount(arr, l, m, r)
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val arr = scan.nextLine()
            .split(" ")
            .map {
                it
                    .trim()
                    .toInt()
            }
            .toTypedArray()

        val result = countInversions(arr)

        println(result)
    }
}
