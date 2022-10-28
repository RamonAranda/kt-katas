package nearestcolor

enum class Color { Red, Green, Blue }

fun nearestColors(hexadecimalValue: String): List<Color> = hexadecimalValue
    .chunked(2)
    .mapIndexed { index, hexadecimalPortion ->
        when (index) {
            0 -> Pair(Color.Red, hexadecimalPortion)
            1 -> Pair(Color.Green, hexadecimalPortion)
            2 -> Pair(Color.Blue, hexadecimalPortion)
            else -> throw Exception("Invalid hexadecimal value")
        }
    }
    .filter { it.second == "FF" }
    .map { it.first }
