package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/19/2018 15:50
 */
public abstract class Space {

    int x, y;
    boolean isSelected;


    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getSelected() {
        return isSelected;
    }

}
