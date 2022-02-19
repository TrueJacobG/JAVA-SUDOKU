package sudoku.computationlogic;

import sudoku.problems.SudokuGame;

public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
        for (int xIndex = 0; xIndex < SudokuGame.GRID_LIMIT; xIndex++) {
            for (int yIndex = 0; yIndex < SudokuGame.GRID_LIMIT; yIndex++) {
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }

    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] newArray = new int[SudokuGame.GRID_LIMIT][SudokuGame.GRID_LIMIT];

        for (int xIndex = 0; xIndex < SudokuGame.GRID_LIMIT; xIndex++) {
            for (int yIndex = 0; yIndex < SudokuGame.GRID_LIMIT; yIndex++) {
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }

        return newArray;
    }
}
