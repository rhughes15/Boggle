import javafx.scene.input.MouseEvent;

//***********************************
// Ryan Hughes
//
// This is the main event handling class for the program.
// All objects are painted on a canvas and the canvas has
// a series of small event listeners that point various
// actions to this class and send it the event. This
// class has access to the controller so it can alert
// the controller to certain actions.
//***********************************

public class Handler
{
  private Controller controller;

  public Handler(Controller controller)
  {
    this.controller = controller;
  }

  public void handleMousePressed(MouseEvent event)
  {
    for(Tile t : controller.getBoard().getTiles())
    {
      if(t.contains(event))
      {
        t.clicked();
        controller.addCharToWord(t.getChar());
      }
    }
    controller.display();
  }

  public void handleMouseDragged(MouseEvent event)
  {
    for(Tile t : controller.getBoard().getTiles())
    {
      if(t.contains(event))
      {
        if(!t.isCurrentlyClicked())
        {
          t.clicked();
          controller.addCharToWord(t.getChar());
        }
      }
    }
    controller.display();
  }

  public void handleMouseReleased(MouseEvent event)
  {
    controller.handleMouseReleased();
    for(Tile t : controller.getBoard().getTiles())
    {
      t.baseState();
    }
    controller.display();
  }

  public void handleMouseMotion(MouseEvent event)
  {
    for(Tile t : controller.getBoard().getTiles()) t.baseState();
    for(Tile t : controller.getBoard().getTiles())
    {
      if(t.contains(event)) t.mouseOver();
    }
    controller.display();
  }
}
