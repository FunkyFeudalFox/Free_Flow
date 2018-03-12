package freeFlow.MainTest;

import freeFlow.model.*;
import freeFlow.view.CreatePlayerPresenter;
import freeFlow.view.CreatePlayerView;
import freeFlow.view.OpeningPresenter;
import freeFlow.view.OpeningView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Arjan Tammer
 * @version 1.0 3/10/2018 18:32
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

        CreatePlayerView view = new CreatePlayerView();
        CreatePlayerPresenter presenter = new CreatePlayerPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Create new player");

        primaryStage.show();
    }
}
