package day8

import java.io.File
import java.lang.Integer.parseInt

data class Registry(val value: Int = 0) {
    fun inc(amount: Int): Registry {
        return Registry(value + amount)
    }

    fun dec(amount: Int): Registry {
        return Registry(value - amount)
    }

    fun operation(operation: String, amount: Int) = when(operation) {
        "inc" -> inc(amount)
        "dec" -> dec(amount)
        else -> throw IllegalArgumentException()
    }

    fun condition(condition: String, amount: Int) = when (condition) {
        ">" -> value > amount
        ">=" -> value >= amount
        "<" -> value < amount
        "<=" -> value <= amount
        "==" -> value == amount
        "!=" -> value != amount
        else -> throw IllegalArgumentException()
    }

}

fun day8(instructions: List<String>): Pair<Int, Int> {
    val registryMap = mutableMapOf<String, Registry>()

    var maxValue = 0

    instructions.forEach { line ->
        val matcher = "(\\w+) (inc|dec) (-?\\d+) if (\\w+) (>|>=|<|<=|==|!=) (-?\\d+)".toPattern().matcher(line)
        if (matcher.matches()) {
            val registryName = matcher.group(1)
            val registry = registryMap.getOrDefault(registryName, Registry(0))

            val operation = matcher.group(2)
            val amount = parseInt(matcher.group(3))

            val conditionRegistry = registryMap.getOrDefault(matcher.group(4), Registry(0))
            val condition = matcher.group(5)
            val conditionAmount = parseInt(matcher.group(6))

            if (conditionRegistry.condition(condition, conditionAmount)) {
                val modifiedRegistry = registry.operation(operation, amount)

                if (modifiedRegistry.value > maxValue) {
                    maxValue = modifiedRegistry.value
                }

                registryMap.put(registryName, modifiedRegistry)
            }
        } else {
            throw IllegalArgumentException("Cannot parse line : $line")
        }
    }

    return Pair(registryMap.values.maxBy { it.value }?.value ?: 0, maxValue)
}


fun main(args: Array<String>) {
    val instructions = File(ClassLoader.getSystemClassLoader().getResource("day8.txt").file).readLines()

    val result = day8(instructions)

    println(result.first)
    println(result.second)
}