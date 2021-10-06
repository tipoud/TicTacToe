package com.douay.tictactoe

import com.douay.tictactoe.GridResult.*
import com.douay.tictactoe.State.CIRCLE
import com.douay.tictactoe.State.UNDEFINED
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RefereeTest {

    private lateinit var referee: IReferee

    @Before
    fun setUp() {
        referee = Referee(GridValidator())
    }

    @Test
    fun shouldReturnVictoryIfFirstRowIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, CIRCLE, CIRCLE,
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfFirstColumnIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, UNDEFINED, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfFistDialgonalIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, UNDEFINED, UNDEFINED,
            UNDEFINED, CIRCLE, UNDEFINED,
            UNDEFINED, UNDEFINED, CIRCLE
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfSecondDialgonalIsAllCircles() {
        val grid: List<State> = listOf(
            UNDEFINED, UNDEFINED, CIRCLE,
            UNDEFINED, CIRCLE, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnInProgressIfContainsOnlyUndefined() {
        val grid: List<State> = listOf(
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED
        )
        assertEquals(IN_PROGRESS, referee.check(grid))
    }
}