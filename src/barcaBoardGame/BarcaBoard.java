package barcaBoardGame;
import java.awt.Point;
import java.util.ArrayList;

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
                // TODO Find a way to index the array starting at 1 instead of 0;
				board[i][j] = new BarcaBoardSpace(new Point(i,j), false);
			}
		}
		board[4][4].setOccupyingPiece(new MousePiece());
		board[4][5].setOccupyingPiece(new LionPiece());
		//TODO If movement is not valid, catch the exception using try catch block and ask for input again
//		movePiece(new Point(0,0), new Point(0,9));
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
	
	//TODO resolve duplicate definition of method isWithinBounds()
	/**
	 * Determines if the move is valid for this piece
	 * @param to the location of the destination of moved piece
	 * @return true only if move satisfies the requirement of being within bounds
	 */
	protected boolean isWithinBounds(Point to) {
		// TODO Remove hard-coded constants and base it on size of board array in board object
		final int MAX_HORIZONTAL_SPACES = 9;
		final int MAX_VERTICAL_SPACES = 9;
		final int MIN_SPACES = 0;
		
		// Computes truth value for each axis
		boolean isWithinHorizontalBound = to.x <= MAX_HORIZONTAL_SPACES && to.x >= MIN_SPACES;
		boolean isWithinVerticalBound = to.y <= MAX_VERTICAL_SPACES && to.y >= MIN_SPACES;		
		
		// If both conditions are met, then returns true, otherwise false
		if(isWithinHorizontalBound && isWithinVerticalBound) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Point> findAdjacentSpaces(Point startingPoint) {
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
				
		final int TOTAL_POSSIBLE_ADJACENT = 8;
		Point[] arr = new Point[TOTAL_POSSIBLE_ADJACENT];
		
		arr[0] = rightOfStart;
		arr[1] = leftOfStart;
		arr[2] = topOfStart;
		arr[3] = bottomOfStart;
		arr[4] = topRightOfStart;
		arr[5] = topLeftOfStart;
		arr[6] = bottomRightOfStart;
		arr[7] = bottomLeftOfStart;
		
		ArrayList<Point> allPossibleAdjacentSpaces = new ArrayList<Point>();
		
		for(int i = 0; i < TOTAL_POSSIBLE_ADJACENT;  i++) {
			if(isWithinBounds(arr[i])) {
				allPossibleAdjacentSpaces.add(arr[i]);
			};
		}
		
		return allPossibleAdjacentSpaces;
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
