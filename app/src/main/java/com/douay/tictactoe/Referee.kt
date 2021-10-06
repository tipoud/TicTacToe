package com.douay.tictactoe

class Referee(private val gridValidator: IGridValidator) : IReferee {

    override fun check(grid: List<State>): GridResult {
        with(gridValidator) {
            if (checkRows(grid)
                || checkColumns(grid)
                || checkFirstDiagonal(grid)
                || checkSecondDiagonal(grid)
            ) return GridResult.VICTORY

            if (isFull(grid)) {
                return GridResult.DRAW;
            }
        }

        return GridResult.IN_PROGRESS
    }
}