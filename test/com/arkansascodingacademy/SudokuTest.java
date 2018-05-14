package com.arkansascodingacademy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest
{

    @Test
    void easy()
    {
        //4267206491
        final int[][] puzzle =
                {
                        {0, 6, 0, 0, 0, 9, 0, 1, 3},
                        {0, 7, 0, 0, 2, 0, 8, 0, 0},
                        {1, 0, 4, 3, 0, 0, 0, 0, 9},
                        {6, 0, 1, 0, 3, 2, 5, 0, 7},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 7, 9, 8, 0, 1, 0, 2},
                        {7, 0, 0, 0, 0, 8, 3, 0, 5},
                        {0, 0, 9, 0, 6, 0, 0, 2, 0},
                        {2, 5, 0, 7, 0, 0, 0, 9, 0}
                };

        final int[][] correctSolution =
                {
                        {5, 6, 2, 8, 7, 9, 4, 1, 3},
                        {9, 7, 3, 1, 2, 4, 8, 5, 6},
                        {1, 8, 4, 3, 5, 6, 2, 7, 9},
                        {6, 9, 1, 4, 3, 2, 5, 8, 7},
                        {8, 2, 5, 6, 1, 7, 9, 3, 4},
                        {3, 4, 7, 9, 8, 5, 1, 6, 2},
                        {7, 1, 6, 2, 9, 8, 3, 4, 5},
                        {4, 3, 9, 5, 6, 1, 7, 2, 8},
                        {2, 5, 8, 7, 4, 3, 6, 9, 1}
                };

        final int[][] testSolution = Sudoku.solve(puzzle);
        assertArrayEquals(correctSolution, testSolution);
    }

    @Test
    void medium()
    {
        //874488209
        final int puzzle[][] =
                {
                        {0, 0, 9, 0, 0, 3, 2, 7, 0},
                        {0, 0, 0, 8, 0, 7, 6, 0, 0},
                        {0, 7, 0, 0, 2, 0, 8, 0, 0},
                        {3, 0, 0, 0, 5, 9, 0, 0, 0},
                        {4, 0, 0, 0, 0, 0, 0, 0, 9},
                        {0, 0, 0, 2, 3, 0, 0, 0, 8},
                        {0, 0, 3, 0, 4, 0, 0, 8, 0},
                        {0, 0, 7, 6, 0, 1, 0, 0, 0},
                        {0, 8, 6, 3, 0, 0, 7, 0, 0}
                };

        final int[][] correctSolution =
                {
                        {8, 1, 9, 5, 6, 3, 2, 7, 4},
                        {2, 3, 4, 8, 1, 7, 6, 9, 5},
                        {6, 7, 5, 9, 2, 4, 8, 1, 3},
                        {3, 6, 8, 4, 5, 9, 1, 2, 7},
                        {4, 5, 2, 1, 7, 8, 3, 6, 9},
                        {7, 9, 1, 2, 3, 6, 4, 5, 8},
                        {1, 2, 3, 7, 4, 5, 9, 8, 6},
                        {9, 4, 7, 6, 8, 1, 5, 3, 2},
                        {5, 8, 6, 3, 9, 2, 7, 4, 1}
                };

        final int[][] testSolution = Sudoku.solve(puzzle);
        assertArrayEquals(correctSolution, testSolution);
    }

    @Test
    void hard()
    {
        //3747160755
        final int puzzle[][] =
                {
                        {7, 0, 0, 0, 0, 0, 0, 0, 0},
                        {5, 0, 0, 0, 0, 2, 8, 9, 0},
                        {0, 0, 6, 0, 0, 8, 0, 0, 2},
                        {0, 0, 0, 9, 0, 4, 1, 0, 0},
                        {9, 0, 7, 1, 0, 3, 5, 0, 8},
                        {0, 0, 1, 7, 0, 6, 0, 0, 0},
                        {3, 0, 0, 6, 0, 0, 9, 0, 0},
                        {0, 5, 9, 2, 0, 0, 0, 0, 3},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1}
                };

        final int[][] correctSolution =
                {
                        {7, 8, 2, 3, 9, 1, 4, 6, 5},
                        {5, 1, 3, 4, 6, 2, 8, 9, 7},
                        {4, 9, 6, 5, 7, 8, 3, 1, 2},
                        {2, 3, 5, 9, 8, 4, 1, 7, 6},
                        {9, 6, 7, 1, 2, 3, 5, 4, 8},
                        {8, 4, 1, 7, 5, 6, 2, 3, 9},
                        {3, 7, 8, 6, 1, 5, 9, 2, 4},
                        {1, 5, 9, 2, 4, 7, 6, 8, 3},
                        {6, 2, 4, 8, 3, 9, 7, 5, 1},

                };

        final int[][] testSolution = Sudoku.solve(puzzle);
        assertArrayEquals(correctSolution, testSolution);
    }

    @Test
    void evil()
    {
        //3697833736
        final int puzzle[][] =
                {
                        {0, 3, 0, 6, 0, 0, 0, 2, 5},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 0, 4, 0, 5, 0, 8, 0},
                        {0, 0, 8, 0, 0, 6, 2, 0, 0},
                        {0, 0, 0, 2, 0, 9, 0, 0, 0},
                        {0, 0, 7, 8, 0, 0, 9, 0, 0},
                        {0, 5, 0, 9, 0, 7, 0, 0, 6},
                        {0, 0, 0, 0, 0, 0, 0, 7, 0},
                        {3, 7, 0, 0, 0, 2, 0, 4, 0}
                };

        final int[][] correctSolution =
                {
                        {7, 3, 4, 6, 9, 8, 1, 2, 5},
                        {8, 1, 5, 7, 2, 3, 6, 9, 4},
                        {2, 9, 6, 4, 1, 5, 7, 8, 3},
                        {9, 4, 8, 1, 5, 6, 2, 3, 7},
                        {1, 6, 3, 2, 7, 9, 4, 5, 8},
                        {5, 2, 7, 8, 3, 4, 9, 6, 1},
                        {4, 5, 2, 9, 8, 7, 3, 1, 6},
                        {6, 8, 9, 3, 4, 1, 5, 7, 2},
                        {3, 7, 1, 5, 6, 2, 8, 4, 9},
                };

        final int[][] testSolution = Sudoku.solve(puzzle);
        assertArrayEquals(correctSolution, testSolution);
    }

    @Test
    void checkColumn()
    {
        final int[][] test= {
        {0, 6, 0, 0, 0, 9, 0, 1, 3},
        {0, 7, 0, 0, 2, 0, 8, 0, 0},
        {1, 0, 4, 3, 0, 0, 0, 0, 9},
        {6, 0, 1, 0, 3, 2, 5, 0, 7},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 0, 7, 9, 8, 0, 1, 0, 2},
        {7, 0, 0, 0, 0, 8, 3, 0, 5},
        {0, 0, 9, 0, 6, 0, 0, 2, 0},
        {2, 5, 0, 7, 0, 0, 0, 9, 0}
    };
        assertTrue(Sudoku.checkColumn(3,2,test));
        assertFalse(Sudoku.checkColumn(9, 7,test));
    }

    @Test
    void checkRow()
    {
        final int[][] test= {
                {0, 6, 0, 0, 0, 9, 0, 1, 3},
                {0, 7, 0, 0, 2, 0, 8, 0, 0},
                {1, 0, 4, 3, 0, 0, 0, 0, 9},
                {6, 0, 1, 0, 3, 2, 5, 0, 7},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 7, 9, 8, 0, 1, 0, 2},
                {7, 0, 0, 0, 0, 8, 3, 0, 5},
                {0, 0, 9, 0, 6, 0, 0, 2, 0},
                {2, 5, 0, 7, 0, 0, 0, 9, 0}
        };
        assertTrue(Sudoku.checkRow(2,2,test));
        assertFalse(Sudoku.checkRow(8, 6,test));
    }
}