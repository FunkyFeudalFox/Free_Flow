package freeFlow.view;

import freeFlow.model.GameLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @author Arjan Tammer
 * @version 1.0 3/7/2018 13:23
 */
public class HighScoresView extends BorderPane {

    private TextArea taHighscores;


    public HighScoresView() {
        initializeNodes();
        layoutNodes();
    }

    public void initializeNodes(){
        try{
            this.taHighscores = new TextArea(GameLoader.showHighScores());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        this.taHighscores.setEditable(false);
    }

    public void layoutNodes(){
        this.setCenter(this.taHighscores);


    }
}
