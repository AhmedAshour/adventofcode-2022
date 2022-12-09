package day3

import readInput

fun main() {
    val input = readInput("src/day3", "input").toString()
    val formattedInput = input.trim { it == '[' || it == ']' }.split(",").map { it.trim() }
    println(partOne(formattedInput))
    println(partTwo(formattedInput))
}


fun partOne(input: List<String>): Int {
    var prioritiesSum = 0
    input.forEach {
        val firstCompartment = it.substring(0, it.length / 2)
        val secondCompartment = it.substring(it.length / 2, it.length)

        val charsFreq = firstCompartment.toSet()
        var duplicateChar = ' '
        secondCompartment.forEach { char ->
            if (charsFreq.contains(char)) duplicateChar = char
        }
        val priority = (duplicateChar - 'a') + 1
        prioritiesSum += if (priority > 0) priority else (duplicateChar - 'A') + 27
    }
    return prioritiesSum
}

fun partTwo(input: List<String>): Int {
    var prioritiesSum = 0
    for (i in input.indices step 3) {
        val firstPerson = input[i].toSet()
        val secondPerson = input[i + 1].toSet()
        input[i + 2].toSet().forEach { char ->
            val x = firstPerson.contains(char)
            val y = secondPerson.contains(char)
            if (x && y) {
                val priority = (char - 'a') + 1
                prioritiesSum += if (priority > 0) priority else (char - 'A') + 27
            }
        }
    }
    return prioritiesSum
}
