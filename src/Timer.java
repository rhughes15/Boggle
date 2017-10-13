import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

//***********************************
// Ryan Hughes
//
// This class represents the timer. It holds an
// animation timer that acts to update the time and
// calls the display function.
//***********************************

public class Timer
{
  private AnimationTimer timer;
  private GraphicsContext gc;
  private long currentRelativeTime, previousTime, currentSeconds, currentMinutes;

  public Timer(GraphicsContext gc, Controller controller)
  {
    this.gc = gc;
    currentRelativeTime = previousTime =
      currentSeconds = currentMinutes =  0;
    timer = new AnimationTimer() {
      @Override
      public void handle(long now)
      {
        if(previousTime == 0)
        {
          previousTime = now;
          currentRelativeTime = 0;
        }
        else
        {
          currentRelativeTime += now - previousTime;
          previousTime = now;
          if(currentRelativeTime / 1000000000 > 0)
          {
            currentSeconds++;
            currentRelativeTime = 0;
            if(currentSeconds / 60 > 0)
            {
              currentMinutes++;
              currentSeconds = 0;
            }
            display();
          }
        }
        if(currentMinutes >= Reference.GAME_TIME)
        {
          timer.stop();
          currentRelativeTime = previousTime =
            currentSeconds = currentMinutes =  0;
          controller.stopGame();
        }
      }
    };
  }

  public void start()
  {
    currentSeconds = currentMinutes = 0;
    timer.start();
  }

  public void stop()
  {
    timer.stop();
    display();
  }

  public void display()
  {
    gc.setFill(Reference.BACKGROUND_COLOR);
    gc.fillRect(Reference.TIMER_X, Reference.TIMER_Y - Reference.TIMER_HEIGHT,
      Reference.TIMER_WIDTH, Reference.TIMER_HEIGHT);
    gc.setStroke(Reference.TILE_GREEN);
    gc.setFont(Font.font("Consolas", 36));
    if(currentSeconds < 10)
    {
      gc.strokeText("Time: " + currentMinutes + ":0" + currentSeconds, Reference.TIMER_X, Reference.TIMER_Y);
    }
    else
    {
      gc.strokeText("Time: " + currentMinutes + ":" + currentSeconds, Reference.TIMER_X, Reference.TIMER_Y);
    }
  }

}
