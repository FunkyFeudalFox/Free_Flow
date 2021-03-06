package freeFlow.model;

import java.util.Collections;
import java.util.List;

/**
 * @author Arjan Tammer
 * @version 1.0 2/10/2018 16:46
 */
public class Game {

    private static final int MAX_HIGHSCORE_COUNT = 5;

    private int moveNumber;

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    private Player player;

    public void setUserName(String name) {
        player.setName(name);
    }

    public Player getPlayer() {
        return player;
    }

    private Level level;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getLevel() {
        return level;
    }

    private boolean isSolved;

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean getIsSolved(){ return isSolved; }



    private boolean exit;

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean getExit() {
        return exit;
    }


    public int getColumns() {
        return level.getSize();
    }

    public int getRows() {
        return level.getSize();
    }

    //private GameSaver gameSaver;



    public Game(int moveNumber, Player player, Level level) {
        this.moveNumber = moveNumber;
        this.player = player;
        this.level = level;
        this.isSolved = false;
    }

    public Game(int moveNumber, boolean isSolved, boolean exit){
        this.moveNumber = moveNumber;
        this.isSolved = isSolved;
        this.exit = exit;
    }

    public void startGame(){
        // create a test setup
        level.addDot(new Dot(4,0, Colour.RED));
        level.addDot(new Dot(3,2, Colour.RED));
        level.addDot(new Dot(2,2, Colour.GREEN));
        level.addDot(new Dot(3,1, Colour.GREEN));
        level.addDot(new Dot (0,0, Colour.YELLOW));
        level.addDot(new Dot(3,4, Colour.YELLOW));
        level.addDot(new Dot(3,0, Colour.BLUE));
        level.addDot(new Dot(4,4, Colour.BLUE));

    }

    public void makeMove(Space selected, int x, int y) {

        if (isLegalMove(selected, x, y)) {
            moveNumber++;
            level.createPipe(selected, x, y);
        }
    }

    public boolean isLegalMove(Space selected, int x, int y) {
        return level.validateCreatePipe(selected, x, y);
    }

    public void undoMove(){
        //TODO
    }

    public boolean checkWinConditions(){
        // mss beter een list van dots bijhouden in level?
        for (int x = 0; x < level.getSize(); x++) {
            for (int y = 0; y < level.getSize(); y++) {
                if (level.getPlayingField()[x][y] instanceof Dot &&
                        !((Dot) level.getPlayingField()[x][y]).getIsLocked())
                    return false;
            }
        }
        return true;
    }

    public void addHighScore(Score score) {
        List<Score> highScores = level.getHighScores();
        highScores.add(score);
        Collections.sort(highScores);
        if (highScores.size() > MAX_HIGHSCORE_COUNT)
            highScores.remove(MAX_HIGHSCORE_COUNT - 1);
        level.setHighScores(highScores);
        level.writeHighScores(highScores);
    }



}
