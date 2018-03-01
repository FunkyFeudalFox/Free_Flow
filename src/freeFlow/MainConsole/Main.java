package freeFlow.MainConsole;

import freeFlow.view.ConsoleMenuPresenter;
import freeFlow.view.ConsoleMenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ConsoleMenuView view = new ConsoleMenuView();
        ConsoleMenuPresenter presenter = new ConsoleMenuPresenter(view);

        System.exit(0);
    }

}


