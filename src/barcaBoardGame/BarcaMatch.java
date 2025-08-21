package barcaBoardGame;

public class BarcaMatch {

	public static void main(String[] args) {
		BarcaBoard board = BarcaBoard.getInstance();
        board.setBoard();
		System.out.println(board);
	}

}
