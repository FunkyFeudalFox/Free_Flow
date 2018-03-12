package freeFlow.view;

import freeFlow.model.GameSaver;
import freeFlow.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/10/2018 18:12
 */
public class CreatePlayerPresenter {

    private GameSaver model;
    private CreatePlayerView view;

    public CreatePlayerPresenter(GameSaver model, CreatePlayerView view) {
        this.model = model;
        this.view = view;
        start();
        addEventHandlers();
    }

    public void start() {

    }

    private void addEventHandlers(){
        view.getBtnCreate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    //validate fields
                if (view.getTfName().getText() == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the field Name", ButtonType.OK);
                    alert.showAndWait();
                }
                if (view.getTfUsername().getText() == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the field Username", ButtonType.OK);
                    alert.showAndWait();
                }
                if (view.getTfPassword().getText() == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the field Password", ButtonType.OK);
                    alert.showAndWait();
                }
                Player newPlayer = new Player(view.getTfName().getText(), view.getTfUsername().getText(), view.getTfPassword().getText());
                try {
                    model.getPlayerList().add(newPlayer);
                    model.playerList2TxtFile(model.getPlayerList());
                }catch (IOException e){
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                }
            }
        });
    }



}
