package barcaBoardGame;

import java.awt.*;

public class LionPiece extends BarcaPiece {

	public LionPiece() {
		name = super.LION;
        fearFactor = super.ELEPHANT;
	}
	
	@Override
	protected boolean isValidMovePattern(Point from, Point to) {
		//TODO Implement validation method to move diagonally
        return false;
	}
	
	@Override
	public String toString() {
		// Temporary symbol: used king to represent mouse
		return " \u265d ";
	}

}
