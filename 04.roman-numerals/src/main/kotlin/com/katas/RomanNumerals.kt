package com.katas

private val romanValues = mapOf(
    1 to "I",
    5 to "V",
    10 to "X",
    50 to "L",
    100 to "C",
    500 to "D",
    1000 to "M",
)

fun romanNumerals(number: Int): String = romanValues.getOrDefault(number, "")
