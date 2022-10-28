package nearestcolor

enum class Color { Red, Green, Blue}

fun nearestColors(hexadecimalValue: String): List<Color> = when (hexadecimalValue) {
    "FF0000" -> listOf(Color.Red)
    "00FF00" -> listOf(Color.Green)
    "0000FF" -> listOf(Color.Blue)
    else -> throw Exception("Unknown color")
}
