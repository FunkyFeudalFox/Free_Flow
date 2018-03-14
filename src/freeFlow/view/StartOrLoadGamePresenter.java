package freeFlow.view;

import freeFlow.model.Game;
import freeFlow.model.GameSaver;
import freeFlow.model.Player;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 16:50
 */


public class StartOrLoadGamePresenter {

    private GameSaver model;
    private StartOrLoadGameView view;
    private Player player;


    public StartOrLoadGamePresenter(GameSaver model, StartOrLoadGameView view, Player player) {
        this.model = model;
        this.view = view;
        this.player = player;
        addEventHandlers();
    }

    /*
    public void addEventHandlers(){
        view.getBtnStartEasy().setOnAction(EventHandler <ActionEvent> (){
            @Override
            public void handle(ActionEvent event){

            }


        });
    }
    */

    public void addEventHandlers() {
        view.getBtnStartEasy().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GraphicGameView graphicGameView = new GraphicGameView(5);
                //Game gameModel = new Game(0, )
                //new GraphicGamePresenter()

            }
        });

    }
}
