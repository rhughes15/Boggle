import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

//***********************************
// Ryan Hughes
//
// This is the main game coordinator. It has access
// to all of the main components of the game and controls the
// flow of information between them as well as the overall
// order of events as the game progresses. When it is first
// initialized, it creates all of the necessary objects and
// displays a 4x4 board.
//***********************************

public class Controller
{
  private Dictionary dict;
  private Player player;
  private Board board;
  private Canvas canvas;
  private Handler handler;
  private String currentWord;
  private Timer timer;
  private boolean gameOn;

  public Controller(Canvas canvas)
  {
    init(canvas);
  }

  private void init(Canvas canvas)
  {
    gameOn = false;
    currentWord = "";
    dict = new Dictionary();
    this.canvas = canvas;
    player = new Player(canvas.getGraphicsContext2D());
    board = new Board(4, canvas.getGraphicsContext2D());
    handler = new Handler(this);
    timer = new Timer(canvas.getGraphicsContext2D(), this);
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

  public void display()
  {
    board.displayBoard();
    player.display();
    timer.display();
  }

  public void startGame()
  {
    player.resetScore();
    timer.start();
    gameOn = true;
  }

  public void stopGame()
  {
    timer.stop();
    gameOn = false;
    int size = board.getSize();
    board = new Board(size, canvas.getGraphicsContext2D());
  }

  public void handleMouseReleased()
  {
    if(dict.contains(currentWord) && gameOn)
    {
      player.addGoodWord(currentWord);
      player.score(currentWord.length() * 10);
    }
    else if(gameOn)
    {
      player.addBadWord(currentWord);
    }
    currentWord = "";
  }

  public void changeBoardSize()
  {
    if(board.getSize() == 4) board = new Board(5, canvas.getGraphicsContext2D());
    else board = new Board(4, canvas.getGraphicsContext2D());
    board.displayBoard();
  }

  public void addCharToWord(char c)
  {
    currentWord += c;
  }

  public Board getBoard() { return board; }
  public boolean gameOn() {return gameOn;}
}
