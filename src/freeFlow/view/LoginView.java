package freeFlow.view;

import freeFlow.model.GameLoader;
import freeFlow.model.GameSaver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 14:02
 */
public class LoginView extends GridPane {

    private Label lblUsername;
    private Label lblPassword;
    private ComboBox cbUsername;
    private TextField tfPassword;
    private Button btnLogin;


    public LoginView(){
        initializeNodes();
        layoutNodes();
    }

    public void initializeNodes(){
        lblUsername = new Label("Username: ");
        lblPassword = new Label("Password: ");
        try {
            cbUsername = new ComboBox<>();
            ObservableList<String> names = FXCollections.observableArrayList(GameLoader.txtFile2LoginList());
        }catch (NoSuchElementException | NumberFormatException e1) {
            System.out.println(e1.getCause());
            System.out.println(e1.getMessage());
            System.out.println(e1.getStackTrace());
        }
        catch (IOException e2) {
            System.out.println(e2.getCause());
            System.out.println(e2.getMessage());
            System.out.println(e2.getStackTrace());
        }
        tfPassword = new TextField();
        btnLogin = new Button("Login");
    }

    public void layoutNodes(){
        this.add(lblUsername, 0,1);
        this.add(cbUsername, 1,1);
        this.add(lblPassword, 0,2);
        this.add(tfPassword, 1,2);
        this.add(btnLogin,0,3,2,1);
        this.setHalignment(btnLogin, HPos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10));
        this.setGridLinesVisible(false);
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public ComboBox getCbUsername() {
        return cbUsername;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }
}
