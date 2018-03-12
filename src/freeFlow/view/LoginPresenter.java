package freeFlow.view;

import freeFlow.model.GameSaver;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 21:50
 */
public class LoginPresenter {

    private GameSaver model;
    private LoginView view;

    public LoginPresenter(GameSaver model, LoginView view){
        this.model = model;
        this.view = view;

        view.getBtnLogin().setOnMouseClicked(new ButtonClickHandler());
    }

    private class ButtonClickHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event){
            //validate chosen password
            String username = view.getCbUsername().getValue().toString();
            String password = view.getTfPassword().getText();
            try{
                if (password.equals(model.lookUpPasswordForUsername(username)) ){
                    //
                    //open next screen. Screen where you can start a new game or load a saved game
                    //
                    //StartOrLoadView startOrLoadView = new StartOrLoadView();
                    //Main.primaryStage.setScene(new Scene (startOrLoadView);

                    StartOrLoadGameView startOrLoadGameView = new StartOrLoadGameView();
                    new StartOrLoadGamePresenter(model, startOrLoadGameView);
                    Stage startOrLoadStage = new Stage();
                    startOrLoadStage.initOwner(view.getScene().getWindow());
                    startOrLoadStage.initModality(Modality.APPLICATION_MODAL);
                    startOrLoadStage.setScene(new Scene(startOrLoadGameView));
                    startOrLoadStage.setX(view.getScene().getWindow().getX());
                    startOrLoadStage.setY(view.getScene().getWindow().getY());
                    startOrLoadStage.setTitle("Start a game or load a saved game");
                    startOrLoadStage.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong password. Try again", ButtonType.OK);
                    alert.showAndWait();
                }
            }
            catch (NoSuchElementException | NumberFormatException e1) {
                System.out.println(e1.getMessage());
                System.out.println(e1.getStackTrace());
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }


        }
    }
}
