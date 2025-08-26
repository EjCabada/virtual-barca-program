package barcaBoardGame;

import java.util.Scanner;

public class Display {
    public Display() {
    }

    public static void render(int turn, int player, BarcaBoard board) {
        System.out.println("Player " + player + "              turn: " + turn);
        System.out.println("█████████████████████████████");
        System.out.println();
        board.printBoard();
        System.out.println();
        System.out.println("█████████████████████████████");
        System.out.println();
    }

    public static void clearDisplay() {
        /*
        WARNING DOES NOT WORK INSIDE INTELIJ TERMINAL
        IntelliJ does not use a real terminal, as such, terminal commands such as
        clearing the screen does not work.
         */
        System.out.print("\033[2J\033[1;1H");
        System.out.flush();
    }

    public static void welcome() {
        System.out.println("█████████████████████████████");
        System.out.println("      WELCOME TO BARCA!      ");
        System.out.println("█████████████████████████████");
        System.out.println();
    }

    public static void printRules(Scanner scnr) {
        clearDisplay();
        System.out.println("             Rules:           ");
        System.out.println("█████████████████████████████\n");

        //FIXME
        System.out.println("FIXME: rules go here\n");
        System.out.println("When you input a coordinate please follow the following format:");
        System.out.println("\"x , y\", in otherwords 'x' <space> <comma> <space> 'y'");
        System.out.println("At any time, type 'exit' or 'quit' to end the game");
        System.out.println("Have fun! ;)\n");

        String choice = "";
        do {
            System.out.println("Please type 'start' once you're done reading the rules");
            choice = scnr.nextLine();

        } while (!choice.equals("start"));
    }

    public static void printTurnInstructions(int currentPlayer) {
        System.out.println("Player " + currentPlayer + "'s turn");
        System.out.println("Please select a game piece to move via coordinate");
    }
}