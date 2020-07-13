import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class BorderPaneTest extends Application {
    public void start(Stage primaryStage) {
        //Setting aside memory for a buttons array and a string array
        Button[] buttons;
        String[] names = {"New", "Open", "Save", "Compile", "Run", "Quit"};
        //Creating a BorderPane that will house a TextAre, and a VBox full of buttons
        BorderPane aPane = new BorderPane();
        aPane.setPadding(new Insets(10));
        //Creating the VBox that will contain button components
        VBox buttonPane = new VBox();
        buttonPane.setPadding(new Insets(0, 0, 0, 10));
        buttonPane.setSpacing(10);
        //Storing the buttons array to memory with a length of 6
        buttons = new Button[names.length];
        //For loop that creates a button with the names in the name array, setting their preferred width,
        //preferred height and adding it to the VBox
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new Button(names[i]);
            buttons[i].setPrefWidth(100);
            buttons[i].setPrefHeight(30);
            buttonPane.getChildren().add(buttons[i]);
        }
        //Setting the buttons on the right and the text area in the center
        aPane.setRight(buttonPane);
        aPane.setCenter(new TextArea());
        TextField statusField = new TextField("This is like a status pane");
        statusField.setEditable(false);
        statusField.setStyle("-fx-background-color: GRAY; -fx-text-fill: WHITE;");
        aPane.setMargin(statusField, new Insets(10, 0, 0, 0)); // allows spacing at top
        aPane.setBottom(statusField);
        primaryStage.setTitle("BorderPane Example 2");
        primaryStage.setScene(new Scene(aPane, 500, 500));
        primaryStage.show();
    }
}

