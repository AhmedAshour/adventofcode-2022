package day1

import readInput

fun main() {
    val input = readInput("src/day1","input").toString()
    val result = input.trim { it == '[' || it == ']'}.split(", , ").map { it.split(", ") }.map { it.sumOf { it.toInt() } }.sortedDescending()

    // Part 1
    println(result[0])

    // Part 2
    println(result.take(3).sum())
}
