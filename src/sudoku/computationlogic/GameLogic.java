package sudoku.computationlogic;

import sudoku.constants.GameState;
import sudoku.constants.Rows;
import sudoku.problems.SudokuGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static sudoku.problems.SudokuGame.GRID_LIMIT;

public class GameLogic {

    public static SudokuGame getNewGame() {
        return new SudokuGame(GameState.NEW, GameGenerator.getNewGameGrid());
    }

    public static GameState checkForCompletion(int[][] grid) {
        if (sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if (tilesAreNotFilled(grid)) return GameState.ACTIVE;
        return GameState.COMPLETED;
    }

    public static boolean sudokuIsInvalid(int[][] grid) {
        if (rowsAreInvalid(grid)) return true;
        if (columnsAreInvalid(grid)) return true;
        if (squaresAreInvalid(grid)) return true;
        return false;
    }

    public static boolean rowsAreInvalid(int[][] grid) {
        for (int y = 0; y < GRID_LIMIT; y++) {
            List<Integer> row = new ArrayList<>();
            for (int x = 0; x < GRID_LIMIT; x++) {
                row.add(grid[x][y]);
            }

            if (collectionHasRepeats(row)) return true;
        }

        return false;
    }

    public static boolean columnsAreInvalid(int[][] grid) {
        for (int x = 0; x < GRID_LIMIT; x++) {
            List<Integer> row = new ArrayList<>();
            for (int y = 0; y < GRID_LIMIT; y++) {
                row.add(grid[x][y]);
            }

            if (collectionHasRepeats(row)) return true;
        }

        return false;
    }

    public static boolean squaresAreInvalid(int[][] grid) {
        if (rowOfSquaresIsInvalid(Rows.TOP, grid)) return true;
        if (rowOfSquaresIsInvalid(Rows.MIDDLE, grid)) return true;
        if (rowOfSquaresIsInvalid(Rows.BOTTOM, grid)) return true;
        return false;

    }

    public static boolean rowOfSquaresIsInvalid(Rows value, int[][] grid) {
        switch (value) {
            case TOP:
                if (squareIsInvalid(0, 0, grid)) return true;
                if (squareIsInvalid(0, 3, grid)) return true;
                if (squareIsInvalid(0, 6, grid)) return true;
                return false;
            case MIDDLE:
                if (squareIsInvalid(3, 0, grid)) return true;
                if (squareIsInvalid(3, 3, grid)) return true;
                if (squareIsInvalid(3, 6, grid)) return true;
                return false;
            case BOTTOM:
                if (squareIsInvalid(6, 0, grid)) return true;
                if (squareIsInvalid(6, 3, grid)) return true;
                if (squareIsInvalid(6, 6, grid)) return true;
                return false;
            default:
                return false;
        }
    }

    public static boolean squareIsInvalid(int x, int y, int[][] grid) {
        int yIndexEnd = y + 3;
        int xIndexEnd = x + 3;

        List<Integer> square = new ArrayList<>();

        while (y < yIndexEnd) {
            while (x < xIndexEnd) {
                square.add(grid[x][y]);
                x++;
            }

            x -= 3;
            y++;
        }

        if (collectionHasRepeats(square)) return true;
        return false;

    }

    public static boolean collectionHasRepeats(List<Integer> square) {
        for (int index = 1; index <= GRID_LIMIT; index++) {
            if (Collections.frequency(square, index) > 1) return true;
        }

        return false;

    }

    public static boolean tilesAreNotFilled(int[][] grid) {
        for (int x = 0; x < GRID_LIMIT; x++) {
            for (int y = 0; y < GRID_LIMIT; y++) {
                if (grid[x][y] == 0) return true;
            }
        }

        return false;
    }
}
