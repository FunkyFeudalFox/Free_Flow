package freeFlow.view;

import freeFlow.model.Game;
import freeFlow.model.Level;
import freeFlow.model.Player;

public class ConsoleMenuPresenter {

    private ConsoleMenuView view;
    private char choice;

    public ConsoleMenuPresenter(ConsoleMenuView view) {
        this.view = view;
        start();
    }

    private void start() {

        do {
            view.drawMainMenu();
        } while (!validateMainMenuChoice(view.chooseOption()));

    }

    private boolean validateMainMenuChoice(String input) {

        boolean doExit = false;
        choice = input.trim().charAt(0);
        switch (choice) {
            case ConsoleMenuView.OPTION_NEW_GAME:
                newGame();
                break;

            case ConsoleMenuView.OPTION_END_GAME:
                doExit = true;

        }
        return doExit;
    }

    private void newGame() {
        // test setup
        Player player = new Player("Johannes");
        Level level = new Level(5);

        Game model = new Game(1, player, level);

        ConsoleGameView view = new ConsoleGameView();
        ConsoleGamePresenter presenter = new ConsoleGamePresenter(model, view);
    }

}
