package com.katas


enum class Color {
    Red,
    Blue,
    Green,
    Yellow
}

fun mastermind(secret: List<Color>, guess: List<Color>): Pair<Int, Int> {
    val pairs = secret.zip(guess)
    val correctGuesses = calculateCorrectGuesses(pairs)
    val misplacedGuesses = calculateMisplacedGuesses(pairs)
    return Pair(correctGuesses, misplacedGuesses)
}

private fun calculateCorrectGuesses(pairs: List<Pair<Color, Color>>) =
    pairs.count { it.first == it.second }

private fun calculateMisplacedGuesses(pairs: List<Pair<Color, Color>>): Int {
    val (remainingSecret, remainingGuess) = pairs.filter { it.first != it.second }.unzip()
    val groupedRemainingSecret = remainingSecret.groupBy { it }.mapValues { it.value.count() }
    val groupedRemainingGuess = remainingGuess.groupBy { it }.mapValues { it.value.count() }
    return groupedRemainingGuess
        .map { minOf(groupedRemainingSecret.getOrDefault(it.key, 0), it.value) }
        .sum()
}
