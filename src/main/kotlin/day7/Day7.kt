package day7

import java.io.File
import java.lang.Integer.parseInt

data class Program(
    val name: String,
    val weight: Int,
    var children: List<Program> = listOf(),
    var parent: Program? = null
) {
    val totalWeight: Int
        get() = weight + children.map { child -> child.totalWeight }.sum()

    override fun equals(other: Any?): Boolean {
        if (other is Program) {
            return other.name == name
        }
        return false
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    private fun withParent(parent: Program): Program {
        this.parent = parent
        return this
    }

    fun withChildren(children: List<Program>): Program {
        this.children = children.map { child -> child.withParent(this) }
        return this
    }

    fun isUnbalanced(): Boolean {
        val weights = children.groupBy { child -> child.totalWeight }
        return weights.keys.size > 1
    }
}

class ProgramTower(private val input: List<String>) {
    private val programsByName = mutableMapOf<String, Program>()

    init {
        input.forEach { line -> parseProgram(line) }
    }

    private fun findProgram(name: String): Program {
        return parseProgram(input.first { line -> line.startsWith("$name (") })
    }

    private fun parseProgram(line: String): Program {
        val matcher = "(\\w+) \\((\\d+)\\).*".toPattern().matcher(line)
        if (!matcher.matches()) {
            throw IllegalArgumentException()
        }

        val name = matcher.group(1)
        val weight = parseInt(matcher.group(2))
        if (programsByName.containsKey(name)) {
            return programsByName.getValue(name)
        }

        val program = Program(name, weight)

        val childrenMatcher = ".* -> (.*)".toPattern().matcher(line)
        if (childrenMatcher.matches()) {
            program.withChildren(childrenMatcher.group(1)
                .split(",\\s+".toRegex())
                .map { childName -> findProgram(childName) })
        }

        programsByName[name] = program

        return program
    }

    fun day7(): String {
        return programsByName.values
            .first { program -> program.parent == null }
            .name
    }

    fun day7Bis(): Int {
        // Start with leaves
        var programs = programsByName.values
            .filter { program -> program.children.isEmpty() }
            .toSet()

        do {
            val unbalanced = programs.find { program -> program.isUnbalanced() }

            if (unbalanced != null) {
                val weights = unbalanced.children.groupBy { child -> child.totalWeight }
                val normalWeight = weights.maxBy { entry -> entry.value.size }!!.toPair().first
                val unbalancedChild = weights.minBy { entry -> entry.value.size }!!.toPair().second[0]
                val differenceWithNormalWeight = Math.abs(normalWeight - unbalancedChild.totalWeight)
                return unbalancedChild.weight - differenceWithNormalWeight
            }

            programs = programs.mapNotNull { program -> program.parent }.toSet()
        } while (programs.isNotEmpty())

        return 0
    }

}


fun main(args: Array<String>) {
    val instructions = File(ClassLoader.getSystemClassLoader().getResource("day7.txt").file).readLines()
    val tower = ProgramTower(instructions)
    println(tower.day7())
    println(tower.day7Bis())

}