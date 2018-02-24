package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:50
 */
public class Pipe {
    private Colour colour;
    private boolean isSelected;

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    private int x, y;

    private Dot dot1;

    private Dot dot2;

    public Pipe(Colour colour, boolean isSelected, Dot dot1) {
        this.colour = colour;
        this.isSelected = isSelected;
        this.dot1 = dot1;
    }
}
