package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BowlingScoresTests : StringSpec({
    "it should calculate gutter balls" {
        val score = listOf(
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
            listOf(0, 0),
        )
        bowlingScores(score) shouldBe 0
    }
    "it should calculate simple score" {
        val score = listOf(
            listOf(3, 4),
            listOf(4, 3),
            listOf(1, 2),
            listOf(2, 1),
            listOf(5, 1),
            listOf(1, 5),
            listOf(2, 5),
            listOf(3, 5),
            listOf(1, 1),
            listOf(1, 0),
        )
        bowlingScores(score) shouldBe 50
    }
    "it should calculate spare scores" {
        val score = listOf(
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6),
            listOf(4, 6, 4),
        )
        bowlingScores(score) shouldBe 140
    }
    "it should calculate a perfect game" {
        val score = listOf(
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10),
            listOf(10, 10, 10),
        )
        bowlingScores(score) shouldBe 300
    }
    "it should calculate nine strikes followed by a gutter ball" {
        val score = listOf(
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(10, 0),
            listOf(0, 0),
        )
        bowlingScores(score) shouldBe 240
    }
    "it should calculate mixed scores from a real game" {
        val score = listOf(
            listOf(5, 5),       // Spare
            listOf(4, 0),       // Simple
            listOf(8, 1),       // Simple
            listOf(10, 0),      // Strike
            listOf(0, 10),      // Spare
            listOf(10, 0),      // Strike
            listOf(10, 0),      // Strike
            listOf(10, 0),      // Strike
            listOf(4, 6),       // Spare
            listOf(10, 10, 5),  // Strike+Strike+Nothing
        )
        bowlingScores(score) shouldBe 186
    }
})
