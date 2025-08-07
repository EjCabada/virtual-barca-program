package barcaBoardGame;

import java.awt.Point;

public class MousePiece extends BarcaPiece {
	
	public MousePiece() {
	}
	
	@Override
	public boolean isValidMove(Point from, Point to) {
		if(to.x == from.x || to.y == from.y) {
			System.out.println("Valid move!");
			return true;
		} else {
			System.out.println("Not a valid move!");
			return false;
		}
	}
	
	@Override
	public String toString() {
		// Temporary symbol: used king to represent mouse
		return " \u2654 ";
	}
}
