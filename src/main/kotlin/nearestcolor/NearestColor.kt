package nearestcolor

enum class Color(val position: Int) { Red(0), Green(1), Blue(2) }

fun nearestColors(hexadecimalValue: String): List<Color> = hexadecimalValue
    .chunked(2)
    .mapIndexed { index, hexadecimalPortion -> Pair(index, Integer.decode("0x$hexadecimalPortion")) }
    .let { portions -> portions.map { portion -> Pair(portion.first, portion.second == portions.maxOf { it.second }) } }
    .filter { it.second }
    .map { Color.values().first { color -> color.position == it.first } }
