package freeFlow.view;

import java.util.Scanner;

public class ConsoleMenuView {

    public static final char OPTION_NEW_GAME = '1';
    public static final char OPTION_END_GAME = '9';

    public void drawMainMenu() {
        System.out.println("Welkom bij Free Flow");
        System.out.println("====================");
        System.out.println(OPTION_NEW_GAME + ". Nieuw spel");
        System.out.println();
        System.out.println(OPTION_END_GAME + ". Afsluiten");
    }

    String chooseOption() {
        System.out.println("Voer een keuze in: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
