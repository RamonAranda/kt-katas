package org.katas


sealed class DiamondRow {
    data class SingleLetterRow(val letter: Char, val outerPadding: Int) : DiamondRow() {
        override fun toString(): String = "${" ".repeat(outerPadding)}${letter}"
    }

    data class MultiLetterRow(val letter: Char, val outerPadding: Int, val innerPadding: Int) : DiamondRow() {
        override fun toString(): String = "${" ".repeat(outerPadding)}${letter}${" ".repeat(innerPadding)}${letter}"
    }
}

data class Diamond private constructor(private val rows: List<DiamondRow>) {
    override fun toString(): String = rows.joinToString("\n") { it.toString() }.trimIndent()

    companion object {
        operator fun invoke(letter: Char): Diamond {
            val untilCenter = ('A'..letter).toList()
            val fromCenter = untilCenter.reversed().drop(1)
            val rows = (untilCenter + fromCenter).map {
                val indexOfChar = untilCenter.indexOf(it)
                when (it) {
                    untilCenter.first() -> DiamondRow.SingleLetterRow(letter = it, outerPadding = untilCenter.size - 1)
                    else -> DiamondRow.MultiLetterRow(
                        letter = it,
                        outerPadding = untilCenter.size - indexOfChar - 1,
                        innerPadding = 2 * indexOfChar - 1
                    )
                }
            }
            return Diamond(rows)
        }
    }
}
