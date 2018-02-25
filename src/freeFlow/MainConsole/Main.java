package freeFlow.MainConsole;
import freeFlow.model.Game;
import freeFlow.model.Level;
import freeFlow.model.Player;
import freeFlow.view.ConsoleGamePresenter;
import freeFlow.view.ConsoleGameView;
import freeFlow.view.GraphicGamePresenter;
import freeFlow.view.GraphicGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // test setup
        Player player = new Player("Johannes");
        Level level = new Level(5);

        Game model = new Game(1, player, level);

        ConsoleGameView view = new ConsoleGameView();
        ConsoleGamePresenter presenter = new ConsoleGamePresenter(model, view);

    }

}


