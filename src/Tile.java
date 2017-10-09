import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

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
    bounds = new Rectangle(x, y, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
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
        Reference.TILE_HEIGHT, x, y + 25, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
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
}
