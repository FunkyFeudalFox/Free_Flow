package freeFlow.model;

public class PipePart extends Space {

    private boolean isLocked;

    public PipePart(int x, int y, Colour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.isLocked = false;
    }

    public void setLocked() {
        this.isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public char getConsoleImage() {
        return Character.toLowerCase(colour.getConsoleImage());
    }

    public boolean isCreatePipeValid(Colour colour) {
        return this.colour == colour;
    }
}
