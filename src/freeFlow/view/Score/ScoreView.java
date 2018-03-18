package freeFlow.view.Score;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ScoreView extends BorderPane {

    private TableView table;
    private ObservableList<HighScore> data = FXCollections.observableArrayList();

    public ScoreView() {

        table = new TableView();
        table.setEditable(false);

        TableColumn nameColumn = new TableColumn("Speler");
        nameColumn.setCellValueFactory(new PropertyValueFactory<HighScore, String>("name"));
        nameColumn.setPrefWidth(200);
        TableColumn scoreColumn = new TableColumn("Aantal zetten");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<HighScore, Integer>("score"));

        table.getColumns().addAll(nameColumn, scoreColumn);
        setCenter(table);

        setPrefWidth(300);
        setPrefHeight(300);
    }

    public void addHighScore(String name, int score) {
        data.add(new HighScore(name, score));
        table.setItems(data);
        table.refresh();
    }


    public class HighScore {
        private final SimpleStringProperty name;
        private final SimpleIntegerProperty score;

        public HighScore(String name, int score) {
            this.name = new SimpleStringProperty(name);
            this.score = new SimpleIntegerProperty(score);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public Integer getScore() {
            return score.get();
        }

        public void setScore(int score) {
            this.score.set(score);
        }
    }
}
