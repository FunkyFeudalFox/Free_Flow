package freeFlow.MainMultipleScreens;

//import com.sun.glass.ui.View;

import freeFlow.model.GameSaver;
import freeFlow.view.OpeningPresenter;
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

        GameSaver model = new GameSaver();

        OpeningView view = new OpeningView();
        OpeningPresenter presenter = new OpeningPresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle("Welcome to Free Flow");

        primaryStage.show();
    }




}
