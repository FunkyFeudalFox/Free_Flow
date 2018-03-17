package freeFlow.model;

import javafx.scene.paint.Color;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:34
 */
public enum Colour {


    RED('R', Color.RED),
    GREEN('G', Color.GREEN),
    YELLOW('Y', Color.YELLOW),
    BLUE('B', Color.BLUE),
    ORANGE('O', Color.ORANGE),
    PINK('P', Color.PINK),
    CYAN('C', Color.CYAN),
    DARKBROWN('D', Color.BROWN),
    LILAC('L', Color.MEDIUMPURPLE);

    private Color colour;

    private char consoleImage;

    Colour(char consoleImage, Color colour) {
        this.consoleImage = consoleImage;
        this.colour = colour;
    }

    public char getConsoleImage() {
        return consoleImage;
    }

    public Color getColour() {
        return colour;
    }

    public static Colour getColourFromChar(char consoleImage) {
        for (Colour c : values()) {
            if (c.consoleImage == consoleImage)
                return c;
        }
        return null;
    }

}
