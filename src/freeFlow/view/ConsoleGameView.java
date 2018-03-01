package freeFlow.view;

import java.util.Scanner;

public class ConsoleGameView {
    String inputUserName() {
        System.out.println("Voer uw naam in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    void drawTopGrid(int size) {
        System.out.print(' ');
        for (int x = 1; x <= size; x++) {
            System.out.print(' ' + Integer.toString(x));
        }
        System.out.println();
    }

    void drawPart(char part) {
        System.out.print(part);
    }

    void drawEndOfLine(boolean isSelected) {
        drawSeparator(false, isSelected);
        System.out.println();
    }

    void drawSeparator(boolean isSelected, boolean isSelected2) {
        System.out.print(isSelected ? '[' : isSelected2 ? ']' : ' ');
    }

    void drawVictory(){
        System.out.println("Proficiat! Je hebt gewonnen.");
    }

    String inputGridLocation() {
        System.out.println("Voer een locatie in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
