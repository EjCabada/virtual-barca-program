package barcaBoardGame;

import java.awt.Point;

public class MousePiece extends BarcaPiece {
	
	private String fearFactor = "lion";
	
	public MousePiece(String givenName) {
		this.name = givenName;
	}
	
	/**
	 * Test if piece is afraid of other piece
	 * @param possibleThreat an adjacent piece that may pose a threat to your piece
	 * @return The answer to the question, is this piece afraid of possibleThreat
	 */
	public boolean isAfraidOf(BarcaPiece possibleThreat) {
		if(possibleThreat.getName() == fearFactor) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	/**
	 * Answers the question of whether a move is valid according to the unique moving pattern of this piece
	 * @param from the location of the piece intended to be moved
	 * @param to the location of the space piece is intended to move to 
	 */
	protected boolean isValidMovePattern(Point from, Point to) {
		boolean sameColumn = to.x == from.x;
		boolean sameRow = to.y == from.y;
		
		// Return true if has either the same column or same row but not both ('^' is the XOR operator)
		if(sameColumn ^ sameRow) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		// Temporary symbol: used king to represent mouse
		return " \u2654 ";
	}

}
