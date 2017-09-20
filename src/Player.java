import java.util.Scanner;

public class Player
{
  private Scanner in;

  public Player()
  {
    in = new Scanner(System.in);
  }

  public String takeTurn()
  {
    System.out.print("Please enter a word to see if it is in the dictionary or q to quit: ");
    System.out.println();
    String choice = in.next();
    return choice;
  }
}
