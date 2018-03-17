package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/19/2018 15:50
 */
public abstract class Space {

    protected int x, y;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    Colour colour;

    public Colour getColour() {
        return colour;
    }
    boolean isSelected;


    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    boolean isLocked;

    public boolean getIsLocked() {
        return isLocked;
    }
    abstract public void setLocked(Space connector);

    abstract public char getConsoleImage();

    abstract boolean isCreatePipeValid(Colour colour);

}
