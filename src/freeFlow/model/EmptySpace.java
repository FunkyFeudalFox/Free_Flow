package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/14/2018 19:45
 */
public class EmptySpace extends Space {
    private Colour colour;
    private int x, y;

    private boolean isPartOfPipe;

    private Pipe pipe;

    public void draw() {

    }

    public String drawConsole() {
        if (isPartOfPipe){
            return " " + Character.toLowerCase(this.colour.getImage()) + " ";
        }
        else{
            return " . ";
        }


    }
}