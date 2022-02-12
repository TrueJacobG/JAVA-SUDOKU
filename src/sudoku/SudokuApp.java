package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Stage;

public class SudokuApp extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws Exception {
        uiImpl = new UserInterfaceImpl(primaryStage);
        try {
            SudokuBuildLogic.build(uiImpl);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
