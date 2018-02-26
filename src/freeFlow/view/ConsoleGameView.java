package freeFlow.view;

import freeFlow.model.Space;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class ConsoleGameView {
    String inputUserName() {
        System.out.println("Voer uw naam in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
