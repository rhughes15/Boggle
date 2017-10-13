import javafx.scene.paint.Color;

//***********************************
// Ryan Hughes
//
// This is a Reference class to hold all of the
// static variables in one place for ease of
// visual debugging and coding logic.
//***********************************

public class Reference
{
  public static final String DICTIONARY = "resources\\dictionary.txt";
  public static final String GREEN_SHEET = "GreenLetters.png";
  public static final String YELLOW_SHEET = "YellowLetters.png";
  public static final int SCREEN_WIDTH = 700;
  public static final int CENTER_X = SCREEN_WIDTH / 2;
  public static final int SCREEN_HEIGHT = 700;
  public static final int CENTER_Y = SCREEN_HEIGHT / 2;
  public static final int TILE_HEIGHT = 100;
  public static final int TILE_WIDTH = 100;
  public static final int BOARD_X = 225; // x coordinate of the board
  public static final int BOARD_Y = 200; // y coordinate of the board
  public static final Color BACKGROUND_COLOR = Color.BLACK;
  public static final int TILE_DETECTION_BUFFER = 10;  // the detection buffer within each tile
  public static final String TITLE_IMAGE = "Title.png";
  public static final int TITLE_WIDTH = 250;
  public static final int TITLE_HEIGHT = 125;
  public static final int TITLE_X = CENTER_X - (TITLE_WIDTH / 2);  // Title will be in the center from left to right
  public static final int TITLE_Y = 25;
  public static final int SCORE_X = 50;  // x coordinate of the score
  public static final int SCORE_Y = 650; // y coordinate of the score
  public static final int GAME_TIME = 3; // length of the game in minutes
  public static final int TIMER_X = SCORE_X;
  public static final int TIMER_Y = 180;
  public static final int TIMER_WIDTH = 225;
  public static final int TIMER_HEIGHT = 50;
  public static final int BOARD_BUTTON_X = SCREEN_WIDTH - 240;
  public static final int BOARD_BUTTON_Y = SCREEN_HEIGHT - 75;
  public static final int PLAY_BUTTON_X = SCREEN_WIDTH - 225;
  public static final int PLAY_BUTTON_Y = TIMER_Y - 25;
  public static final int STOP_BUTTON_X = PLAY_BUTTON_X - 100;
  public static final int STOP_BUTTON_Y = PLAY_BUTTON_Y;
  public static final Color TILE_GREEN = Color.color(.2265, .9179, .0625);
  public static final int WORDLIST_X = SCORE_X;
  public static final int WORDLIST_Y = 250;
  public static final int WORD_OFFSET = 50;
}
