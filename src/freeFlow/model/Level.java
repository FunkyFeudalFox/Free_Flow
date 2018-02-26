package freeFlow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:23
 */
public class Level {
    private Space [][] playingField;
    private List <Score> highScores;
    private List <Pipe> pipes;

    private int size;

    private Space selectedSpace;

    public int getSize() {
        return size;
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    private int levelNumber;

    public Level(int size) {
        this.size = size;
        levelNumber = 1;
        playingField = new Space[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                playingField[x][y] = new EmptySpace();
            }
        }
        highScores = new ArrayList<>();
        pipes = new ArrayList<>();
        selectedSpace = null;
    }

    protected String displayLevelSize(){
        return String.format("Level %d %dx%d", levelNumber, size, size);
    }

    public void addDot(Dot dot) {
        this.playingField[dot.x][dot.y] = dot;
    }

    public void addEmptySpace(EmptySpace emptySpace){ this.playingField[emptySpace.x][emptySpace.y] = emptySpace;}

    public void addPipe(Pipe pipe) {this.pipes.add(pipe); }

    public void addPipePart(PipePart pipePart){
        this.playingField[pipePart.getX()][pipePart.getY()] = pipePart;
    }

    public void setSelected(int x, int y) {
        if (selectedSpace != null)
            selectedSpace.setSelected(false);
        selectedSpace = this.playingField[x][y];
        this.playingField[x][y].setSelected(true);
    }

    public Space getSelectedSpace() {
        return selectedSpace;
    }

    public Space [][] getPlayingField() {
        return playingField;
    }

    public Space getDrawable(int x, int y) {
        return playingField[x][y];
    }

    public void createPipe(Space fromSpace, int toX, int toY) {
        if (fromSpace.getX() != toX
                && fromSpace.getY() != toY) {
            // can only create straight line
            return;
        }
        // validate spaces between start and end point
        for (int x = fromSpace.getX(); x <= toX; x++) {
            for (int y = fromSpace.getY(); y <= toY; y++) {
                if (!playingField[x][y].isCreatePipeValid(fromSpace.getColour()))
                    return;
            }
        }
        // validation OK => create pipe
        int startX = fromSpace.getX() <= toX ? fromSpace.getX() : toX;
        int startY = fromSpace.getY() <= toY ? fromSpace.getY() : toY;
        int endX = toX > fromSpace.getX() ? toX : fromSpace.getX();
        int endY = toY > fromSpace.getY() ? toY : fromSpace.getY();
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (playingField[x][y] instanceof EmptySpace)
                    addPipePart(new PipePart(x, y, fromSpace.getColour()));
            }
        }
        // lock dots
        if (fromSpace instanceof Dot)
            ((Dot) fromSpace).setLocked();
        if (playingField[toX][toY] instanceof Dot)
            ((Dot) playingField[toX][toY]).setLocked();
    }

}
