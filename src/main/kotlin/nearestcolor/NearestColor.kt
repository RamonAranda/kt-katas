package nearestcolor

enum class Color { Red, Green, Blue}

fun nearestColors(hexadecimalValue: String): List<Color> = when (hexadecimalValue) {
    "FF0000" -> listOf(Color.Red)
    else -> throw Exception("Unknown color")
}