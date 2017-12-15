package day4

import java.io.File

fun isValid(passphrase: String): Boolean {
    return !passphrase.contains("\\b(\\w+)\\b(.*)\\b\\1\\b".toRegex())
}

fun day4(passphrases: List<String>): Int {
    return passphrases
        .filter { it -> isValid(it) }
        .count()
}

fun sortWords(passphrase: String): String {
    return passphrase.split("\\s+".toRegex())
        .map { word -> word.toCharArray().sorted().toCharArray() }
        .joinToString(separator = " ") { sortedChars -> String(sortedChars)}
}

fun day4Bis(passphrases: List<String>): Int {
    return passphrases
        .map { it -> sortWords(it) }
        .filter { it -> isValid(it) }
        .count()
}

fun main(args: Array<String>) {
    val input = File(ClassLoader.getSystemClassLoader().getResource("day4.txt").file).readLines()
    println(day4(input))
    println(day4Bis(input))
}