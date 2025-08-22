package barcaBoardGame;

import java.util.Scanner;
import java.awt.Point;

import static java.lang.System.exit;

public class BarcaMatch {

    public static void main(String[] args) {

        BarcaBoard board = new BarcaBoard();
        board.setBoard();

        //welcome banner
        System.out.println("**************************");
        System.out.println("    WELCOME TO BARCA!    ");
        System.out.println("**************************");
        System.out.println();

        //added a start point to branch off to rules or to the gameloop depending on user familiarity of the game
        System.out.println("please type '-h' for rules else type 'start' to start game");
        Scanner scnr = new Scanner(System.in);
        String choice;


        //loop to get user input and branch to the help screen or to the gameLoop
        /*
            do-while loop will ensure that the user will at least go through the loop once.
            The user will be prometed to re-enter something if their choice is not 'start' or '-h' for help.

         */
        //consider factoring out into a separate function to keep the main function clean
        do {
            choice = scnr.nextLine();
            if (choice.equals("start")) {
                gameLoop(board);
            } else if (choice.equals("-h")) {
                gameRules();
                gameLoop(board);
            } else {
                System.out.println("Invalid choice, please try again:");
            }
        } while (!choice.equals("start") || choice.equals("-h"));
    }

    //game loop
    private static void gameLoop(BarcaBoard board) {
        System.out.println("**************************");
        System.out.println("          New Game!       ");
        System.out.println("**************************");

        //current Player is controlled by a simple int
        int currentPlayer = 1;
        Scanner scnr = new Scanner(System.in);

        /*
        loop will run while the board reports that no user has control of 3 watering holes.
        wateringHoleWinner needs to be implemented still (for looping purpouses it currently ALWAYS return false)
         */
        while (board.wateringHoleWinner() == false) {
            board.printBoard();

            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.println("Please select a game piece to move via coordinate");
            String coordinate = scnr.nextLine();
            System.out.println(coordinate);
            System.out.println(coordinate);

            //for readablilty purpouses player is controlled by turnery-op
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        //unsure if needed but will determine if the program exited with no problems
        exit(0);
    }

    private static void gameRules() {
        System.out.println();
        System.out.println("**************************");
        System.out.println("           Rules:         ");
        System.out.println("**************************");
        //FIXME
        System.out.println("FIXME: rules go here");
        System.out.println("When you input a coordinate please follow the following format:");
        System.out.println("\"x , y\", in otherwords 'x' <space> <comma> <space> 'y'");
        System.out.println("Have fun! ;)");
    }

}
