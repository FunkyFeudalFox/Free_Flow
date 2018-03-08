package freeFlow.view;

import freeFlow.MainMultipleScreens.Main;
import freeFlow.model.GameLoader;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 21:50
 */
public class LoginPresenter {

    private GameLoader model;
    private LoginView view;

    public LoginPresenter(GameLoader model, LoginView view){
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
                if (password == model.lookUpPasswordForUsername(username)){
                    //
                    //open next screen. Screen where you can start a new game or load a saved game
                    //
                    //StartOrLoadView startOrLoadView = new StartOrLoadView();
                    //Main.primaryStage.setScene(new Scene (startOrLoadView);
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
