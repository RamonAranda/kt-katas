package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MastermindTests : StringSpec({
    "it should guess a simple key" {
        mastermind(secret = listOf(Color.Yellow), guess = listOf(Color.Blue)) shouldBe Pair(0, 0)
        mastermind(secret = listOf(Color.Yellow), guess = listOf(Color.Yellow)) shouldBe Pair(1, 0)
    }

    "it should guess a 2 point key" {
        val secret = listOf(Color.Yellow, Color.Blue)
        mastermind(secret = secret, guess = listOf(Color.Red, Color.Red)) shouldBe Pair(0, 0)
        mastermind(secret = secret, guess = listOf(Color.Green, Color.Red)) shouldBe Pair(0, 0)
        mastermind(secret = secret, guess = listOf(Color.Yellow, Color.Yellow)) shouldBe Pair(1, 0)
        mastermind(secret = secret, guess = listOf(Color.Red, Color.Yellow)) shouldBe Pair(0, 1)
        mastermind(secret = secret, guess = listOf(Color.Blue, Color.Yellow)) shouldBe Pair(0, 2)
        mastermind(secret = secret, guess = secret) shouldBe Pair(2, 0)
    }

    "it should guess a complex key" {
        val secret = listOf(Color.Yellow, Color.Blue, Color.Green, Color.Red)
        mastermind(
            secret = secret,
            guess = listOf(Color.Red, Color.Red, Color.Red, Color.Red)
        ) shouldBe Pair(1, 0)
        mastermind(
            secret = secret,
            guess = listOf(Color.Red, Color.Red, Color.Blue, Color.Blue)
        ) shouldBe Pair(0, 2)
        mastermind(
            secret = secret,
            guess = listOf(Color.Yellow, Color.Red, Color.Green, Color.Blue)
        ) shouldBe Pair(2, 2)
        mastermind(
            secret = secret,
            guess = listOf(Color.Yellow, Color.Red, Color.Green, Color.Red)
        ) shouldBe Pair(3, 0)
        mastermind(secret = secret, guess = secret) shouldBe Pair(4, 0)
    }
    "it should guess a misplaced but repeated colors" {
        mastermind(
            secret = listOf(Color.Yellow, Color.Blue, Color.Yellow, Color.Blue, Color.Yellow),
            guess = listOf(Color.Blue, Color.Yellow, Color.Red, Color.Yellow, Color.Blue)
        ) shouldBe Pair(0, 4)
        mastermind(
            secret = listOf(Color.Yellow, Color.Blue, Color.Red, Color.Blue, Color.Red),
            guess = listOf(Color.Blue, Color.Yellow, Color.Red, Color.Yellow, Color.Blue)
        ) shouldBe Pair(1, 3)
    }
})
