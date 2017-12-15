package day1

import java.lang.Character.getNumericValue

private fun day1Common(input: String, nextDigit: (Int) -> Char): Int {
    return input
        .filterIndexed { index, digit -> digit == nextDigit(index) }
        .map { digit -> getNumericValue(digit) }
        .sum()
}

fun day1(input: String): Int {
    return day1Common(input, { index: Int -> input[(index + 1) % input.length] })
}

fun day1Bis(input: String): Int {
    return day1Common(input, { index: Int -> input[(index + (input.length / 2)) % input.length] })
}

fun main(args: Array<String>) {
    val input = ClassLoader.getSystemClassLoader().getResource("day1.txt").readText()
    println(day1(input))
    println(day1Bis(input))
}