package freeFlow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:23
 */
public class Level {
    private Space [][] playingField;

    public Space [][] getPlayingField() {
        return playingField;
    }



    private List <Score> highScores;

    public List<Score> getHighScores() {
        return highScores;
    }

    public int getHighScoresSize(){
        return highScores.size();
    }

    public void setHighScores(List<Score> highScores) {
        this.highScores = highScores;
    }

    private List <Pipe> pipes;

    public List<Pipe> getPipes() {
        return pipes;
    }

    public int getPipesSize(){
        return pipes.size();
    }

    private int size;

    public int getSize() {
        return size;
    }

    private Space selectedSpace;

    public Space getSelectedSpace() {
        return selectedSpace;
    }

    public Space getDrawable(int x, int y) {
        return playingField[x][y];
    }

    private int levelNumber;

    public Level(int size) {
        this.size = size;
        levelNumber = 1;
        playingField = new Space[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                playingField[x][y] = new EmptySpace(x, y);
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
        // scan surroundings to determine orientation and connections
        //connectPipe(pipePart.getX(), pipePart.getY(), pipePart.getColour());
    }

    /*    private void connectPipe(int originColumn, int originRow, Colour originColour) {
            for (int row = -1; row <= 1; row++) {
                for (int column = -1; column <= 1; column++) {
                    Space space = playingField[originColumn + column][originRow + row];
                    if (space.getColour().equals(originColour))
                        //pipe.
                }
            }
        }*/
    private void connectPipeParts(Space fromSpace, Space toSpace) {
        fromSpace.setLocked(toSpace);
        if (toSpace instanceof PipePart)
            ((PipePart) toSpace).setConnection1(fromSpace);
        else
            ((Dot) toSpace).setLocked(fromSpace);
    }

    public void setSelected(int x, int y) {
        if (selectedSpace != null)
            selectedSpace.setSelected(false);
        selectedSpace = this.playingField[x][y];
        this.playingField[x][y].setSelected(true);
    }


    public void createPipe(Space fromSpace, int toX, int toY) {
        if (fromSpace instanceof EmptySpace)
            // can't create pipe from empty space
            return;
        if (fromSpace.getX() != toX
                && fromSpace.getY() != toY) {
            // can only create straight line
            return;
        }
        // validate spaces between start and end point
        int modX = fromSpace.getX() <= toX ? 1 : -1;
        int modY = fromSpace.getY() <= toY ? 1 : -1;
        int startX = fromSpace.getX() <= toX ? fromSpace.getX() : toX;
        int startY = fromSpace.getY() <= toY ? fromSpace.getY() : toY;
        int endX = toX > fromSpace.getX() ? toX : fromSpace.getX();
        int endY = toY > fromSpace.getY() ? toY : fromSpace.getY();
        //for (int x = startX; x <= endX; x++) {
        for (int x = fromSpace.getX(); modX == 1 ? x <= toX : x >= toX; x += modX) {
            //for (int y = startY; y <= endY; y++) {
            for (int y = fromSpace.getY(); modY == 1 ? y <= toY : y >= toY; y += modY) {
                if (!playingField[x][y].isCreatePipeValid(fromSpace.getColour()))
                    return;
            }
        }
        // validation OK => create pipe
        //for (int x = startX; x <= endX; x++) {
        for (int x = fromSpace.getX(); modX == 1 ? x <= toX : x >= toX; x += modX) {
            //for (int y = startY; y <= endY; y++) {
            for (int y = fromSpace.getY(); modY == 1 ? y <= toY : y >= toY; y += modY) {
                Space toSpace = playingField[x][y];
                if (toSpace instanceof EmptySpace) {
                    toSpace = new PipePart(x, y, fromSpace.getColour());
                    addPipePart((PipePart) toSpace);
                    connectPipeParts(fromSpace, toSpace);
                }
                fromSpace = toSpace;
            }
        }
        // scan neighbors of last space for possible connections
        if (fromSpace.isLocked)
            return;     // unless target is already locked
        for (int mod = -1; mod <= 1; mod += 2) {
            if (toX + mod >= 0 && toX + mod < size &&
                    scanSpace(fromSpace, playingField[toX + mod][toY]))
                break;
            if (toY + mod >= 0 && toY + mod < size &&
                    scanSpace(fromSpace, playingField[toX][toY + mod]))
                break;
        }
    }

    private boolean scanSpace(Space origin, Space scan) {
        if (scan.getColour() == origin.getColour() &&
                !scan.getIsLocked() &&
                scan != origin) {
            connectPipeParts(origin, scan);
            return true;
        }
        return false;
    }

}
