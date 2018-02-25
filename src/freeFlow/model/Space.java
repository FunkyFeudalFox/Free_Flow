package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/19/2018 15:50
 */
public abstract class Space {

    protected int x, y;

    Colour colour;

    boolean isSelected;

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Colour getColour() {
        return colour;
    }

    abstract public char getConsoleImage();

    abstract boolean isCreatePipeValid(Colour colour);

}
