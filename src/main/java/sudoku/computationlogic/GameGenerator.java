package sudoku.computationlogic;

import sudoku.problems.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sudoku.problems.SudokuGame.GRID_LIMIT;

public class GameGenerator {
    public static int[][] getNewGameGrid() {
        return unsolveGame(getSolvedGame());
    }

    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[GRID_LIMIT][GRID_LIMIT];

        while (!solvable) {
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);

            int index = 0;

            while (index < 40) {
                int xCoordinate = random.nextInt(GRID_LIMIT);
                int yCoordinate = random.nextInt(GRID_LIMIT);

                if (solvableArray[xCoordinate][yCoordinate] != 0) {
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }

            }

            int[][] toBeSolved = new int[GRID_LIMIT][GRID_LIMIT];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);

        }

        return solvableArray;

    }

    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        int[][] newGrid = new int[GRID_LIMIT][GRID_LIMIT];

        for (int value = 1; value <= GRID_LIMIT; value++) {
            int allocations = 0;
            int interrupt = 0;

            List<Coordinates> allocTracker = new ArrayList<>();
            int attempts = 0;

            while (allocations < GRID_LIMIT) {
                if (interrupt > 200) {
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    interrupt = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempts++;

                    if (attempts > 500) {
                        clearArray(newGrid);
                        attempts = 0;
                        value = 1;
                    }

                }

                int xCoordinate = random.nextInt(GRID_LIMIT);
                int yCoordinate = random.nextInt(GRID_LIMIT);

                if (newGrid[xCoordinate][yCoordinate] == 0) {
                    newGrid[xCoordinate][yCoordinate] = value;

                    if (GameLogic.sudokuIsInvalid(newGrid)) {
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    } else {
                        allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                        allocations++;
                    }
                }
            }

        }
        return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for (int x = 0; x < GRID_LIMIT; x++) {
            for (int y = 0; y < GRID_LIMIT; y++) {
                newGrid[x][y] = 0;
            }
        }
    }
}
