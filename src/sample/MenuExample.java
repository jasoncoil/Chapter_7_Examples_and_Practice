package sample;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuExample extends Application {
    private VBox aPane;

    public void start(Stage primaryStage) {
        aPane = new VBox();
        Scene scene = new Scene(aPane,300,100);

        //MENU and MENUITEM 's

        //Create Menus
         Menu fileMenu = new Menu("_File");
         Menu editMenu = new Menu ("_Edit");
         Menu settingsMenu = new Menu("_Settings");

         //Create MenuItems for the fileMenu and add it to the fileMenu
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open...");
        MenuItem closeItem = new MenuItem("Close");
        MenuItem saveAsItem = new MenuItem("Save As ...");
        fileMenu.getItems().addAll(newItem,new SeparatorMenuItem(),openItem,closeItem,saveAsItem);
        //Creating Accelerators (shortcuts) for fileMenu items
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        closeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        saveAsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        //Disabling closeItem
        closeItem.setDisable(true);

        //Creating RadioMenuItems (small,medium and large) for settingsMenu. Also adding a toggle feature.
        ToggleGroup settingsGroup = new ToggleGroup();
        RadioMenuItem smallItem = new RadioMenuItem("Small");
        smallItem.setToggleGroup(settingsGroup);
        RadioMenuItem mediumItem = new RadioMenuItem("Medium");
        mediumItem.setToggleGroup(settingsGroup);
        RadioMenuItem largeItem = new RadioMenuItem("Large");
        largeItem.setToggleGroup(settingsGroup);
        settingsMenu.getItems().addAll(smallItem,mediumItem,largeItem);

        //Creating a cascading menu and other items inside the editmenu
        Menu searchMenu = new Menu("Search");
        MenuItem findItem = new MenuItem("Find");
        MenuItem replaceItem = new MenuItem("Replace");
        searchMenu.getItems().addAll(findItem,replaceItem);

        CheckMenuItem gridItem = new CheckMenuItem("Use Grid Lines");//Similar to a toggle
        MenuItem copyItem = new MenuItem("Copy");
        editMenu.getItems().addAll(gridItem,new SeparatorMenuItem(),copyItem,searchMenu);

        //Creating a Pop-Up Menu
        ContextMenu popupMenu = new ContextMenu();
        MenuItem helpItem = new MenuItem("Help");
        MenuItem inspectItem = new MenuItem("Inspect");
        popupMenu.getItems().addAll(helpItem, inspectItem);

        //EVENT HANDLERS

        //Event Handler to cause the Pop-Up Menu to show up
        aPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.SECONDARY)
                    popupMenu.show(aPane,e.getScreenX(),e.getScreenY());
            }
        }
        );
        //Event Handler for newItem
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                closeItem.setDisable(false);
                newItem.setDisable(true);
                openItem.setDisable(true);
                System.out.println("NEW has been pressed");
            }});

        //Event Handler for gridItem
        gridItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (((CheckMenuItem)e.getSource()).isSelected())
                    System.out.println("USE GRIDLINES has been selected");
                else
                    System.out.println("USE GRIDLINES has been unselected");
            }
        });
        //Event Handler for openItem
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                closeItem.setDisable(false);
                openItem.setDisable(true);
                newItem.setDisable(true);
                System.out.println("OPEN has been pressed");
            }
        });
        //Event Handler for closeItem
        closeItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                openItem.setDisable(false);
                newItem.setDisable(false);
                closeItem.setDisable(true);
                System.out.println("CLOSE has been pressed");
            }
        });
        //Event Handler for Small/Medium/Large items
        smallItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                if (((RadioMenuItem)e.getSource()).isSelected())
                    System.out.println("Small has been selected");
            }
        });
        mediumItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                if (((RadioMenuItem)e.getSource()).isSelected())
                    System.out.println("Medium has been selected");
            }
        });
        largeItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                if (((RadioMenuItem)e.getSource()).isSelected())
                    System.out.println("Large has been selected");
            }
        });



        //Add the menus to a menu bar and then add the menu bar to the pane
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,settingsMenu);
        aPane.getChildren().add(menuBar);

        primaryStage.setTitle("Menu Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
