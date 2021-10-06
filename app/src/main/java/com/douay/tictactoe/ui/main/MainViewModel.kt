package com.douay.tictactoe.ui.main

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.douay.tictactoe.GridResult
import com.douay.tictactoe.GridValidator
import com.douay.tictactoe.Referee
import com.douay.tictactoe.State

class MainViewModel : ViewModel() {

    private var grid: MutableList<State> = MutableList(9) { State.UNDEFINED }

    val imageRes = ObservableArrayMap<Int, Int>()

    private val referee = Referee(GridValidator())

    val currentPlayer = ObservableField(State.CIRCLE)

    val result = ObservableField("");

    init {
        reset()
    }

    fun onCellClicked(pos: Int) {

        if (grid[pos] != State.UNDEFINED) return

        currentPlayer.get()?.let {
            grid[pos] = it
            imageRes.setValueAt(pos, it.res)
        } ?: return

        when (referee.check(grid)) {
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
            imageRes[i] = 0
        }

        grid = MutableList(9) { State.UNDEFINED }

        result.set("")
    }
}