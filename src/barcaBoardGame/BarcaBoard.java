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
	}
	
	public void printBoard() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}	
	}
	

}
