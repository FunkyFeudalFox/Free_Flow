package freeFlow.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author Arjan Tammer
 * @version 1.0 3/10/2018 18:12
 */
public class CreatePlayerView extends GridPane {

    private TextField tfName;
    private Label lblName;
    private TextField tfUsername;
    private Label lblUsername;
    private TextField tfPassword;
    private Label lblPassword;
    private Button btnCreate;

    public CreatePlayerView() {
        initializeNodes();
        layoutNodes();
    }

    public Button getBtnCreate() {
        return btnCreate;
    }

    public TextField getTfName() {
        return tfName;
    }

    public TextField getTfUsername() {
        return tfUsername;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }

    public void initializeNodes(){
        this.lblName = new Label("Name: ");
        this.tfName = new TextField();
        this.lblUsername = new Label("Username: ");
        this.tfUsername = new TextField();
        this.lblPassword = new Label("Password: ");
        this.tfPassword = new TextField();
        this.btnCreate = new Button("Create Player account");
    }

    public void layoutNodes(){
        this.add(lblName,0,0);
        this.add(tfName, 1,0);
        this.add(lblUsername, 0, 1);
        this.add(tfUsername, 1,1);
        this.add(lblPassword, 0,2);
        this.add(tfPassword, 1, 2);
        this.add(btnCreate, 1,3);
    }
}
