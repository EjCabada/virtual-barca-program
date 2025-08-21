package barcaBoardGame;
import java.awt.Point;

public class BarcaBoard {
	public static BarcaBoardSpace[][] board = new BarcaBoardSpace[10][10];
	
	public BarcaBoard() {
		setBoard();
	}
	
	/**
	 * Helper method to set the board to initial state
	 */
	public void setBoard() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				board[i][j] = new BarcaBoardSpace(new Point(i,j), false);
			}
		}
		board[0][0].setOccupyingPiece(new MousePiece());
		// Test move validation
		// board[0][0].getOccupyingPiece().isValidMove(new Point(0,0), new Point(0,9));
	}

    /**
     * Prints the state of the game as a grid in the terminal
     */
    public void print() {
        System.out.println(this);
    }

	/**
	 * Printing the board object will implicitly call this method
	 */
    @Override
	public String toString() {
		String string = "";
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				string = string + (board[i][j]);
			}
			string = string + "\n";
		}	
		return string;
	}
	

}
