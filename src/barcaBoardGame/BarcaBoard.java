package barcaBoardGame;

import java.awt.Point;

public class BarcaBoard {
	public static BarcaBoardSpace[][] board = new BarcaBoardSpace[10][10];
	
	public BarcaBoard() {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				board[i][j] = new BarcaBoardSpace(new Point(i,j), false);
			}
		}	
	}
	
	public void setBoard() {
		board[0][0].setOccupyingPiece(new MousePiece());
		// Test move validation
		// board[0][0].getOccupyingPiece().isValidMove(new Point(0,0), new Point(0,9));
	}
	
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
