package freeFlow.view;

import freeFlow.model.GameLoader;
import javafx.scene.control.Label;

/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 16:50
 */
public class StartOrLoadGamePresenter {

    private GameLoader model;
    private StartOrLoadGameView view;


    public StartOrLoadGamePresenter(GameLoader model, StartOrLoadGameView view) {
        this.model = model;
        this.view = view;
    }



}
