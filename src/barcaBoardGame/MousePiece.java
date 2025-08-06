package barcaBoardGame;

public class MousePiece extends BarcaPiece {
	public MousePiece() {
	}
	
	@Override
	public boolean isValidMove() {
		return true;
	}
	@Override
	public String toString() {
		// Temporary symbol: used king to represent mouse
		return " \u2654 ";
	}
}
