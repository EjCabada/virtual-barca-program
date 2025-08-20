package barcaBoardGame;

import java.awt.Point;

public class BarcaBoardSpace extends Point{

    final int MIN_BOARD_LENGTH = 1;
    final int MIN_BOARD_WIDTH = 1;

    final int MAX_BOARD_LENGTH = 10;
    final int MAX_BOARD_WIDTH = 10;

    BarcaPiece occupyingPiece = null;

	public BarcaBoardSpace(int x, int y) {
        boolean xWithinBounds = x >= MIN_BOARD_WIDTH && x <= MAX_BOARD_WIDTH;
        boolean yWithinBounds = y >= MIN_BOARD_LENGTH && y <= MAX_BOARD_LENGTH;
        if(xWithinBounds && yWithinBounds){
		    this.x = x;
            this.y = y;
        } else {
            throw new IndexOutOfBoundsException("You cannot create a space outside the board");
        }
	}

    /**
     * Changes the location of the coordinate relative to starting point
     * @param offsetX Shifts the x value this many places
     * @param offsetY Shifts the y value this many places
     * @return
     */
    public static BarcaBoardSpace offset(BarcaBoardSpace startingPoint, int offsetX, int offsetY){
        return new BarcaBoardSpace(startingPoint.x + offsetX,startingPoint.y + offsetY);
    }

    /**
     * Helper, shifts coordinate up one
     * @return A new coordinate immediately up relative to this space
     */
    public BarcaBoardSpace offsetUp(){
        return BarcaBoardSpace.offset(this,0, 1);
    }

    /**
     * Helper, shifts coordinate down one
     * @return A new coordinate immediately down relative to this space
     */
    public BarcaBoardSpace offsetDown(){
        return BarcaBoardSpace.offset(this,0, -1);
    }

    /**
     * Helper, shifts coordinate right one
     * @return A new coordinate immediately right relative to this space
     */
    public BarcaBoardSpace offsetRight(){
        return BarcaBoardSpace.offset(this,1, 0);
    }

    /**
     * Helper, shifts coordinate left one
     * @return A new coordinate immediately left relative to this space
     */
    public BarcaBoardSpace offsetLeft(){
        return BarcaBoardSpace.offset(this,-1, 0);
    }

    /**
     * Determines all adjacent spaces
     * @return An array of adjacent spaces
     */
    public Point[] findAdjacentSpaces() {
        final int TOTAL_POSSIBLE_ADJACENT = 8;
        Point[] arr = new BarcaBoardSpace[TOTAL_POSSIBLE_ADJACENT];

        arr[0] = this.offsetRight();
        arr[1] = this.offsetLeft();
        arr[2] = this.offsetUp();
        arr[3] = this.offsetDown();

        arr[4] = this.offsetRight().offsetUp();
        arr[5] = this.offsetLeft().offsetUp();
        arr[6] = this.offsetRight().offsetDown();
        arr[7] = this.offsetLeft().offsetDown();

        return arr;
    }
	
	public String toString(){
		if(occupyingPiece == null) {
			return " . ";
		} else {
			return occupyingPiece.toString();
		}
	}

}
