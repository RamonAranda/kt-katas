package nearestcolor

enum class Color(val position: Int) { Red(0), Green(1), Blue(2) }

enum class FindColorCriteria { Nearest, Farthest }

fun nearestColors(hexadecimalValue: String): List<Color> = findColors(hexadecimalValue, FindColorCriteria.Nearest)
fun farthestColors(hexadecimalValue: String): List<Color> = findColors(hexadecimalValue, FindColorCriteria.Farthest)

private fun findColors(hexadecimalValue: String, criteria: FindColorCriteria): List<Color> = hexadecimalValue
    .chunked(2)
    .mapIndexed { index, hexadecimalPortion -> Pair(index, Integer.decode("0x$hexadecimalPortion")) }
    .let { portions ->
        portions.map { portion ->
            Pair(
                portion.first, portion.second == when (criteria) {
                    FindColorCriteria.Nearest -> portions.maxOf { it.second }
                    FindColorCriteria.Farthest -> portions.minOf { it.second }
                })
        }
    }
    .filter { it.second }
    .map { Color.values().first { color -> color.position == it.first } }
