package freeFlow.view;

import freeFlow.model.GameSaver;
import freeFlow.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/10/2018 18:12
 */
public class CreatePlayerPresenter {

    private GameSaver model;
    private CreatePlayerView view;
    private Player player;

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
                Alert createdNotification = new Alert(Alert.AlertType.CONFIRMATION, "new Player account created", ButtonType.OK);
                createdNotification.showAndWait();
                player = newPlayer;

                StartOrLoadGameView startOrLoadGameView = new StartOrLoadGameView();
                new StartOrLoadGamePresenter(model, startOrLoadGameView, player);
                Stage startOrLoadStage = new Stage();
                startOrLoadStage.initOwner(view.getScene().getWindow());
                startOrLoadStage.initModality(Modality.APPLICATION_MODAL);
                startOrLoadStage.setScene(new Scene(startOrLoadGameView));
                startOrLoadStage.setX(view.getScene().getWindow().getX());
                startOrLoadStage.setY(view.getScene().getWindow().getY());
                startOrLoadStage.setTitle("Start a game or load a saved game");
                startOrLoadStage.showAndWait();
            }
        });
    }



}
