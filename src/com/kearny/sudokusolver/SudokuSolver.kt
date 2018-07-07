package com.kearny.sudokusolver

class SudokuSolver (board: Array<IntArray>) {
    private val empty = 0 // Empty cell.
    private val size = 9 // Size of Sudoky grids
    private val board: Array<IntArray>

    init {
        this.board = Array(size) { IntArray(size) }

        for (i in 0 until size) {
            System.arraycopy(board[i], 0, this.board[i], 0, size)
        }
    }

    // Check if a possible number is already in a row
    private fun isInRow(row: Int, number: Int): Boolean {
        for (i in 0 until size)
            if (board[row][i] == number)
                return true

        return false
    }

    // Check if a possible number is already in a column
    private fun isInCol(col: Int, number: Int): Boolean {
        for (i in 0 until size)
            if (board[i][col] == number)
                return true

        return false
    }

    // Check if a possible number is in its 3x3 box
    private fun isInBox(row: Int, col: Int, number: Int): Boolean {
        val r = row - row % 3
        val c = col - col % 3

        for (i in r until r + 3)
            for (j in c until c + 3)
                if (board[i][j] == number)
                    return true

        return false
    }

    // combined method to check if a number possible to a row,col position is ok
    private fun isOk(row: Int, col: Int, number: Int): Boolean {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number)
    }

    // Solve method. We will use a recursive BackTracking algorithm.
    // we will see better approaches in next video :)
    fun solve(): Boolean {
        var numberOfLoops = 0
        for (row in 0 until size) {
            for (col in 0 until size) {
                // Search an empty cell
                if (board[row][col] == empty) {
                    // Try possible numbers
                    for (number in 1..size) {
                        numberOfLoops++
                        if (isOk(row, col, number)) {
                            // Number ok. It respects sudoku constraints
                            board[row][col] = number

                            if (solve()) {
                                // Start backtracking recursively
                                return true
                            } else {
                                // If not a solution, we empty the cell and we continue
                                board[row][col] = empty
                            }
                        }
                    }

                    return false
                } else {
                    numberOfLoops++
                }
            }
        }

        println("Solved in $numberOfLoops loops.")

        return true
    }

    fun display() {
        for (i in 0 until size) {
            for (j in 0 until size) {
                print(" " + board[i][j])
            }

            println()
        }

        println()
    }
}
