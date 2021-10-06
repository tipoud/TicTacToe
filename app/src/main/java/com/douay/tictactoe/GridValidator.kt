package com.douay.tictactoe

class GridValidator : IGridValidator {

    override fun checkColumns(input: List<State>): Boolean {
        for (j in 0..2) {
            val column = input.windowed(3, 3).mapNotNull { row -> row.getOrNull(j) }
            if (isValid(column)) return true
        }
        return false
    }

    override fun isFull(input: List<State>): Boolean {
        return !input.contains(State.UNDEFINED)
    }

    override fun checkRows(input: List<State>): Boolean {
        input.windowed(3, 3).forEach {
            if (isValid(it)) return true
        }
        return false
    }

    override fun checkFirstDiagonal(input: List<State>): Boolean {
        val diagonal = listOf(0, 4, 8).mapNotNull { input.getOrNull(it) }
        return isValid(diagonal)
    }

    override fun checkSecondDiagonal(input: List<State>): Boolean {
        val diagonal = listOf(2, 4, 6).mapNotNull { input.getOrNull(it) }
        return isValid(diagonal)
    }

    private fun isValid(input: List<State>) = input.all { it == State.CIRCLE } || input.all { it == State.CROSS }

}