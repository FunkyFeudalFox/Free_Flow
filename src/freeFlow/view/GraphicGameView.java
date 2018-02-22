package freeFlow.view;

import freeFlow.model.Colour;
import freeFlow.model.Dot;
import freeFlow.model.Level;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGameView extends BorderPane {

    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    private GraphicGamePresenter presenter;

    public GraphicGameView(){
        this.initializeNodes();
        this.layoutNodes();
    }

    /*
    private String [] canvasNumbers = {"00", "01", "02", "03", "04", "05", "10", "11", "12", "13",
            "14", "15", "20", "21", "22", "23", "24", "25", "30", "31", "32", "33", "34", "35", "40",
            "41", "42", "43", "44", "45", "50", "51", "52", "53", "54", "55"};
    */

    public void initializeNodes(){
        this.canvas = new Canvas(1000,1000);
    }


        /*
        for (int x = 0; x <= 5; x++){
            for (int y = 0; y <= 5; y++){
                Canvas canvas = new Canvas();
                canvas.setHeight(100);
                canvas.setWidth(100);
                canvas.setId(x + " " + y );
                this.add(canvas, x, y);
            }
        }

        for (String number : canvasNumbers){
            Canvas canvas = new Canvas();
            canvas.setHeight(100);
            canvas.setWidth(100);
            canvas.setId(number);
        }
    }
    */



    public void layoutNodes(){

        this.setCenter(this.canvas);

        /*
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        ColumnConstraints column3 = new ColumnConstraints(100);
        ColumnConstraints column4 = new ColumnConstraints(100);
        ColumnConstraints column5 = new ColumnConstraints(100);
        this.getColumnConstraints().addAll(column1, column2, column3, column4, column5);
        RowConstraints row1 = new RowConstraints(100);
        RowConstraints row2 = new RowConstraints(100);
        RowConstraints row3 = new RowConstraints(100);
        RowConstraints row4 = new RowConstraints(100);
        RowConstraints row5 = new RowConstraints(100);
        this.getRowConstraints().addAll(row1, row2, row3, row4, row5);
        */
    }

    protected void drawGrid(int columns, int rows){
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();

        final double totalWidth = this.canvas.getWidth();
        final double totalHeight = this.canvas.getHeight();
        final double rowHeight = totalHeight / rows;
        final double columnWidth = totalWidth / columns;

        for (int r = 1; r < rows; r++) {
            gc.strokeLine(0.0, rowHeight * r, totalWidth, rowHeight * r);
        }

        for (int c = 1; c < columns; c++) {
            gc.strokeLine(columnWidth * c, 0.0, columnWidth * c, totalHeight);
        }
    }

    protected void drawDot(Dot dot){

        /*
        //parameters omzetten naar een positie op het Canvas
        double locationX = (column * canvas.getWidth() / presenter.getModel().getCOLUMNS());
        double locationY =  (row * canvas.getHeight()/ presenter.getModel().getROWS());
        */
        double locationX = (dot.getX() * canvas.getWidth() / presenter.getModel().getCOLUMNS());
        double locationY = (dot.getY() * canvas.getWidth() / presenter.getModel().getROWS() );


        final GraphicsContext gc = this.canvas.getGraphicsContext2D();

        Color color;
        switch (dot.getColour()){
            case RED: gc.setFill(Color.RED);
                break;

            case GREEN: gc.setFill(Color.GREEN);
                break;

            case YELLOW: gc.setFill(Color.YELLOW);
                break;

            case BLUE: gc.setFill(Color.BLUE);
                break;

            case ORANGE: gc.setFill(Color.ORANGE);
                break;

            case PINK: gc.setFill(Color.PINK);
                break;

            case CYAN: gc.setFill(Color.CYAN);
                break;

            case DARKBROWN: gc.setFill(Color.BROWN);
                break;

            case LILAC: gc.setFill(Color.MEDIUMPURPLE);
                break;
        }
        gc.fillOval(locationX ,locationY,150,150);
        setCenter(canvas);
    }


}
