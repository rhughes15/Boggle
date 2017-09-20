public class Controller
{
  private Dictionary dict;
  private Player player;

  public Controller()
  {
    dict = new Dictionary();
    player = new Player();
  }

  public void run()
  {
    String choice = player.takeTurn();
    while(!(choice.equalsIgnoreCase("q")))
    {
      if(dict.contains(choice)) System.out.println(choice + " is in the dictionary");
      else System.out.println(choice + " is NOT in the dictionary");
      choice = player.takeTurn();
    }
  }
}
