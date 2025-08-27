package barcaBoardGame;

import java.util.Scanner;

import static java.lang.System.exit;

public class BarcaMatch {

    TerminalDisplay terminalDisplay;
    BarcaBoard board;
    Scanner scnr;
    String choice;
    int currentPlayer;
    int turn = 1;


    public BarcaMatch() {
        this.board = new BarcaBoard();
        this.terminalDisplay = new TerminalDisplay();
        this.scnr = new Scanner(System.in);
    }

    //main
    public static void main(String[] args) {
        BarcaMatch match = new BarcaMatch();
        match.startMatch();
    }


    //match stuff
    public void startMatch() {
        terminalDisplay.clearDisplay();
        board.setBoard();

        terminalDisplay.welcome();

        System.out.println("please type '-h' for rules else type 'start' to start game");
        gameRulesOrStart();
        gameLoop();

    }

    private void gameLoop() {
        //game loop
        //current Player is controlled by a simple int

        /*
        loop will run while the board reports that no user has control of 3 watering holes.
        wateringHoleWinner needs to be implemented still (for looping purpouses it currently ALWAYS return false)
         */
        while (board.wateringHoleWinner() == false) {

            terminalDisplay.clearDisplay();
            System.out.println("got here in loop");
            terminalDisplay.render(turn, currentPlayer, board);


            terminalDisplay.printTurnInstructions(currentPlayer);

            String coordinate = scnr.nextLine();
            if (coordinate.equals("exit") || coordinate.equals("quit")) {
                System.out.println("Thanks for playing!");
                exit(0);
            }

            System.out.println(coordinate);

            changePlayer();
            turn++;
        }

        //unsure if needed but will determine if the program exited with no problems
        exit(0);
    }

    private void gameRulesOrStart() {
        do {
            choice = scnr.nextLine();
            if (choice.equals("start")) {
                break;
            } else if (choice.equals("-h")) {
                terminalDisplay.printRules(scnr);
                break;
            } else if (choice.equals("exit") || choice.equals("quit")) {
                exit(0);
            } else {
                System.out.println("Invalid choice, please try again:");
            }
        } while (!choice.equals("start") || !choice.equals("-h"));
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }
}
