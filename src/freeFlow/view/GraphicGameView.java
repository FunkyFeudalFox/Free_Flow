package freeFlow.view;

import freeFlow.model.Colour;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGameView extends BorderPane {

    private static final int BASE_CANVAS_WIDTH = 500;
    private static final int BASE_CANVAS_HEIGHT = 500;
    private static final int DOT_GRID_MARGIN = 10;
    private static final int PIPE_GRID_MARGIN = 20;
    private Canvas canvas;

    private int levelSize;
    private double spaceWidth;
    private double spaceHeight;

    public GraphicGameView(int levelSize){
        this.initializeNodes();
        this.layoutNodes();
        this.levelSize = levelSize;
    }

    public void initializeNodes(){
        this.canvas = new Canvas(BASE_CANVAS_WIDTH, BASE_CANVAS_HEIGHT);
    }

    public void layoutNodes(){
        this.setCenter(this.canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    protected void drawGrid(int columns, int rows){
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();

        double totalWidth = this.canvas.getWidth();
        double totalHeight = this.canvas.getHeight();
        spaceHeight = totalHeight / rows;
        spaceWidth = totalWidth / columns;

        for (int r = 1; r < rows; r++) {
            gc.strokeLine(0.0, spaceHeight * r, totalWidth, spaceHeight * r);
        }

        for (int c = 1; c < columns; c++) {
            gc.strokeLine(spaceWidth * c, 0.0, spaceWidth * c, totalHeight);
        }
    }

    protected void drawDot(int x, int y, Colour colour, boolean isSelected) {

        drawSpace(x, y, isSelected);    // redraw background
        x += DOT_GRID_MARGIN / 2;
        y += DOT_GRID_MARGIN / 2;

        final GraphicsContext gc = this.canvas.getGraphicsContext2D();

        gc.setFill(colour.getColour());
        gc.fillOval(x, y, spaceWidth - DOT_GRID_MARGIN, spaceHeight - DOT_GRID_MARGIN);
    }

    protected void drawPipe(double startLocationX, double startLocationY, double endLocationX, double endLocationY, Colour colour){
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();


        //choose colour


        //draw
        gc.strokeLine (startLocationX, startLocationY, endLocationX, endLocationY);
        // also an option:
        //gc.strokeRect();
        //double x, double y, double w, double h

    }

    protected void drawSpace(int x, int y, boolean isSelected) {
        final GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(isSelected ? Color.BLACK : Color.WHITE);
        gc.fillRect(x + 1, y + 1, spaceWidth - 2, spaceHeight - 2);
    }

    protected void drawPipePart(int x, int y, Colour colour, boolean isSelected) {
        drawSpace(x, y, isSelected);    // redraw background
        x += PIPE_GRID_MARGIN;

        final GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(colour.getColour());
        gc.fillRect(x, y, spaceWidth - PIPE_GRID_MARGIN, spaceHeight);
    }

}
