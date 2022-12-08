package day2

import readInput

fun main() {
    val input = readInput("src/day2", "input").toString()
    val formattedInput = input.trim { it == '[' || it == ']' }.split(",").map { it.trim() }

    println(partOne(formattedInput))
    println(partTwo(formattedInput))
}


fun partOne(input: List<String>): Int {
    // Column 1 (Opponent)
    // A -> Rock, B -> Paper, C -> Scissors

    // Column 2 (Me)
    // X -> Rock, Y -> Paper, Z -> Scissors

    // Single Round Score
    // 1 -> Rock, 2 -> Paper, 3 -> Scissors + outcome (Lost -> 0, Draw -> 3, Won -> 6)

    var totalScore = 0
    input.forEach {
        val myPlay = it[2]
        val opponentPlay = when (it[0]) {
            'A' -> 'X'
            'B' -> 'Y'
            'C' -> 'Z'
            else -> ' '
        }

        totalScore += when (myPlay) {
            'X' -> 1
            'Y' -> 2
            'Z' -> 3
            else -> 0
        }

        totalScore += when {
            myPlay == opponentPlay -> 3
            myPlay == 'X' && opponentPlay == 'Z' || myPlay == 'Y' && opponentPlay == 'X' || myPlay == 'Z' && opponentPlay == 'Y' -> 6
            else -> 0
        }
    }
    return totalScore
}

fun partTwo(input: List<String>): Int {
    // Column 1 (Opponent)
    // A -> Rock, B -> Paper, C -> Scissors

    // Column 2 (Me)
    // X -> Lose, Y -> Draw, Z -> Win

    // Single Round Score
    // 1 -> Rock, 2 -> Paper, 3 -> Scissors + outcome (Lost -> 0, Draw -> 3, Won -> 6)

    var totalScore = 0
    input.forEach {
        val expectedOutcome = it[2]
        val opponentPlay = when (it[0]) {
            'A' -> 'X'
            'B' -> 'Y'
            'C' -> 'Z'
            else -> ' '
        }

        totalScore += when (expectedOutcome) {
            'Y' -> 3
            'Z' -> 6
            else -> 0
        }

        totalScore += when {
            opponentPlay == 'X' && expectedOutcome == 'Z' || opponentPlay == 'Y' && expectedOutcome == 'Y' || opponentPlay == 'Z' && expectedOutcome == 'X' -> 2
            opponentPlay == 'X' && expectedOutcome == 'X' || opponentPlay == 'Y' && expectedOutcome == 'Z' || opponentPlay == 'Z' && expectedOutcome == 'Y' -> 3
            else -> 1
        }
    }
    return totalScore

}
