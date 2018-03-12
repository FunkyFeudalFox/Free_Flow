package freeFlow.view;

import freeFlow.model.*;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGamePresenter {

    private Game model;
    private GraphicGameView view;

    private final long waitTime = 10_000_000 ;

    private int column;

    private int row;

    private int nextColumn;

    private int nextRow;

    private Pipe currentPipe;

    private boolean dotIsClicked = false;

    PauseTransition pause = new PauseTransition(Duration.millis(0.1));

    public GraphicGamePresenter(Game model, GraphicGameView view){
        this.model = model;
        this.view = view;
        // init event handlers
        start();
        view.getCanvas().setOnMouseClicked(new MouseClickHandler());
    }

    private void start(){
        model.setUserName("Johannes");
        model.startGame();
        refreshView();
    }

    public Game getModel() {
        return model;
    }

    private int translateXToColumn(final double x) {
        final double width = this.view.getCanvas().getWidth();
        final int columnResult = (int)(x / width * model.COLUMNS);
        if (columnResult >= 0 && columnResult < model.COLUMNS) {
            return columnResult;
        } else {
            return -1;
        }
    }

    private int translateYToRow(final double y) {
        final double height = this.view.getCanvas().getHeight();
        final int rowResult = (int)(y / height * model.ROWS);
        if (rowResult >= 0 && rowResult < model.ROWS) {
            return rowResult;
        } else {
            return -1;
        }
    }

    private int translateColumnToX(final int column) {
        final double width = this.view.getCanvas().getWidth();
        final int xResult = (int) (column * width / model.COLUMNS);
        return xResult;

    }

    private int translateRowToY(final int row) {
        final double height = this.view.getCanvas().getHeight();
        final int yResult = (int) (row * height / model.ROWS);
        return yResult;
    }

    private void redraw(Space space) {
        if (space instanceof EmptySpace) {
            view.drawSpace(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getSelected());
        } else if (space instanceof Dot) {
            view.drawDot(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getColour(), space.getSelected());
        } else if (space instanceof PipePart) {
            view.drawPipePart(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getColour(), ((PipePart) space).getOrientation(), space.getSelected());
        }
    }

    private void refreshView() {
        view.drawGrid(model.COLUMNS, model.ROWS);
        for (int row = 0; row < model.getLevel().getPlayingField().length; row++) {
            for (int col = 0; col < model.getLevel().getPlayingField()[row].length; col++) {
                redraw(model.getLevel().getPlayingField()[row][col]);
            }
        }
    }

    private void checkWinConditions() {
        if (model.checkWinConditions()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Proficiat! Je hebt gewonnen", ButtonType.OK);
            alert.showAndWait();
            exit();
        }
    }

    private void exit() {
        model.setExit(true);
        ((Stage) view.getCanvas().getScene().getWindow()).close();
    }

    private class MouseClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            // convert mouse position to grid column/row
            int column = translateXToColumn(event.getX());
            int row = translateYToRow(event.getY());
            Space selected = model.getLevel().getSelectedSpace();
            if (selected != null) {
                redraw(selected);
                model.getLevel().createPipe(selected, column, row);
            }
            model.getLevel().setSelected(column, row);
            //view.drawSelection(translateColumnToX(column), translateRowToY(row));
            refreshView();
            checkWinConditions();
        }
    }
}
