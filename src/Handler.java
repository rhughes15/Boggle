import javafx.scene.input.MouseEvent;

public class Handler
{
  private Controller controller;

  public Handler(Controller controller)
  {
    this.controller = controller;
  }

  public void handleMousePressed(MouseEvent event)
  {

  }

  public void handleMouseDragged(MouseEvent event)
  {

  }

  public void handleMouseReleased(MouseEvent event)
  {

  }

  public void handleMouseMotion(MouseEvent event)
  {
    for(Tile t : controller.getBoard().getTiles()) t.baseState();
    for(Tile t : controller.getBoard().getTiles())
    {
      if(t.contains(event)) t.mouseOver();
    }
  }
}
