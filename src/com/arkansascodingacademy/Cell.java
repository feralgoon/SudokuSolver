package com.arkansascodingacademy;

class Cell
{
    private final int ROW;
    private final int COL;
    private final boolean isPlaced;

    private int value;
    private int quadrant;

    public Cell(int row,int col, int val)
    {
        this.ROW = row;
        this.COL = col;
        setValue(val);
        calculateQuadrant();
        isPlaced = false;
    }

    public Cell(int row,int col, int val, boolean isPlaced)
    {
        this.ROW = row;
        this.COL = col;
        setValue(val);
        calculateQuadrant();
        this.isPlaced = isPlaced;
    }

    public boolean isPlaced()
    {
        return this.isPlaced;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public int getQuadrant()
    {
        return quadrant;
    }

    public String toString()
    {
        return "" + getValue();
    }

    private void calculateQuadrant()
    {
        if (ROW < 3)
        {
            if (COL < 3)
            {
                quadrant = 1;
            }
            else if (COL < 6)
            {
                quadrant = 4;
            }
            else
            {
                quadrant = 7;
            }
        }
        else if (ROW < 6)
        {
            if (COL < 3)
            {
                quadrant = 2;
            }
            else if (COL < 6)
            {
                quadrant = 4;
            }
            else
            {
                quadrant = 8;
            }
        }
        else
        {
            if (COL < 3)
            {
                quadrant = 3;
            }
            else if (COL < 6)
            {
                quadrant = 6;
            }
            else
            {
                quadrant = 9;
            }
        }
    }
}
