package org.katas

private const val highestDecimalColorValue = 255

@JvmInline
value class Color(private val hexadecimal: String) {
    private val red: Int
        get() = hexadecimal.substring(1, 3).toInt(16)
    private val green: Int
        get() = hexadecimal.substring(3, 5).toInt(16)
    private val blue: Int
        get() = hexadecimal.substring(5, 7).toInt(16)
    private val colors: List<Pair<BasePaletteColor, Int>>
        get() = listOf(
            Pair(BasePaletteColor.RED, highestDecimalColorValue - red),
            Pair(BasePaletteColor.GREEN, highestDecimalColorValue - green),
            Pair(BasePaletteColor.BLUE, highestDecimalColorValue - blue)
        )

    fun nearestColor(): BasePaletteColor = colors.minByOrNull { it.second }!!.first

    fun farthestColor(): BasePaletteColor = colors.maxByOrNull { it.second }!!.first
}
