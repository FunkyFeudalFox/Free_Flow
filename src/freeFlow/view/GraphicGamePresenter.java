package freeFlow.view;

import freeFlow.model.*;
import freeFlow.view.Help.RulesPresenter;
import freeFlow.view.Help.RulesView;
import freeFlow.view.Score.ScorePresenter;
import freeFlow.view.Score.ScoreView;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
        addMenuEventHandlers();
    }

    private void start(){
        // model.setUserName("Johannes");
        // model.startGame();
        refreshView();
    }

    public Game getModel() {
        return model;
    }

    private int translateXToColumn(final double x) {
        final double width = this.view.getCanvas().getWidth();
        final int columnResult = (int) (x / width * model.getColumns());
        if (columnResult >= 0 && columnResult < model.getColumns()) {
            return columnResult;
        } else {
            return -1;
        }
    }

    private int translateYToRow(final double y) {
        final double height = this.view.getCanvas().getHeight();
        final int rowResult = (int) (y / height * model.getRows());
        if (rowResult >= 0 && rowResult < model.getRows()) {
            return rowResult;
        } else {
            return -1;
        }
    }

    private int translateColumnToX(final int column) {
        final double width = this.view.getCanvas().getWidth();
        final int xResult = (int) (column * width / model.getColumns());
        return xResult;

    }

    private int translateRowToY(final int row) {
        final double height = this.view.getCanvas().getHeight();
        final int yResult = (int) (row * height / model.getRows());
        return yResult;
    }

    private void redraw(Space space) {
        if (space instanceof EmptySpace) {
            view.drawSpace(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getIsSelected());
        } else if (space instanceof Dot) {
            view.drawDot(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getColour(), space.getIsSelected());
        } else if (space instanceof PipePart) {
            view.drawPipePart(translateColumnToX(space.getX()), translateRowToY(space.getY()), space.getColour(), ((PipePart) space).getOrientation(), space.getIsSelected());

            //model.setMoveNumber(model.getMoveNumber() + 1);
        }
    }

    private void refreshView() {
        view.drawGrid(model.getColumns(), model.getRows());
        for (int row = 0; row < model.getLevel().getPlayingField().length; row++) {
            for (int col = 0; col < model.getLevel().getPlayingField()[row].length; col++) {
                redraw(model.getLevel().getPlayingField()[row][col]);
            }
        }
    }

    private void checkWinConditions() {
        if (model.checkWinConditions()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, String.format("Proficiat! Je hebt gewonnen in %d stappen.", model.getMoveNumber()), ButtonType.OK);
            alert.showAndWait();
            Score score = new Score(model.getPlayer().getUsername(), model.getMoveNumber());
            model.addHighScore(score);
            showHighScores();
            exit();
        }
    }

    private void showHighScores() {
        ScoreView scoreView = new ScoreView();
        new ScorePresenter(scoreView, model.getLevel().getHighScores());
        Stage scoreStage = new Stage();
        scoreStage.setTitle("Highscores");
        scoreStage.initOwner(view.getScene().getWindow());
        scoreStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(scoreView);
        scoreStage.setScene(scene);
        scoreStage.setX(view.getScene().getWindow().getX());
        scoreStage.setY(view.getScene().getWindow().getY() + 100);
        scoreStage.showAndWait();
    }

    private void exit() {
        model.setExit(true);
        ((Stage) view.getCanvas().getScene().getWindow()).close();
    }

    private void addMenuEventHandlers() {
        view.getMiExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit();
            }
        });
        view.getMiShow().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RulesView rulesView = new RulesView();
                new RulesPresenter(rulesView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Spelregels");
                helpStage.initOwner(view.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(rulesView);
                helpStage.setScene(scene);
                helpStage.setX(view.getScene().getWindow().getX());
                helpStage.setY(view.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });
    }

    private class MouseClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            // convert mouse position to grid column/row
            int column = translateXToColumn(event.getX());
            int row = translateYToRow(event.getY());
            Space selected = model.getLevel().getSelectedSpace();
            if (selected != null) {
                //redraw(selected);
                // model.getLevel().createPipe(selected, column, row);
                model.makeMove(selected, column, row);
            }
            model.getLevel().setSelected(column, row);
            //view.drawSelection(translateColumnToX(column), translateRowToY(row));
            refreshView();
            checkWinConditions();
        }
    }
}
