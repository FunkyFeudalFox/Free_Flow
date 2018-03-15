package freeFlow.view;

import freeFlow.model.Game;
import freeFlow.model.GameSaver;
import freeFlow.model.Level;
import freeFlow.model.Player;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 16:50
 */


public class StartOrLoadGamePresenter {

    private GameSaver model;
    private StartOrLoadGameView view;
    private Player player;
    private Game gameModel;

    public Game getGameModel() {
        return gameModel;
    }

    public StartOrLoadGamePresenter(GameSaver model, StartOrLoadGameView view, Player player) {
        this.model = model;
        this.view = view;
        this.player = player;
        addEventHandlers();
    }


    public void addEventHandlers() {
        view.getBtnStartEasy().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GraphicGameView graphicGameView = new GraphicGameView(5);
                Level level = new Level(5);
                gameModel = new Game(0, player, level );
                model.setGameModel(gameModel);
                GraphicGamePresenter graphicGamePresenter = new GraphicGamePresenter(gameModel, graphicGameView);
                Stage graphicGameStage = new Stage();
                graphicGameStage.initOwner(view.getScene().getWindow());
                graphicGameStage.initModality(Modality.APPLICATION_MODAL);
                graphicGameStage.setScene(new Scene(graphicGameView));
                graphicGameStage.setX(view.getScene().getWindow().getX());
                graphicGameStage.setY(view.getScene().getWindow().getY());
                graphicGameStage.setTitle("Free Flow mode: easy");
                graphicGameStage.showAndWait();

            }
        });

    }
}
