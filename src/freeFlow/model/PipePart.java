package freeFlow.model;

public class PipePart extends Space {

    public PipePart(int x, int y, Colour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public char getConsoleImage() {
        return Character.toLowerCase(colour.getConsoleImage());
    }

    public boolean isCreatePipeValid(Colour colour) {
        return this.colour == colour;
    }
}
