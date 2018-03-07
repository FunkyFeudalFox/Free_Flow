package freeFlow.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 13:37
 */
public class OpeningView extends GridPane {

    private Label message;
    private Button btnNewPlayer;
    private Button btnLogin;

    public OpeningView(){
        this.initializeNodes();
        this.layoutNodes();
    }


    public void initializeNodes(){
        this.message = new Label("Welcome to Free Flow. Would you like to create a new player account\n" +
                "or would you like to login as an existing player?");
        this.btnNewPlayer = new Button("Create new player account");
        this.btnLogin = new Button("login as existing player");
    }

    public void layoutNodes(){
        this.add(message, 0,0,3,1);
        this.setHalignment(message, HPos.CENTER);
        this.add(btnNewPlayer,0,1);
        this.add(btnLogin,3,1);
        this.setPadding(new Insets(15));
        this.setVgap(10);
    }

}
