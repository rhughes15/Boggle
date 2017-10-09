import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("Boggle");
    Group root = new Group();
    Canvas canvas = new Canvas(Reference.SCREEN_WIDTH, Reference.SCREEN_HEIGHT);
    Controller controller = new Controller(canvas);
    TextArea textArea = new TextArea();
    textArea.setPrefRowCount(1);
    textArea.setLayoutX(Reference.SCREEN_WIDTH - 100);
    textArea.setLayoutY(25);
    Button button = new Button("Check Word");
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        controller.handleButtonPress(textArea.getText());
      }
    });
    button.setLayoutX(Reference.SCREEN_WIDTH - 100);
    button.setLayoutY(75);
    root.getChildren().addAll(canvas, textArea, button);
    Scene scene = new Scene(root, Reference.SCREEN_WIDTH,
      Reference.SCREEN_HEIGHT, Reference.BACKGROUND_COLOR);
    primaryStage.setScene(scene);
    primaryStage.show();
    controller.displayBoard();
  }

  public static void main(String[]args) {launch(args);}
}
