package freeFlow.view;

import freeFlow.model.GameSaver;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 13:23
 */
public class HighScoresView extends BorderPane {

    private TextArea taHighscores;
    private Button btnClose;


    public HighScoresView() {
        initializeNodes();
        layoutNodes();
    }

    public void initializeNodes(){
        this.btnClose = new Button("Close");
        try{
            this.taHighscores = new TextArea(GameSaver.showHighScores());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        this.taHighscores.setEditable(false);
    }

    public void layoutNodes(){
        this.setCenter(this.taHighscores);
        this.setBottom(this.btnClose);
    }

    public Button getBtnClose() {
        return btnClose;
    }
}
