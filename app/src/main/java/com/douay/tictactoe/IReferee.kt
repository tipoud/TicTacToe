package com.douay.tictactoe

interface IReferee {
    fun check(grid: List<State>): GridResult
}