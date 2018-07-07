package com.kearny.sudokusolver

// We define a simple grid to solve. Grid is stored in a 2D Array.
private val gridToSolve = arrayOf(
        intArrayOf(8, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 3, 6, 0, 0, 0, 0, 0),
        intArrayOf(0, 7, 0, 0, 9, 0, 2, 0, 0),
        intArrayOf(0, 5, 0, 0, 0, 7, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 4, 5, 7, 0, 0),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 3, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 6, 8),
        intArrayOf(0, 0, 8, 5, 0, 0, 0, 1, 0),
        intArrayOf(0, 9, 0, 0, 0, 0, 4, 0, 0)
)

fun main(args: Array<String>) {
    val sudoku = SudokuSolver(gridToSolve)
    println("Sudoku grid to solve")
    sudoku.display()

    // We try resolution.
    if (sudoku.solve()) {
        println("Sudoku Grid solved with simple BT")
        sudoku.display()
    } else {
        println("Unsolvable")
    }
}