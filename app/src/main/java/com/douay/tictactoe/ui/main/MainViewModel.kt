package com.douay.tictactoe.ui.main

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.douay.tictactoe.GridResult
import com.douay.tictactoe.GridValidator
import com.douay.tictactoe.State
import java.util.*

class MainViewModel : ViewModel() {

    companion object {

        val EMPTY_GRID: List<ArrayList<State?>>
            get() = listOf(
                arrayListOf(null, null, null),
                arrayListOf(null, null, null),
                arrayListOf(null, null, null)
            )
    }

    private var grid: List<ArrayList<State?>> = EMPTY_GRID

    private val gridValidator = GridValidator();

    val imageRes = ObservableArrayMap<Int, Int>()


    val currentPlayer = ObservableField(State.CIRCLE)

    val result = ObservableField("");

    init {
        reset()
    }

    fun onCellClicked(pos: Int) {

        if (imageRes[pos] != null) return

        val row = pos / 3
        val column = pos % 3

        grid[row][column] = currentPlayer.get()
        imageRes.setValueAt(pos, currentPlayer.get()?.res)

        when (gridValidator.isSuccess(grid)) {
             GridResult.VICTORY -> {
                result.set("${currentPlayer.get()?.name} WIN !!!")
            }
            GridResult.IN_PROGRESS -> {
                currentPlayer.set(currentPlayer.get()?.next())
            }
            else -> {
                result.set("DRAW !!!")
            }
        }
    }

    fun reset() {
        currentPlayer.set(State.CIRCLE)

        for (i in 0..8) {
            imageRes[i] = null
        }

        grid = EMPTY_GRID

        result.set("")
    }
}