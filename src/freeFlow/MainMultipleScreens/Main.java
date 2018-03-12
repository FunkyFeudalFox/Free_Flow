package freeFlow.MainMultipleScreens;

import com.sun.glass.ui.View;
import freeFlow.model.*;
import freeFlow.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 13:51
 */
public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // testing screens
        Player player = new Player("Johannes");
        Level level = new Level(5);

        GameSaver model = new GameSaver();

        OpeningView view = new OpeningView();
        OpeningPresenter presenter = new OpeningPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Welcome to Free Flow");

        primaryStage.show();
    }


}
