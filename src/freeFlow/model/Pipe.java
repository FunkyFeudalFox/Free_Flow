package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:50
 */
public class Pipe {
    private Colour colour;

    public Colour getColour() {
        return colour;
    }

    private boolean isSelected;

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    private boolean isLocked = false;

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean locked) {
        isLocked = locked;
    }

    private int x, y;

    private Dot dot1;

    private Dot dot2;

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public Pipe(Colour colour, boolean isSelected, Dot dot1) {
        this.colour = colour;
        this.isSelected = isSelected;
        this.dot1 = dot1;
    }
}
