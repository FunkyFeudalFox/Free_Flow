package Main;

import freeFlow.model.Game;
import freeFlow.model.Level;
import freeFlow.model.Player;
import freeFlow.view.GraphicGamePresenter;
import freeFlow.view.GraphicGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // test setup
        Player player = new Player("Johannes");
        Level level = new Level(5);

        Game model = new Game(1, player, level);
        GraphicGameView view = new GraphicGameView();
        GraphicGamePresenter presenter = new GraphicGamePresenter(model, view);

        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Free Flow");
        primaryStage.show();
    }

    public static void main(String[] args) {Application.launch(args);}

}


