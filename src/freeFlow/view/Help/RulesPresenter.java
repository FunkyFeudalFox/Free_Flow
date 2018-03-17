package freeFlow.view.Help;

import freeFlow.model.FreeFlowException;
import freeFlow.model.Rules;
import javafx.scene.control.Alert;

public class RulesPresenter {
    public RulesPresenter(RulesView view) {
        try {
            view.getTaRules().setText(new Rules().getRules());
        } catch (FreeFlowException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
