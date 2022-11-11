package com.katas


fun bowlingScores(scores: List<List<Int>>): Int {
    return scores.flatten().sum()
}
