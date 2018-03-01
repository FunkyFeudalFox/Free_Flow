package freeFlow.view;

import freeFlow.model.Game;
import freeFlow.model.Space;

public class ConsoleGamePresenter {
    private Game model;
    private ConsoleGameView view;

    public ConsoleGamePresenter(Game model, ConsoleGameView view) {
        this.model = model;
        this.view = view;
        start();
    }

    private void start() {
        model.setUserName(view.inputUserName());
        model.startGame();
        while (!model.getExit()) {
            drawLevel();
            validateGridLocation(view.inputGridLocation());
            checkWinConditions();
        }
    }

    private void drawLevel() {
        view.drawTopGrid(model.getLevel().getSize());
        for (int y = 0; y < model.getLevel().getSize(); y++) {
            view.drawPart(Character.forDigit(y + 1, 10));
            for (int x = 0; x < model.getLevel().getSize(); x++) {
                Space part = model.getLevel().getDrawable(x, y);
                view.drawSeparator(part.getSelected(), getPreviousSelected(x, y));
                view.drawPart(model.getLevel().getDrawable(x, y).getConsoleImage());
            }
            view.drawEndOfLine(model.getLevel().getDrawable(model.getLevel().getSize() - 1, y).getSelected());
        }
    }

    private boolean getPreviousSelected(int x, int y) {
        if (x == 0) {
            return false;
        }
        return model.getLevel().getDrawable(x - 1, y).getSelected();
    }

    private boolean getNextSelected(int x, int y) {
        if (x == model.getLevel().getSize() -1) {
            return false;
        }
        return model.getLevel().getDrawable(x + 1, y).getSelected();
    }

    private boolean validateGridLocation(String location) {

        location = location.trim();     // remove leading spaces
        if (location.length() < 2)
            return false;
        int x = Character.getNumericValue(location.charAt(0));
        int y = Character.getNumericValue(location.charAt(1));
        // TODO throw exception
        if (x < 1 || y < 1 ||
                x > model.getLevel().getSize() ||
                y > model.getLevel().getSize())
            return false;
        // convert one based grid coordinates to zero based
        x--;
        y--;
        Space selected = model.getLevel().getSelectedSpace();
        if (selected != null) {
            // attempt to create pipe
            model.getLevel().createPipe(selected, x, y);
        }
        model.getLevel().setSelected(x, y);
        return true;
    }

    private void checkWinConditions() {
        if (model.checkWinConditions()) {
            view.drawVictory();
            model.setExit(true);
        }
    }
}
