import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

//***********************************
// Ryan Hughes
//
// This class holds the current data for the player.
// It holds the last 7 words played and whether they were
// valid words in the dictionary, the player's score,
// and the Title image. When called to display itself
// it displays all of these things in the appropriate
// places.
//***********************************

public class Player
{
  private Image title;
  private GraphicsContext gc;
  private int score;
  private ArrayList<String> words;
  private ArrayList<Color> colors;

  public Player(GraphicsContext gc)
  {
    this.gc = gc;
    title = new Image(Reference.TITLE_IMAGE);
    score = 0;
    words = new ArrayList<>();
    colors = new ArrayList<>();
  }

  public void display()
  {
    gc.drawImage(title, Reference.TITLE_X, Reference.TITLE_Y);
    gc.setStroke(Reference.TILE_GREEN);
    gc.setFont(Font.font("Consolas", 36));
    gc.strokeText("Score: " + score, Reference.SCORE_X, Reference.SCORE_Y);;
    for(int i = words.size() - 1; i >= 0; i--)
    {
      gc.setStroke(colors.get(i));
      gc.strokeText(words.get(i), Reference.WORDLIST_X,
        Reference.WORDLIST_Y + (i * Reference.WORD_OFFSET));
    }
  }

  public void resetScore()
  {
    score = 0;
    words.clear();
    colors.clear();
  }

  public void addGoodWord(String word)
  {
    if(words.size()  > 6)
    {
      words.remove(words.size() - 1);
      colors.remove(colors.size() - 1);
    }
    words.add(0, word);
    colors.add(0, Reference.TILE_GREEN);
  }

  public void addBadWord(String word)
  {
    if(words.size()  > 6)
    {
      words.remove(words.size() - 1);
      colors.remove(colors.size() - 1);
    }
    words.add(0, word);
    colors.add(0, Color.RED);
  }

  public void score(int points)
  {
    score += points;
  }
}
