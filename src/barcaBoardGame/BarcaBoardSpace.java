package barcaBoardGame;

import java.awt.Point;

public class BarcaBoardSpace {
	private Point coordinate;
	private BarcaPiece occupyingPiece = null;
	private boolean isWateringHole;
	
	public BarcaBoardSpace(Point coordinate, boolean isWateringHole) {
		this.coordinate = coordinate;
		this.isWateringHole = isWateringHole;
	}
	
	public void setOccupyingPiece(BarcaPiece piece) {
		occupyingPiece = piece;
	}
	
	public BarcaPiece getOccupyingPiece() {
		return occupyingPiece;
	}
	
	public String toString(){
		if(occupyingPiece == null) {
			return " . ";
		} else {
			return occupyingPiece.toString();
		}
	}

}
