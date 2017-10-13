import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

//***********************************
// Ryan Hughes
//
// This class represents the tiles on the board. It
// holds two sprite sheets and when it is initialized it
// calculates and stores the coordinates of the image of
// the character it is passed. When it is called to display
// itself, it does so at the given x and y with a few modifications
// based on its TileState. It holds a rectangle to detect
// whether MouseEvents are close enough to the letter to be
// considered touching.
//***********************************

public class Tile
{
  private TileState state;
  private Image green, yellow;
  private Rectangle bounds;
  private GraphicsContext gc;
  private char character;
  private int x, y, sx, sy;


  public Tile(GraphicsContext gc, char character, int x, int y)
  {
    this.gc = gc;
    this.character = character;
    this.x = x;
    this.y = y;
    state = TileState.Basic;
    bounds = new Rectangle(x + Reference.TILE_DETECTION_BUFFER,
      y + Reference.TILE_DETECTION_BUFFER, Reference.TILE_WIDTH -
      (Reference.TILE_DETECTION_BUFFER * 2), Reference.TILE_HEIGHT -
      (Reference.TILE_DETECTION_BUFFER * 2));
    green = new Image(Reference.GREEN_SHEET);
    yellow = new Image(Reference.YELLOW_SHEET);
    sx = (((int)character - 65) % 6) * Reference.TILE_WIDTH;
    sy = (((int)character - 65) / 6) * Reference.TILE_HEIGHT;
  }

  public void display()
  {
    if(state == TileState.Basic)
    {
      gc.drawImage(green, sx, sy, Reference.TILE_WIDTH,
        Reference.TILE_HEIGHT, x, y, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
    }
    else if (state == TileState.MouseOver)
    {
      gc.drawImage(green, sx, sy, Reference.TILE_WIDTH,
        Reference.TILE_HEIGHT, x, y - 5, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
    }
    else if(state == TileState.Selected)
    {
      gc.drawImage(yellow, sx, sy, Reference.TILE_WIDTH,
        Reference.TILE_HEIGHT, x, y, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
    }
  }

  public boolean contains(MouseEvent event)
  {
    if(bounds.intersects(event.getSceneX(), event.getSceneY(), 1, 1))
      return true;
    return false;
  }

  public void baseState() {state = TileState.Basic;}
  public void mouseOver() {state = TileState.MouseOver;}
  public void clicked() {state = TileState.Selected;}

  public char getChar() {return character;}

  public boolean isCurrentlyClicked()
  {
    return state == TileState.Selected;
  }
}
