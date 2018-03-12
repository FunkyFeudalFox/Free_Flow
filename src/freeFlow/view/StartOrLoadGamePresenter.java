package freeFlow.view;

import freeFlow.model.GameSaver;

/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 16:50
 */
public class StartOrLoadGamePresenter {

    private GameSaver model;
    private StartOrLoadGameView view;


    public StartOrLoadGamePresenter(GameSaver model, StartOrLoadGameView view) {
        this.model = model;
        this.view = view;
    }



}
