package freeFlow.MainMultipleScreens;

import freeFlow.model.Game;
import freeFlow.model.Level;
import freeFlow.model.Player;
import freeFlow.view.OpeningView;
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

        Game model = new Game(1, player, level);

        OpeningView view = new OpeningView();

        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Welcome to Free Flow");

        primaryStage.show();
    }
}
