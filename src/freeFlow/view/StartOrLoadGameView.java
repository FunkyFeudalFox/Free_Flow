package freeFlow.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @author Arjan Tammer
 * @version 1.0 3/9/2018 16:50
 */
public class StartOrLoadGameView extends GridPane {

    private Label lblStartOrLoad;
    private Button btnStartEasy;
    private Button btnStartMedium;
    private Button btnStartHard;
    private Button btnLoad;

    public StartOrLoadGameView() {
        initializeNodes();
        layoutNodes();
    }

    public void initializeNodes(){
        lblStartOrLoad = new Label("Would you like to start a new game \n" +
                "or load a saved game?");
        btnStartEasy = new Button("Start new game in mode easy");
        btnStartMedium = new Button("Start new game in mode medium");
        btnStartHard = new Button("Start new game in mode hard");
        btnLoad = new Button("Load saved game");

    }

    public void layoutNodes(){
        this.add(lblStartOrLoad, 0,0,3,1);
        this.setHalignment(lblStartOrLoad, HPos.CENTER);
        this.add(btnStartEasy, 1,2);
        this.add(btnStartMedium, 1,3);
        this.add(btnStartHard, 1,4);
        this.add(btnLoad, 1, 6);
        this.setPadding(new Insets(15));
        this.setVgap(10);
        this.setHgap(10);
    }

    public Button getBtnStartEasy() {
        return btnStartEasy;
    }

    public Button getBtnStartMedium() {
        return btnStartMedium;
    }

    public Button getBtnStartHard() {
        return btnStartHard;
    }

    public Button getBtnLoad() {
        return btnLoad;
    }
}
