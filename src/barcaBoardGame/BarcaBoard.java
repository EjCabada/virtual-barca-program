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
	
	public Point[] findAdjacentSpaces(Point startingPoint) {
		int startingX = startingPoint.x;
		int startingY = startingPoint.y;
		
		Point rightOfStart = new Point(startingX++, startingY);
		Point leftOfStart = new Point(startingX--, startingY);
		Point topOfStart = new Point(startingX, startingY++);
		Point bottomOfStart = new Point(startingX, startingY--);
		
		Point topRightOfStart = new Point(startingX++, startingY--);
		Point topLeftOfStart = new Point(startingX--, startingY--);
		Point bottomRightOfStart = new Point(startingX++, startingY++);
		Point bottomLeftOfStart = new Point(startingX--, startingY++);
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
