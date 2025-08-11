package barcaBoardGame;

public class BarcaMatch {

	public static void main(String[] args) {
		BarcaBoard board = new BarcaBoard();
		board.setBoard();
		board.printBoard();
		Player player1 = new Player();
		player1.initNewPlayer();
		Player player2 = new Player();
		player2.initNewPlayer();
		System.out.println("Player 1 is " + player1.getName());
		System.out.println("Player 2 is " + player2.getName());

	}

	public void welcomePlayers() {
		System.out.println("**************************************");
		System.out.println(" ▖  ▖  ▜            ▗     ▄         ▌");
		System.out.println(" ▌▞▖▌█▌▐ ▛▘▛▌▛▛▌█▌  ▜▘▛▌  ▙▘▀▌▛▘▛▘▀▌▌");
		System.out.println(" ▛ ▝▌▙▖▐▖▙▖▙▌▌▌▌▙▖  ▐▖▙▌  ▙▘█▌▌ ▙▖█▌▖");
		System.out.println("**************************************");
	}

}
