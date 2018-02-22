package freeFlow.view;

import freeFlow.model.Dot;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGameView extends BorderPane {

    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }


    private int levelSize;

    public GraphicGameView(int levelSize){
        this.initializeNodes();
        this.layoutNodes();
        this.levelSize = levelSize;
    }

    public void initializeNodes(){
        this.canvas = new Canvas(1000,1000);
    }



    public void layoutNodes(){

        this.setCenter(this.canvas);
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

        double locationX = (dot.getX() * canvas.getWidth() / levelSize);
        locationX+=25;
        double locationY = (dot.getY() * canvas.getWidth() / levelSize );
        locationY+=25;


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
