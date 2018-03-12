package freeFlow.view;

import freeFlow.model.GameSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 11:52
 */
public class OpeningPresenter {

    private GameSaver model;
    private OpeningView view;


    public OpeningPresenter(GameSaver model, OpeningView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    public void addEventHandlers(){
        view.getBtnLogin().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView loginView = new LoginView();
                new LoginPresenter(model, loginView);
                Stage loginStage = new Stage();
                loginStage.initOwner(view.getScene().getWindow());
                loginStage.initModality(Modality.APPLICATION_MODAL);
                loginStage.setScene(new Scene(loginView));
                loginStage.setX(view.getScene().getWindow().getX());
                loginStage.setY(view.getScene().getWindow().getY());
                loginStage.setTitle("Login");
                loginStage.showAndWait();
            }
        });
        view.getBtnNewPlayer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreatePlayerView createPlayerView = new CreatePlayerView();
                GameSaver gameSaverModel = new GameSaver();
                new CreatePlayerPresenter(gameSaverModel, createPlayerView);
                Stage createPlayerStage = new Stage();
                createPlayerStage.initOwner(view.getScene().getWindow());
                createPlayerStage.initModality(Modality.APPLICATION_MODAL);
                createPlayerStage.setScene(new Scene(createPlayerView));
                createPlayerStage.setX(view.getScene().getWindow().getX());
                createPlayerStage.setY(view.getScene().getWindow().getY());
                createPlayerStage.setTitle("Create new Player account");
                createPlayerStage.showAndWait();
            }
        });

    }
}
