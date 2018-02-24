package freeFlow.model;

import freeFlow.view.GraphicGameView;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:31
 */
public class Dot extends Space {

    private Colour colour;
    private boolean isLocked;

    public Colour getColour() {
        return colour;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    Dot(int x, int y, Colour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.isLocked = false;
    }


    public String drawConsole() {
        StringBuilder sb = new StringBuilder();
        sb.append(isSelected ? '[' : ' ');
        sb.append(this.colour.getImage());
        sb.append(isSelected ? ']' : ' ');
        return sb.toString();
    }

}
