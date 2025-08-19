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
		//TODO If movement is not valid, catch the exception using try catch block and ask for input again
		movePiece(new Point(0,0), new Point(0,10));
	}
	
	/**
	 * Changes board state by removing piece from one space and adding it to another space
	 * @param from location of space containing piece intended to be moved
	 * @param to location of space that piece is intended to be moved to
	 */
	public void movePiece(Point from, Point to) {
		BarcaBoardSpace fromBoardSpace = board[from.x][from.y];
		BarcaBoardSpace toBoardSpace = board[to.x][to.y];
		
		BarcaPiece pieceToMove = fromBoardSpace.getOccupyingPiece();
		if(	pieceToMove.isValidMovement(from, to)) {
			fromBoardSpace.setOccupyingPiece(null);
			toBoardSpace.setOccupyingPiece(pieceToMove);
		} else {
			System.out.println("Move was not valid!");
		};
		
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
		
		return new Point[8];
	}
	
/**
 * Printing the board object will implicitly call this method
 */	
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
