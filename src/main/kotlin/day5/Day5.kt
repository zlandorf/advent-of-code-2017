package day5

import java.io.File
import java.lang.Integer.parseInt

fun day5(input: List<String>): Int {
    val instructions = input.map { offset -> parseInt(offset) }.toMutableList()
    var instruction = 0
    var steps = 0

    while (instruction >= 0 && instruction < instructions.size) {
        ++steps
        instruction += instructions[instruction]++
    }

    return steps
}

fun day5Bis(input: List<String>): Int {
    val instructions = input.map { offset -> parseInt(offset) }.toMutableList()
    var instruction = 0
    var steps = 0

    while (instruction >= 0 && instruction < instructions.size) {
        ++steps
        val offset = instructions[instruction]
        if (offset >= 3) {
            instructions[instruction]--
        } else {
            instructions[instruction]++
        }
        instruction += offset
    }

    return steps
}

fun main(args: Array<String>) {
    val instructions = File(ClassLoader.getSystemClassLoader().getResource("day5.txt").file).readLines()
    println(day5(instructions))
    println(day5Bis(instructions))
}