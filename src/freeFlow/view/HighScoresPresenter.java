package freeFlow.view;

import freeFlow.model.GameLoader;

/**
 * @author Arjan Tammer
 * @version 1.0 3/8/2018 14:46
 */
public class HighScoresPresenter {

    private GameLoader model;
    private HighScoresView view;

    public HighScoresPresenter(GameLoader model, HighScoresView view) {
        this.model = model;
        this.view = view;
        start();
    }

    private void start(){

    }
}
