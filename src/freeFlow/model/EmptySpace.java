package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/14/2018 19:45
 */
public class EmptySpace extends Space {
    private Colour colour;

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    private boolean isPartOfPipe;

    public void setIsPartOfPipe(boolean partOfPipe) {
        isPartOfPipe = partOfPipe;
    }

    private Pipe pipe;

    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
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