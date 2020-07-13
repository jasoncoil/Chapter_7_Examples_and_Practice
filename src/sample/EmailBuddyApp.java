package sample;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.*;

import java.util.Optional;

public class EmailBuddyApp extends Application {
    private EmailBuddyList model; // The model
    private EmailBuddyPanel view; // The view
    public void start(Stage primaryStage) {
        // Initially, no buddies
        model = new EmailBuddyList();
//        EmailBuddy tom = new EmailBuddy("Tom","Tomothy@hotmail.com");
//        model.addBuddy(tom);
        // Make a new viewing panel and add it to the pane
        view = new EmailBuddyPanel(model);

        //Handle the Add button
        view.getAddBuddyButton().setOnAction(new EventHandler<ActionEvent>() {
            // This is the single event handler for all of the buttons
            public void handle(ActionEvent actionEvent) {
                EmailBuddy aBuddy = new EmailBuddy();

                // Now bring up the dialog box
                Dialog dialog = new BuddyDetailsDialog(primaryStage,
                        "New Buddy Details", aBuddy);
                Optional<EmailBuddy> result = dialog.showAndWait();
                if (result.isPresent()) {
                    model.addBuddy(aBuddy); // Add the buddy to the model
                    view.update();
                }
        }});

        // Handle the Remove button
        view.getRemoveBuddyButton().setOnAction(new EventHandler<ActionEvent>() {
            // This is the single event handler for all of the buttons
            public void handle(ActionEvent actionEvent) {
                int index = view.getBuddyList().getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                    model.removeBuddy(index);
                    view.update();
                }
            }});
        //Handling the editing of a buddy event. When they double click on the buddy name
        //the dialog box will pop up with that selectedBuddies properties that can now be edited
        view.getBuddyList().setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    EmailBuddy selectedBuddy;
                    int selectedIndex = view.getBuddyList().getSelectionModel().
                            getSelectedIndex();
                    if (selectedIndex >= 0) {
                        if (view.getHotListButton().isSelected())
                            selectedBuddy = model.getHotBuddy(selectedIndex);
                        else
                            selectedBuddy = model.getBuddy(selectedIndex);
                        if (selectedBuddy == null)
                            return;
                        // Now bring up the dialog box
                        Dialog dialog = new BuddyDetailsDialog(primaryStage,
                                "Edit Buddy Details", selectedBuddy);
                        Optional<EmailBuddy> result = dialog.showAndWait();
                        if (result.isPresent()) {
                            view.update();
                        }
                    }
                }
                else {
                    view.update(); // Allows Remove button to be enabled on single click
                }
            }});


        // Handle the Hot List Button
        view.getHotListButton().setOnAction(new EventHandler<ActionEvent>() {
            // This is the single event handler for all of the buttons
            public void handle(ActionEvent actionEvent) {
                view.update();
            }
        });

        //Handle the user selecting an buddy on the list
        view.getBuddyList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update();
//                System.out.println(view.getBuddyList().getSelectionModel().getSelectedIndex());
            }});

        primaryStage.setTitle("Email Buddy App");
        primaryStage.setScene(new Scene(view, 500,400));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
