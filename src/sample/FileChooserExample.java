import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import java.io.File;
public class FileChooserExample extends Application {
    private MenuItem openItem, saveItem;

    public void start(Stage primaryStage) {
        VBox p = new VBox();
        Scene scene = new Scene(p,300,300);//new scene with window size 300-100

        //Create the file menu
        Menu fileMenu = new Menu("_File");
        openItem = new MenuItem("_Open");
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl-O"));
        saveItem = new MenuItem("_Save");
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl-S"));
        fileMenu.getItems().addAll(openItem, saveItem);

        //Event Handler for openItem
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Open Data File");
                File f = chooser.showOpenDialog(primaryStage);
                if (f != null) {
                    System.out.println("File chosen to open: " + f.getName());
                    System.out.println("File with full path: " + f.getAbsolutePath());
                }
            }});

        //Event Handler for saveItem
        saveItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Save Data File");
                File f = chooser.showSaveDialog(primaryStage);
                if (f != null) {
                    System.out.println("File chosen to save as: " + f.getName());
                    System.out.println("File with full path: " + f.getAbsolutePath());
                }
            }});


        // Add the menu to a menubar and then add the menubar to the pane
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        p.getChildren().add(menuBar);

        primaryStage.setTitle("File Chooser Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main (String[]args){
        launch(args);
    }
}

