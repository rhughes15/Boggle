import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Controller
{
  private Dictionary dict;
  private Player player;
  private Board board;
  private Canvas canvas;
  private Handler handler;

  public Controller(Canvas canvas)
  {
    init(canvas);
  }

  private void init(Canvas canvas)
  {
    dict = new Dictionary();
    this.canvas = canvas;
    player = new Player();
    board = new Board(4, canvas.getGraphicsContext2D());
    handler = new Handler(this);
    this.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        handler.handleMousePressed(event);
      }
    });
    this.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        handler.handleMouseDragged(event);
      }
    });
    this.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        handler.handleMouseReleased(event);
      }
    });
    this.canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) { handler.handleMouseMotion(event); }
    });
  }

  public void run()
  {
    String choice = player.takeTurn();
    while(!(choice.equalsIgnoreCase("q")))
    {
      board.displayBoard();
      if(dict.contains(choice)) System.out.println(choice + " is in the dictionary");
      else System.out.println(choice + " is NOT in the dictionary");
      choice = player.takeTurn();
    }
  }

  public void displayBoard() {board.displayBoard();}

  public void handleButtonPress(String text)
  {
    if(dict.contains(text)) System.out.print("word is in the dictionary ");
    else System.out.print("word is NOT in the dictionary ");

    if(board.contains(text)) System.out.println("word is on the board");
    else System.out.println("word is NOT on the board");
  }

  public Board getBoard() { return board; }
}
