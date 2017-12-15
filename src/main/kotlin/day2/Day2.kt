package day2

import java.io.File

val parseRow = fun String.(): List<Int> {
    return this.split("\\s+".toRegex())
        .map { s -> s.toInt() }
}

fun day2(rows: List<String>): Int {
    return rows
        .map(parseRow)
        .map { numbers -> numbers.max()?.minus(numbers.min() ?: 0) ?: 0 }
        .sum()
}

fun day2Bis(rows: List<String>): Int {
    return rows
        .map(parseRow)
        .map { numbers ->
            numbers.map { number -> numbers // For each number on the row, we try to find the number that it can divide and return the result
                .filter { other -> other != number } // Compare the current number to other numbers, not itself
                .map { other ->
                    if (other % number == 0) { // Other is divisible by number, return the result of the division
                        other / number
                    } else {
                        0
                    }
                }
                .sum()
            }.sum()
        }
        .sum()
}


fun main(args: Array<String>) {
    val input = File(ClassLoader.getSystemClassLoader().getResource("day2.txt").file).readLines()
    println(day2(input))
    println(day2Bis(input))
}