package com.douay.tictactoe

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GridValidatorTest {

    private lateinit var gridValidator: GridValidator

    @Before
    fun setUp() {
        gridValidator = GridValidator()
    }

    @Test
    fun shouldReturnTrueIfFirstRowIsAllCircles() {
        val input: List<List<State?>> = listOf(
            listOf(State.CIRCLE, State.CIRCLE, State.CIRCLE),
            listOf(null, null, null),
            listOf(null, null, null)
        )
        assertEquals(true, gridValidator.isSuccess(input))
    }

    @Test
    fun shouldReturnTrueIfFirstColumnIsAllCircles() {
        val input: List<List<State?>> = listOf(
            listOf(State.CIRCLE, State.CIRCLE, State.CROSS),
            listOf(State.CIRCLE, null, null),
            listOf(State.CIRCLE, null, null)
        )
        assertEquals(true, gridValidator.isSuccess(input), )
    }

    @Test
    fun shouldReturnTrueIfFistDialgonalIsAllCircles() {
        val input: List<List<State?>> = listOf(
            listOf(State.CIRCLE,null),
            listOf(null, State.CIRCLE, null),
            listOf(null, null, State.CIRCLE)
        )
        assertEquals(true, gridValidator.isSuccess(input), )
    }

    @Test
    fun shouldReturnTrueIfSecondDialgonalIsAllCircles() {
        val input: List<List<State?>> = listOf(
            listOf(State.CIRCLE,null),
            listOf(null, State.CIRCLE, null),
            listOf(null, null, State.CIRCLE)
        )
        assertEquals(true, gridValidator.isSuccess(input), )
    }

    @Test
    fun shouldReturnTrueIfContainsNulls() {
        val input: List<List<State?>> = listOf(
            listOf(null, null, null),
            listOf(null, null, null),
            listOf(null, null, null)
        )
        assertEquals(false, gridValidator.isSuccess(input),)
    }
}