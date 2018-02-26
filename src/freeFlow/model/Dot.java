package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:31
 */
public class Dot extends Space {

    private boolean isLocked;

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

    public void setLocked() {
        this.isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

}
