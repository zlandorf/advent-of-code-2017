package day9

fun String.removeCancelledCharacters(): String {
    return this.replace("!.".toRegex(), "")
}

fun String.cleanGarbage(): String {
    return this
        .removeCancelledCharacters()
        .replace("<[^>]*>".toRegex(), "")
}

fun String.extractChildren(): List<Group> {
    if (this == "{}") {
        return listOf()
    }
    var childStartIndex = 1
    val childrenGroups = mutableListOf<String>()
    do {
        var openingBracketsCount = 0
        val childEndIndex: Int = this
            .substring(childStartIndex)
            .indexOfFirst { c ->
                if (c == '{') openingBracketsCount++
                if (c == '}') openingBracketsCount--
                openingBracketsCount == 0
            } + childStartIndex + 1

        childStartIndex = if (childEndIndex > childStartIndex) {
            childrenGroups.add(this.substring(childStartIndex, childEndIndex))
            childEndIndex
        } else {
            // No children found
            this.length
        }

    } while (childStartIndex < this.length - 1)

    return childrenGroups
        .filter { it != "," }
        .map { childGroup -> Group(childGroup.extractChildren()) }
}

data class Group(private val children: List<Group>) {
    fun score(parentScore: Int = 1): Int {
        if (children.isEmpty()) {
            return parentScore
        }
        return parentScore + children.sumBy { child -> child.score(parentScore + 1) }
    }
}

fun day9(input: String): Int {
    val group = Group(input
        .cleanGarbage()
        .extractChildren()
    )

    return group.score()
}

fun day9Bis(input: String): Int {
    val clean = input.removeCancelledCharacters()
    val matcher = "<([^>]*)>".toPattern().matcher(clean)

    var result = 0
    while (matcher.find()) {
        result += matcher.group().length - 2
    }

    return result
}

fun main(args: Array<String>) {
    val input = ClassLoader.getSystemClassLoader().getResource("day9.txt").readText()

    println(day9(input))
    println(day9Bis(input))

}