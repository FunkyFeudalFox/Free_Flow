package freeFlow.view.Help;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class RulesView extends BorderPane {
    private TextArea taRules = new TextArea();

    public RulesView() {
        setCenter(taRules);
        taRules.setPrefWidth(Double.MAX_VALUE);
        taRules.setPrefHeight(Double.MAX_VALUE);
        taRules.setWrapText(true);
        // taRules.setFont(Font.font("Arial",12));
        taRules.setEditable(false);
        setPrefWidth(400);
        setPrefHeight(300);
    }

    TextArea getTaRules() {
        return taRules;
    }
}
