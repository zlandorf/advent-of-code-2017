package day6

import java.lang.Integer.parseInt

data class Bank(val blocks: Int)

data class Configuration(private val banks: List<Bank>) {
    fun redistribute(): Configuration {
        val banks = banks.toMutableList()
        val biggestBank = banks.maxBy { bank -> bank.blocks }
        val blocksToRedistribute = biggestBank?.blocks ?: 0
        val indexOfBiggestBank = banks.indexOf(biggestBank)

        banks[indexOfBiggestBank] = Bank(0)
        var index = indexOfBiggestBank
        (0 until blocksToRedistribute).forEach {
            index = (index + 1) % banks.size
            banks[index] = Bank(1 + banks[index].blocks)
        }

        return Configuration(banks)
    }
}

fun parseInput(input: String): Configuration {
    return Configuration(input.split("\\s+".toRegex())
        .map { blocks -> Bank(parseInt(blocks)) }
        .toList())
}

fun day6(input: String): Int {
    val configurations = mutableListOf<Configuration>()
    var configuration = parseInput(input)
    var cycles = 0
    while (!configurations.contains(configuration)) {
        configurations.add(configuration)
        configuration = configuration.redistribute()
        cycles++
    }

    return cycles
}

fun day6Bis(input: String): Int {
    val configurations = mutableListOf<Configuration>()
    var configuration = parseInput(input)
    while (!configurations.contains(configuration)) {
        configurations.add(configuration)
        configuration = configuration.redistribute()
    }

    return configurations.size - configurations.indexOf(configuration)
}

fun main(args: Array<String>) {
    val input = ClassLoader.getSystemClassLoader().getResource("day6.txt").readText()
    println(day6(input))
    println(day6Bis(input))
}