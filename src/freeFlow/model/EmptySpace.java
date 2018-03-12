package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/14/2018 19:45
 */
public class EmptySpace extends Space {

    public EmptySpace(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public char getConsoleImage() {
        return '.';
    }

    public boolean isCreatePipeValid(Colour colour) {
        return true;
    }

    @Override
    public void setLocked(Space connector) {
        // no implementation
    }

}