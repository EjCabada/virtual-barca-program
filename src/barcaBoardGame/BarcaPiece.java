package barcaBoardGame;

import java.awt.Point;

public abstract class BarcaPiece {
	public Point coordinate;
	
	public abstract boolean isValidMove(Point from, Point to);
	
	public abstract String toString();
}
