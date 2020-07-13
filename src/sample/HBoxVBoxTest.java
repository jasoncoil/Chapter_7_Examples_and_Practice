import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.geometry.Insets;

import java.awt.*;

public class HBoxVBoxTest extends Application {
    public void start(Stage primaryStage) {
        HBox aPane = new HBox();

        aPane.getChildren().add(new Button("one"));
        aPane.getChildren().add(new Button("two"));
        aPane.getChildren().add(new Button("three"));
        aPane.getChildren().add(new Button("Play"));
        aPane.getChildren().add(new Button("Stop"));
        Button b = new Button("Bongo Drums Make Me Go Bananas!");
        aPane.getChildren().add(b);
        aPane.setPadding(new Insets(10,10,10,10));
        aPane.setSpacing(10);
        primaryStage.setTitle("Flow Pane Example");
        primaryStage.setScene(new Scene(aPane, 450,150));
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}