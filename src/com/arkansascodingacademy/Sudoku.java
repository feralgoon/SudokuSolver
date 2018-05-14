package com.arkansascodingacademy;

import java.util.ArrayList;
import java.util.List;

public class Sudoku
{
    private static final int ROW_COUNT = 9;
    private static final int COLUMN_COUNT = 9;
    private static int[][] solvedPuzzle = new int[ROW_COUNT][COLUMN_COUNT];

    public static int[][] solve(int[][] puzzle)
    {
        for (int i = 0; i < ROW_COUNT; i++)
        {
            for (int j = 0; j < COLUMN_COUNT; j++)
            {
                if (puzzle[i][j] == 0)
                {
                    solvedPuzzle[i][j] = 0;
                }
                else
                {
                    solvedPuzzle[i][j] = puzzle[i][j];
                }
            }
        }

        solving();

        return solvedPuzzle;
    }

    private static boolean solving()
    {
        for(int x = 0; x < ROW_COUNT; x++)
        {
            for(int y = 0; y < COLUMN_COUNT; y++)
            {
                if (solvedPuzzle[x][y] != 0)
                {
                    continue;
                }
                else
                {
                    for (int num = 1; num < 10; num++)
                    {
                        if (isValid(num, x, y))
                        {
                            solvedPuzzle[x][y] = num;
                            if (solving())
                            {
                                printPuzzle(solvedPuzzle);
                                System.out.println("Beep");
                                return true;
                            }
                            else
                            {
                                solvedPuzzle[x][y] = 0;
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int num, int row, int column)
    {
        boolean result = false;

        for (int i = 0; i < ROW_COUNT; i++)
        {
            if (checkRow(num,i,solvedPuzzle) && checkColumn(num,i,solvedPuzzle) && checkQuadrants(num,row,column))
            {
                result = true;
            }
        }

        return result;
    }

    public static boolean checkColumn(int num, int row,int[][] puzzle)
    {
        boolean result = true;

        for(int i = 0; i < COLUMN_COUNT; i++)
        {
            if (puzzle[i][row] == num)
            {
                result = false;
            }
        }

        return result;
    }

    public static boolean checkRow(int num, int column,int[][] puzzle)
    {
        boolean result = true;

        for(int i = 0; i < ROW_COUNT; i++)
        {
            if (puzzle[column][i] == num)
            {
                result = false;
            }
        }

        return result;
    }

    private static boolean checkQuadrants(int num, int row, int column)
    {
        boolean result = true;

        if (row < 3)
        {
            if (column < 3)
            {
                for (int j = 0; j < 3; j++)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else if (column < 6)
            {
                for (int j = 0; j < 3; j++)
                {
                    for (int k = 3; k < 6; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else
            {
                for (int j = 0; j < 3; j++)
                {
                    for (int k = 6; k < 9; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
        }
        else if (row < 6)
        {
            if (column < 3)
            {
                for (int j = 3; j < 6; j++)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else if (column < 6)
            {
                for (int j = 3; j < 6; j++)
                {
                    for (int k = 3; k < 6; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else
            {
                for (int j = 3; j < 6; j++)
                {
                    for (int k = 6; k < 9; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
        }
        else
        {
            if (column < 3)
            {
                for (int j = 6; j < 9; j++)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else if (column < 6)
            {
                for (int j = 6; j < 9; j++)
                {
                    for (int k = 3; k < 6; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
            else
            {
                for (int j = 6; j < 9; j++)
                {
                    for (int k = 6; k < 9; k++)
                    {
                        if (solvedPuzzle[j][k] == num)
                        {
                            result = false;
                        }
                    }
                }
            }
        }

        return result;
    }

/*    private static boolean isSolved(int[][] puzzle)
    {
        int[] counts = new int[9];

        System.out.println("Checking for solved puzzle");

        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                if (!isValid(puzzle[i][j],i,j))
                {
                    return false;
                }
            }
        }

        return true;
    }
*/
    private static void printPuzzle(int[][] puzzle)
    {
        for (int i = 0; i < ROW_COUNT; i++)
        {
            for (int j = 0; j < COLUMN_COUNT; j++)
            {
                System.out.print(puzzle[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] test =
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
        printPuzzle(test);
        solve(test);
        printPuzzle(solvedPuzzle);
    }

    /*    public static int[][] solve(int[][] puzzle)
    {
        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                if (puzzle[i][j] != 0)
                {
                    solvedPuzzle[i][j] = new Cell(i,j,puzzle[i][j],true);
                }
                else
                {
                    solvedPuzzle[i][j] = new Cell(i,j,0);
                }
            }
        }

        printPuzzle();

        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                if (!solvedPuzzle[i][j].isPlaced())
                {
                    solvedPuzzle[i][j].setValue(findNum(i,j));
                }
            }
        }

        printPuzzle();

        return convertCellToIntArray(solvedPuzzle);
    }

    private static int[][] convertCellToIntArray(Cell[][] toConvert)
    {
        int[][] result = new int[ROW_COUNT][COLUMN_COUNT];

        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                result[i][j] = toConvert[i][j].getValue();
            }
        }

        return result;
    }



    private static int findNum(int x, int y)
    {
        int result = 0;

        return result;
    }

    private static int findNum(int x, int y)
    {
        int result = 0;

        List<Integer> possibleNumbers = new ArrayList<>(9);
        for(int i = 1; i < 10; i++)
        {
            possibleNumbers.add(i);
        }

        for(int i = 0; i < ROW_COUNT; i++)
        {
            possibleNumbers.remove(Integer.valueOf(solvedPuzzle[x][i].getValue()));
        }

        for(int i = 0; i < COLUMN_COUNT; i++)
        {
            possibleNumbers.remove(Integer.valueOf(solvedPuzzle[i][y].getValue()));
        }

        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                if (solvedPuzzle[x][y].getQuadrant() == solvedPuzzle[i][j].getQuadrant())
                {
                    possibleNumbers.remove(Integer.valueOf(solvedPuzzle[x][i].getValue()));
                }
            }
        }

        if(possibleNumbers.size() > 0)
        {
            result = possibleNumbers.get(0);
        }
        System.out.println(result);
        return result;
    }

    /*private static int findNum(int x, int y)
    {
        int result = 0;
        List<Integer> possibilities = new ArrayList<>(9);
        for(int i = 1; i < 10; i++)
        {
            possibilities.add(i);
            System.out.println("Added " + i);
        }

        for(int i = 0; i < ROW_COUNT; i++)
        {
            possibilities.remove(Integer.valueOf(solvedPuzzle[x][i].getValue()));
            System.out.println("Removed " + solvedPuzzle[x][i].getValue());
        }
        for(int i = 0; i < COLUMN_COUNT; i++)
        {
            possibilities.remove(Integer.valueOf(solvedPuzzle[i][y].getValue()));
            System.out.println("Removed " + solvedPuzzle[i][y].getValue());

        }
        for(int i = 0; i < ROW_COUNT; i++)
        {
            for(int j = 0; j < COLUMN_COUNT; j++)
            {
                if (solvedPuzzle[i][j].getQuadrant() == solvedPuzzle[x][y].getQuadrant())
                {
                    possibilities.remove(Integer.valueOf(solvedPuzzle[x][i].getValue()));
                    System.out.println("Removed " + solvedPuzzle[x][i].getValue());
                }
            }
        }

        if (possibilities.size() != 0)
        {
            result = possibilities.get(0);
            System.out.println("Got " + possibilities.get(0));
        }

        return result;
    }*/
}
