package com.katas

private fun List<Int>.isStrike(): Boolean = first() == 10
private fun List<Int>.isGutterBall(): Boolean = sum() == 0
private fun List<Int>.isSpare(): Boolean = subList(0, 2).sum() == 10
private fun List<Int>.firstThrow() = first()
private fun List<Int>.allStrikes() = all { it == 10 }

fun bowlingScores(scores: List<List<Int>>): Int =
    scores.mapIndexed { index, turn ->
        val isLastTurn = index == scores.size - 1
        val (firstThrow, secondThrow) = turn
        when {
            isLastTurn -> turn.sum()
            turn.isStrike() -> calculateStrike(scores[index + 1], scores.getOrNull(index + 2))
            turn.isGutterBall() -> 0
            turn.isSpare() -> turn.sum() + scores[index + 1].firstThrow()
            else -> firstThrow + secondThrow
        }
    }.sum()

private fun calculateStrike(nextTurn: List<Int>, nextNextTurn: List<Int>?): Int {
    val nextTurnIsLastTurn = nextNextTurn == null
    return when {
        nextTurnIsLastTurn && nextTurn.allStrikes() -> 30
        nextTurnIsLastTurn -> 10 + nextTurn.sum()
        nextTurn.isStrike() -> 20 + nextNextTurn!!.firstThrow()
        else -> 10 + nextTurn.sum()
    }
}
