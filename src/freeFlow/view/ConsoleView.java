package freeFlow.view;



import java.util.Scanner;

public class ConsoleView {

    String inputUserName() {
        System.out.println("Voer uw naam in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /*
    void drawGrid(Drawable[][] playingField) {
        //System.out.println("Speler" )
        for (int x = 0; x < playingField.length; x++) {
            for (int y = 0; y < playingField.length; y++) {
                System.out.print(playingField[x][y].drawConsole());
            }
            System.out.println();
        }
    }
    */

    String inputGridLocation() {
        System.out.println("Voer een locatie in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
