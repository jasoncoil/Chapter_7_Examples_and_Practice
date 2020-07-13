import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorPickerExample extends Application {
    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        ColorPicker colorPicker = new ColorPicker(Color.RED);
        aPane.getChildren().add(colorPicker);
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                System.out.println(colorPicker.getValue());
            }
        });
        primaryStage.setTitle("Color Picker Test");
        primaryStage.setScene(new Scene(aPane, 300,50));
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
