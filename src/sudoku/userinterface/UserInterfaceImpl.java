package sudoku.userinterface;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sudoku.problems.Coordinates;
import sudoku.problems.SudokuGame;

import java.util.HashMap;

public class UserInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventListener listener;

    private static final double WINDOWS_X = 668;
    private static final double WINDOWS_Y = 732;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);

    private static final String SUDOKU = "Sudoku";


    @Override
    public void handle(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setListener(EventListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateSquare(int x, int y, int input) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateBoard(SudokuGame game) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showDialog(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showError(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setListener(EventListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateBoard(sudoku.userinterface.SudokuGame game) {
        // TODO Auto-generated method stub

    }

}
