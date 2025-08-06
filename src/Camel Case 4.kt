import java.io.*
import java.util.*


//https://www.hackerrank.com/challenges/three-month-preparation-kit-camel-case/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=three-month-week-one

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    var input = readlnOrNull()?.trim()
    while (!input.isNullOrEmpty()) {
        println(processInput(input))
        input = readlnOrNull()?.trim()
    }
}

fun processInput(input: String): String {
    var result = ""
    val array = input.split(";")
    val command = array[0]
    val type = array[1]
    val words = array[2]
    when (command) {
        "C" -> result = combine(type, words)
        "S" -> result = split(words)
    }
    return result
}

fun combine(type: String, words: String): String {
    val array = words.split(" ")
    var result = ""
    array.forEachIndexed { index, word ->
        val firstChar = word[0]
        when {
            type == "C" -> result += word.replaceFirst(firstChar, firstChar.uppercaseChar())
            else -> {
                when (index) {
                    0 -> result += word
                    else -> result += word.replaceFirst(firstChar, firstChar.uppercaseChar())
                }
            }
        }
    }
    if (type == "M")
        result += "()"
    return result
}

fun split(words: String): String {
    var result = ""
    var wordStartIndex = 0
    words.forEachIndexed { index, char ->
        if ((char.isUpperCase() && index > 0)) {
            result += words.substring(wordStartIndex, index) + " "
            wordStartIndex = index
        }
        if (index == words.length - 1) {
            result += words.substring(wordStartIndex)
        }

    }
    result = result.replace("()", "").lowercase()
    return result
}