package barcaBoardGame;

import java.awt.Point;

public abstract class BarcaPiece {
	public Point coordinate;
	
	public abstract boolean isValidMove(Point from, Point to);
	
	public abstract String toString();
	
	/**
	 * Determines if the move is valid for this piece
	 * @param from the location of the piece intended to move
	 * @param to the location of the destination of moved piece
	 * @return true only if move satisfies the requirement of being within bounds
	 */
	public boolean isWithinBounds(Point from, Point to) {
		// TODO Remove hard-coded constants and base it on size of board array in board object
		final int MAX_HORIZONTAL_SPACES = 10;
		final int MAX_VERTICAL_SPACES = 10;
		final int MIN_SPACES = 1;
		
		// Computes truth value for each axis
		boolean isWithinHorizontalBound = from.x <= MAX_HORIZONTAL_SPACES && from.x >= MIN_SPACES;
		boolean isWithinVerticalBound = from.y <= MAX_VERTICAL_SPACES && from.y >= MIN_SPACES;		
		
		// If both conditions are met, then returns true, otherwise false
		if(isWithinHorizontalBound && isWithinVerticalBound) {
			return true;
		} else {
			return false;
		}
	}
}
