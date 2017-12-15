package day3

fun day3(input: Int): Int {
    var layer = 1
    while (true) {
        val layerWidth = (layer - 1) * 2 + 1 // the first layer has an index of 1
        val maxLayerValue = layerWidth * layerWidth

        if (input < maxLayerValue) {
            val corners = (3 downTo 0).map { i -> maxLayerValue - (i * (layerWidth - 1))}

            val distanceToNearestCorner = corners
                .map { corner -> Math.abs(corner - input) }
                .min() ?: 0

            return layerWidth - distanceToNearestCorner - 1
        }
        layer++
    }
}

fun coordinatesSequence(layer: Int): List<Pair<Int, Int>> {
    if (layer == 1) {
        return listOf(Pair(0, 0))
    }
    val layerWidth = (layer - 1) * 2 + 1

    return (1 - layer + 1 until layer).map { i -> Pair(layer - 1, i) } // just above the on the bottom right corner, go to the top right corner
        .plus((1 until layerWidth).map { i -> Pair(layer - i - 1, layer - 1) }) // go to the top left corner
        .plus((1 until layerWidth).map { i -> Pair(1 - layer, layer - i - 1) }) // go to the bottom left corner
        .plus((1 until layerWidth).map { i -> Pair(1 - layer + i, 1 - layer) }) // go to the bottom right corner
}


fun day3Bis(input: Int): Int {
    val values = Array(400, { IntArray(400, { 0 })})
    val offset = 200
    var layer = 2
    values[offset][offset] = 1

    while (true) {
        coordinatesSequence(layer).forEach { coords ->
            val neighbourValues = (-1 .. 1)
                .flatMap { x -> (-1 .. 1).map { y -> Pair(x, y) } }
                .map { pair -> Pair(pair.first + offset + coords.first, pair.second + offset + coords.second) }
                .map { neighbour -> values[neighbour.first][neighbour.second] }
                .sum()

            println(neighbourValues)

            if (neighbourValues > input) {
                return neighbourValues
            }

            values[coords.first + offset][coords.second + offset] = neighbourValues
        }
        layer++
    }
}

fun main(args: Array<String>) {
    println(day3(347991))
    println(day3Bis(347991))
}