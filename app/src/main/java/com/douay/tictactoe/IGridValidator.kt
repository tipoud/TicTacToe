package com.douay.tictactoe

interface IGridValidator {
    fun checkFirstDiagonal(input: List<State>): Boolean
    fun checkSecondDiagonal(input: List<State>): Boolean
    fun checkColumns(input: List<State>): Boolean
    fun checkRows(input: List<State>): Boolean
    fun isFull(input: List<State>): Boolean
}
