package freeFlow.view;

import freeFlow.model.GameSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Arjan Tammer
 * @version 1.0 3/8/2018 14:46
 */
public class HighScoresPresenter {

    private GameSaver model;
    private HighScoresView view;

    public HighScoresPresenter(GameSaver model, HighScoresView view) {
        this.model = model;
        this.view = view;
        start();
        addEventHandlers();
    }

    private void start(){

    }

    private void addEventHandlers(){
        view.getBtnClose().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close HighScoresView window

            }
        });
    }
}
