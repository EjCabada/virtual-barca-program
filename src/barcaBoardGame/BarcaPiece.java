package barcaBoardGame;

import java.awt.Point;

public abstract class BarcaPiece {
	public Point coordinate;

    protected char fearFactor;
	protected char name;

    protected final char MOUSE = 'M';
    protected final char LION = 'L';
    protected final char ELEPHANT = 'E';


	public char getName() {
		return name;
	}
	
	/**
	 * Helper method that that provides one 
	 * @param from the location of piece to be moved
	 * @param to the location of space for piece to move to
	 * @return true only if the movement is valid
	 */
	public boolean isValidMovement(Point from, Point to) {
		if(	isValidMovePattern(from, to) && 
			isWithinBounds(from, to)) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract String toString();

    /**
     * Answers the question of whether a move is valid according to the unique moving pattern of this piece
     * @param from the location of the piece intended to be moved
     * @param to the location of the space piece is intended to move to
     */
	protected abstract boolean isValidMovePattern(Point from, Point to);

	/**
	 * Determines if the move is valid for this piece
	 * @param from the location of the piece intended to move
	 * @param to the location of the destination of moved piece
	 * @return true only if move satisfies the requirement of being within bounds
	 */
	protected boolean isWithinBounds(Point from, Point to) {
		// TODO Remove hard-coded constants and base it on size of board array in board object
		final int MAX_HORIZONTAL_SPACES = 9;
		final int MAX_VERTICAL_SPACES = 9;
		final int MIN_SPACES = 0;
		
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
}
