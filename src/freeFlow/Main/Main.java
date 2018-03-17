package freeFlow.Main;
import freeFlow.model.Game;
import freeFlow.model.Level;
import freeFlow.model.Player;
import freeFlow.view.GraphicGamePresenter;
import freeFlow.view.GraphicGameView;
import javafx.application.Application;
import javafx.application.Platform;
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
        model.startGame();
        GraphicGameView view = new GraphicGameView(5);
        GraphicGamePresenter presenter = new GraphicGamePresenter(model, view);

        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Free Flow");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();

    }

}


