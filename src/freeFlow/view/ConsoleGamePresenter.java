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
        }
    }

    private void drawLevel() {
        for (int y = 0; y < model.getLevel().getSize(); y++) {
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

        int x = Character.getNumericValue(location.charAt(0));
        int y = Character.getNumericValue(location.charAt(1));
        // TODO throw exception
        if (x < 0 || y < 0 ||
                x >= model.getLevel().getSize() ||
                y >= model.getLevel().getSize())
            return false;
        Space selected = model.getLevel().getSelectedSpace();
        if (selected != null) {
            // attempt to create pipe
            model.getLevel().createPipe(selected, x, y);
        }
        model.getLevel().setSelected(x, y);
        return true;
    }
}
