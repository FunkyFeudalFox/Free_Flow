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
    }

    protected String displayLevelSize(){
        return String.format("Level %d %dx%d", levelNumber, size, size);
    }

    public void addDot(Dot dot) {
        this.playingField[dot.x][dot.y] = dot;
    }

    public void addPipe(Pipe pipe) {this.pipes.add(pipe); }



    public Space [][] getPlayingField() {
        return playingField;
    }

    public Space getDrawable(int x, int y) {
        return playingField[x][y];
    }

}
