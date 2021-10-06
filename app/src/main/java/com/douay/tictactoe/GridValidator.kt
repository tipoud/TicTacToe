package com.douay.tictactoe

class GridValidator :  IGridValidator {

    override fun isSuccess(input: List<List<State?>>): Boolean {

        if (checkRows(input)) return true

        if (checkColumns(input)) return true

        if (checkFirstDiagonal(input)) return true

        if (checkSecondDiagonal(input)) return true

        return false
    }

    override fun checkFirstDiagonal(input: List<List<State?>>): Boolean {
        val diagonal = input.reduceIndexed { index, list,
                                             acc -> acc + list.getOrNull(index)
        }
        return isConsistent(diagonal)
    }

    override fun checkSecondDiagonal(input: List<List<State?>>): Boolean {
        val diagonal = input.reduceRightIndexed { index, list, acc -> acc + list.getOrNull(index) }
        return isConsistent(diagonal)
    }

    override fun checkColumns(input: List<List<State?>>): Boolean {
        for (j in 0..input.size) {
            val column = input.map { row -> row.getOrNull(j) }
            if (isConsistent(column)) return true
        }
        return false
    }

    override fun checkRows(input: List<List<State?>>): Boolean {
        input.forEach {
            if (isConsistent(it)) return true
        }
        return false
    }

    private fun isConsistent(input: List<State?>): Boolean {

        if (input.contains(null)) {
            return false
        }

        val circleCount = input.count { it == State.CIRCLE }

        return circleCount == 0 || circleCount == input.count()
    }
}