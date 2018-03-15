package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/10/2018 16:46
 */
public class Game {

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

    public Level getLevel() {
        return level;
    }

    private boolean isSolved;

    public boolean getIsSolved(){ return isSolved; }



    private boolean exit;

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean getExit() {
        return exit;
    }

    //Hier moet t.z.t. eigenlijk iets zoals this.level.getSize();, maar voor nu
    //de columns hardcoded omdat het programma anders een null-pointer exception
    //gaf bij het aanmaken van een nieuw Game model
    public int COLUMNS = 5;

    public int getCOLUMNS() {
        return COLUMNS;
    }

    //Zie opmerking hierboven. Hier geldt hetzelfde.
    public int ROWS = 5;

    public int getROWS() {
        return ROWS;
    }

    //private GameSaver gameSaver;




    public Game(int moveNumber, Player player, Level level) {
        this.moveNumber = moveNumber;
        this.player = player;
        this.level = level;
        this.isSolved = false;
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

    public void makeMove(){
        //TODO
        if (isLegalMove()){
            moveNumber++;

        }
    }

    public boolean isLegalMove(){
        //TODO
        return false;
    }

    public void undoMove(){
        //TODO
    }

    public boolean checkWinConditions(){
        // mss beter een list van dots bijhouden in level?
        for (int x = 0; x < level.getSize(); x++) {
            for (int y = 0; y < level.getSize(); y++) {
                if (level.getPlayingField()[x][y] instanceof Dot &&
                        !((Dot) level.getPlayingField()[x][y]).isLocked())
                    return false;
            }
        }
        return true;
    }





}
