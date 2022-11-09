package com.katas


private fun transformToRomanNumeral(numbers: List<Int>, scale: Scale, accumulated: String): String {
    val translatedNumber = scale.translate(numbers.first())
    val newTranslatedNumber = "${translatedNumber}${accumulated}"
    val remainingNumbers = numbers.drop(1)
    return if (scale is Scale.Thousands || remainingNumbers.isEmpty()) newTranslatedNumber
    else transformToRomanNumeral(numbers = remainingNumbers, scale = scale.next(), accumulated = newTranslatedNumber)
}

private fun Int.asList(): List<Int> = toString().map { it.toString().toInt() }

fun romanNumerals(number: Int): String =
    transformToRomanNumeral(numbers = number.asList().reversed(), scale = Scale.Units, accumulated = "")
