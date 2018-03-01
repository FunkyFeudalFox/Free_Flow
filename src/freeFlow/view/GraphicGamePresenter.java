package freeFlow.view;

import freeFlow.model.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGamePresenter {

    private Game model;
    private GraphicGameView view;

    private final long waitTime = 10_000_000 ;

    private int column;

    private int row;

    private int nextColumn;

    private int nextRow;

    private Pipe currentPipe;

    private boolean dotIsClicked = false;

    PauseTransition pause = new PauseTransition(Duration.millis(0.1));

    public GraphicGamePresenter(Game model, GraphicGameView view){
        this.model = model;
        this.view = view;
        start();
        //dotClick();
        buildPipeVersionTwo();

    }

    public void dotClick(){
        view.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                column = translateXToColumn(event.getX());
                row = translateYToRow(event.getY());
                if ((model.getLevel().getPlayingField()[column][row]) instanceof Dot) {
                    Dot currentDot = (Dot) model.getLevel().getPlayingField()[column][row];


                    currentPipe = new Pipe(currentDot.getColour(), true,
                            (Dot) model.getLevel().getPlayingField()[column][row]);
                    for (Pipe pipe : model.getLevel().getPipes()) {
                        if (pipe.getIsSelected()) {
                            pipe.setSelected(false);
                        }
                    }
                    model.getLevel().addPipe(currentPipe);
                    dotIsClicked = true;
                    buildPipe();

                }
            }
        });
    }


    public void buildPipe() {


            /*

            //pauze op MouseMoved event inbouwen
            PauseTransition pause = new PauseTransition(Duration.millis(50));
            pause.setOnFinished((ActionEvent event) -> {
                checkMouseMovedOverEmptySpace();
            });
            pause.playFromStart();
        }
    }


    //eventhandlers voor MouseMoved events over volgende vakjes,
    //vervolgens nieuwe stukken pipe tekenen

    private void checkMouseMovedOverEmptySpace(){
    */
            do {

                if (dotIsClicked) {


                view.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event2) {
                        nextColumn = translateXToColumn(event2.getX());
                        nextRow = translateYToRow(event2.getY());

                        if (column != nextColumn || row != nextRow) {

                            if (model.getLevel().getPlayingField()[nextColumn][nextRow] instanceof EmptySpace) {
                                EmptySpace currentEmptySpace = (EmptySpace) model.getLevel().getPlayingField()[nextColumn][nextRow];
                                currentEmptySpace.setPipe(currentPipe);
                                currentEmptySpace.setColour(currentPipe.getColour());
                                currentEmptySpace.setIsPartOfPipe(true);
                                model.getLevel().getPlayingField()[nextColumn][nextRow] = currentEmptySpace;

                                //tekenen. komt vanuit column en row en gaat naar nextColumn en nextRow
                                double startLocationX = translateColumnToX(column);
                                double startLocationY = translateRowToY(row);
                                double endLocationX = translateColumnToX(nextColumn);
                                double endLocationY = translateRowToY(nextRow);


                                view.drawPipe(startLocationX, startLocationY, endLocationX, endLocationY, currentPipe.getColour());
                                // stroke line (canvas.width / 12 ) lengte voor halve pipe

                                //aan het eind hiervan: column = nextColumn en row = nextRow

                            }

                            //als veld [nextColumn][nextRow] een Dot is van dezelfde kleur, dan Pipe afmaken en isLocked(true)
                            if (model.getLevel().getPlayingField()[nextColumn][nextRow] instanceof Dot) {
                                Dot currentDot = (Dot) model.getLevel().getPlayingField()[nextColumn][nextRow];
                                if (currentDot.getColour() == currentPipe.getColour()) {
                                    currentPipe.setDot2((Dot) model.getLevel().getPlayingField()[nextColumn][nextRow]);

                                    //
                                    //draw last bit of pipe on column & row to currentDot
                                    //

                                    currentPipe.setIsLocked(true);
                                }
                            }
                        }
                        column = nextColumn;
                        row = nextRow;
                    }

                });
            }

        }while (!(currentPipe.getIsLocked()&& dotIsClicked) );
    }

    public void testDrawPipe(double startLocationX, double startLocationY, Colour colour){
        view.drawPipe(startLocationX, startLocationY,950,700,colour);
    }

    public void buildPipeVersionTwo(){
        view.getCanvas().setOnMouseDragged(new EventHandler <MouseEvent>(){
            @Override
            public void handle (MouseEvent e){
                testDrawPipe(e.getX(), e.getY(), Colour.YELLOW);

            }
        });
    }

    public Game getModel() {
        return model;
    }

    private void start(){
        model.setUserName("Johannes");
        model.startGame();
        view.drawGrid(model.COLUMNS, model.ROWS);


        for (int row = 0; row < model.getLevel().getPlayingField().length; row++){
            for (int col = 0; col < model.getLevel().getPlayingField()[row].length; col++){
                Space current = model.getLevel().getPlayingField()[row][col];
                if (current instanceof Dot){
                    view.drawDot((Dot) current);
                }
            }
        }

        /*
        for (Space [] row : model.getLevel().getPlayingField()){
            for (Space space : row){
                if (space instanceof Dot)
                    view.drawDot( (Dot) space );
            }
        }
        */
    }

    private int translateXToColumn(final double x) {
        final double width = this.view.getCanvas().getWidth();
        final int columnResult = (int)(x / width * model.COLUMNS);
        if (columnResult >= 0 && columnResult < model.COLUMNS) {
            return columnResult;
        }
        else {
            return -1;
        }
    }

    private int translateYToRow(final double y) {
        final double height = this.view.getCanvas().getHeight();
        final int rowResult = (int)(y / height * model.ROWS);
        if (rowResult >= 0 && rowResult < model.ROWS) {
            return rowResult;
        }
        else {
            return -1;
        }
    }

    private double translateColumnToX(final int column){
        final double width = this.view.getCanvas().getWidth();
        final double xResult = (column / model.COLUMNS * width);
        return xResult;

    }

    private double translateRowToY(final int row){
        final double height = this.view.getCanvas().getHeight();
        final double yResult = (row / model.ROWS * height );
        return yResult;
    }


}
