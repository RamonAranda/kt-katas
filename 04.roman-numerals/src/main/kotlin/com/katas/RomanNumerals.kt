package com.katas

sealed class Scale {
    abstract fun translate(number: Int): String
    abstract fun next(): Scale

    object Units : Scale() {
        override fun next(): Scale = Tens
        override fun translate(number: Int): String =
            when (number) {
                4 -> "IV"
                9 -> "IX"
                else -> "${if ((number / 5) >= 1) "V" else ""}${"I".repeat(number % 5)}"
            }
    }

    object Tens : Scale() {
        override fun next(): Scale = Hundreds
        override fun translate(number: Int): String =
            when (number) {
                4 -> "XL"
                9 -> "XC"
                else -> "${if ((number / 5) >= 1) "L" else ""}${"X".repeat(number % 5)}"
            }
    }

    object Hundreds : Scale() {
        override fun next(): Scale = Thousands
        override fun translate(number: Int): String =
            when (number) {
                4 -> "CD"
                9 -> "CM"
                else -> "${if ((number / 5) >= 1) "D" else ""}${"C".repeat(number % 5)}"
            }
    }

    object Thousands : Scale() {
        override fun next(): Scale = Thousands
        override fun translate(number: Int): String = "M".repeat(number)
    }
}


fun foo(numbers: List<Int>, scale: Scale, accumulated: String): String {
    val translatedNumber = scale.translate(numbers.first())
    val newTranslatedNumber = "${translatedNumber}${accumulated}"
    val remainingNumbers = numbers.drop(1)
    return if (scale is Scale.Thousands || remainingNumbers.isEmpty()) newTranslatedNumber
    else foo(numbers = remainingNumbers, scale = scale.next(), accumulated = newTranslatedNumber)
}

fun romanNumerals(number: Int): String {
    val a = number.toString()
        .map { it.toString().toInt() }
        .reversed()
    return foo(a, Scale.Units, "")
}
