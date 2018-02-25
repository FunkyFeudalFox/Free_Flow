package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:34
 */
public enum Colour {


    RED('R'), GREEN('G'), YELLOW('Y'), BLUE('B'), ORANGE('O'), PINK('P'), CYAN('C'), DARKBROWN('D'), LILAC('L');

    Colour(char consoleImage) {
        this.consoleImage = consoleImage;
    }

    private char consoleImage;

    public char getConsoleImage() {
        return consoleImage;
    }

}
