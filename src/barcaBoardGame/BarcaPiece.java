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
		boolean validX = from.x <= 10 && from.x >= 1;
		boolean validY = from.y <= 10 && from.y >= 1;		
		if(validX && validY) {
			return true;
		} else {
			return false;
		}
	}
}
