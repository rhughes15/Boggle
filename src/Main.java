import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//***********************************
// Ryan Hughes
//
// This is the main class for the Boggle game. It
// handles the construction of the scene with three
// buttons, one to start the game, one to stop the game,
// and one to change the size of the board from 4x4 to 5x5.
// The game starts with a default 4x4 game board.
//***********************************

public class Main extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("Boggle");
    Group root = new Group();
    Canvas canvas = new Canvas(Reference.SCREEN_WIDTH, Reference.SCREEN_HEIGHT);
    Controller controller = new Controller(canvas);
    Button boardSizeButton = new Button("Change Board Size");
    boardSizeButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.changeBoardSize();
      }
    });
    boardSizeButton.setLayoutX(Reference.BOARD_BUTTON_X);
    boardSizeButton.setLayoutY(Reference.BOARD_BUTTON_Y);
    Button gameStartButton = new Button("Start New Game");
    gameStartButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if(controller.gameOn())
        {
          controller.stopGame();
        }
        controller.startGame();
        controller.display();
      }
    });
    gameStartButton.setLayoutX(Reference.PLAY_BUTTON_X);
    gameStartButton.setLayoutY(Reference.PLAY_BUTTON_Y);
    Button gameEndButton = new Button("End Game");
    gameEndButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.stopGame();
      }
    });
    gameEndButton.setLayoutX(Reference.STOP_BUTTON_X);
    gameEndButton.setLayoutY(Reference.STOP_BUTTON_Y);
    root.getChildren().addAll(canvas, boardSizeButton, gameStartButton, gameEndButton);
    Scene scene = new Scene(root, Reference.SCREEN_WIDTH,
      Reference.SCREEN_HEIGHT, Reference.BACKGROUND_COLOR);
    primaryStage.setScene(scene);
    primaryStage.show();
    controller.display();
  }

  public static void main(String[]args) {launch(args);}
}
