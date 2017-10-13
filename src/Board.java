import javafx.scene.canvas.GraphicsContext;

//***********************************
// Ryan Hughes
//
// This class creates a two dimensional character
// array of random characters and a one dimensional
// ArrayList of tiles based on the character array
// with the necessary data to be displayed graphically.
//
// Will eventually have letter frequencies specified for
// smoother game play.
//***********************************

import java.util.ArrayList;

public class Board
{
  private char[][] charBoard;
  private ArrayList<Tile> tileBoard;
  private GraphicsContext gc;

  // constructor initializes two dimensional charBoard with the characters for the board,
  // initializes the one dimensional tileBoard with the tiles for the board
  public Board(int size, GraphicsContext gc)
  {
    this.gc = gc;
    charBoard = new char[size][size];
    for(int i = 0; i < size; i++)
    {
      for(int j = 0; j < size; j++)
      {
        charBoard[i][j] = (char)((Math.random() * 26) + 65);
      }
    }
    tileBoard = new ArrayList<>();
    int x = Reference.BOARD_X;
    int y = Reference.BOARD_Y;
    for(int i = 0; i < size; i++)
    {
      for(int j = 0; j < size; j++)
      {
        tileBoard.add(new Tile(gc, charBoard[i][j], x, y));
        x += Reference.TILE_WIDTH;
      }
      y += Reference.TILE_HEIGHT;
      x = Reference.BOARD_X;
    }
  }

  // displays each tile in the tileBoard
  public void displayBoard()
  {
    //clear the background
    gc.setFill(Reference.BACKGROUND_COLOR);
    gc.fillRect(0, 0, Reference.SCREEN_WIDTH, Reference.SCREEN_HEIGHT);

    //display the tiles
    for(Tile t : tileBoard) t.display();
  }

  // returns true if the word is on the board
  // assumes valid letter order which will be
  // mandated by future method of input
  public boolean contains(String word)
  {
    char temp;
    for(int i = 0; i < word.length(); i++)
    {
      temp = word.charAt(i);
      if(!isOnBoard(temp)) return false;
    }
    return true;
  }

  // returns true if c is somewhere on the board
  private boolean isOnBoard(char c)
  {
    for(int ro = 0; ro < charBoard.length; ro++)
    {
      for(int col = 0; col < charBoard[0].length; col++)
      {
        if(charBoard[ro][col] == c ||
           charBoard[ro][col] + 32 == c) return true;
      }
    }
    return false;
  }

  public ArrayList<Tile> getTiles() { return tileBoard; }
  public int getSize() { return charBoard.length; }
}
