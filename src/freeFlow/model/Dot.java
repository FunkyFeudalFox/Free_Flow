package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:31
 */
public class Dot extends Space {

    Space connection;

    Dot(int x, int y, Colour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.isLocked = false;
    }

    public char getConsoleImage() {
        return colour.getConsoleImage();
    }

    public boolean isCreatePipeValid(Colour colour) {
        return !isLocked && this.colour == colour;
    }

    @Override
    public void setLocked(Space connector) {
        this.isLocked = true;
        this.connection = connector;
    }
}
