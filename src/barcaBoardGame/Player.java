import java.util.Scanner;

public class Player {

  private String name;
  private int points;

  public Player() {
  }

  public void addName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addPoints() {
    this.points++;
  }

  public int getPoints() {
    return points;
  }

  public void initNewPlayer() {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Player 1 please write your name");
    this.addName(scnr.next());
    scnr.close();
  }
}
