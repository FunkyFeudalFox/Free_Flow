package freeFlow.view;

import freeFlow.model.Dot;
import freeFlow.model.Game;
import freeFlow.model.Pipe;
import freeFlow.model.Space;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author Arjan Tammer
 * @version 1.0 2/16/2018 15:15
 */
public class GraphicGamePresenter {

    private Game model;
    private GraphicGameView view;

    public GraphicGamePresenter(Game model, GraphicGameView view){
        this.model = model;
        this.view = view;
        start();
    }

    public void buildPipe(){
        view.getCanvas().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                int column = translateXToColumn(event.getX());
                int row = translateYToRow(event.getY());
                if ((model.getLevel().getPlayingField()[column][row]) instanceof Dot){
                    Dot currentDot = (Dot)model.getLevel().getPlayingField()[column][row];

                    Pipe currentPipe = new Pipe(currentDot.getColour(), true,
                            (Dot)model.getLevel().getPlayingField()[column][row] );
                    for (Pipe pipe : model.getLevel().getPipes()){
                        if (pipe.getIsSelected()){
                            pipe.setSelected(false);
                        }
                    }
                    model.getLevel().addPipe(currentPipe);

                    //eventhandlers voor MouseMoved events over volgende vakjes,
                    //vervolgens nieuwe stukken pipe tekenen

                    view.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event2){
                            int nextColumn = translateXToColumn(event2.getX());
                            int nextRow = translateYToRow(event2.getY());
                            if (column != nextColumn || row != nextRow){

                            }
                        }
                    });
                }
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


}
