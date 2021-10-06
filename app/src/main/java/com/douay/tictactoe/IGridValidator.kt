package com.douay.tictactoe

interface IGridValidator {
    fun isSuccess(input: List<List<State?>>): Boolean
    fun checkFirstDiagonal(input: List<List<State?>>): Boolean
    fun checkSecondDiagonal(input: List<List<State?>>): Boolean
    fun checkColumns(input: List<List<State?>>): Boolean
    fun checkRows(input: List<List<State?>>): Boolean
}
