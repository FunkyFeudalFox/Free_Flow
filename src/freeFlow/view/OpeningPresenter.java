package freeFlow.view;

import freeFlow.model.GameLoader;
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

    private GameLoader model;
    private OpeningView view;


    public OpeningPresenter(GameLoader model, OpeningView view) {
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
                loginStage.showAndWait();
            }
        });
        view.getBtnNewPlayer().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
