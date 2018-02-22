package freeFlow.view;

import freeFlow.model.Dot;
import freeFlow.model.Game;

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

    public Game getModel() {
        return model;
    }

    private void start(){
        model.setUserName("Johannes");
        model.startGame();
        view.drawGrid(model.COLUMNS, model.ROWS);


        for (Object o  : model.getLevel().getPlayingField()){
            if ( o.getClass() == Dot.class )
                view.drawDot( (Dot) o );
        }
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