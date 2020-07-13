package sample;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;



public class BuddyDetailsDialog extends Dialog{
    public BuddyDetailsDialog(Stage owner, String title, EmailBuddy bud) {
        setTitle(title);
        // Set the button types
        ButtonType okButtonType = new ButtonType("OK",
                ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        // Create the and and address labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        TextField nameField = new TextField(bud.getName());
        nameField.setPromptText("Person's name to be shown in the list");
        nameField.setMinWidth(300);
        TextField addressField = new TextField(bud.getAddress());
        addressField.setPromptText("Enter a valid email address");
        addressField.setMinWidth(300);
        CheckBox onHotList = new CheckBox("On Hot List");
        onHotList.setSelected(bud.isOnHotList());
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Address:"), 0, 1);
        grid.add(addressField, 1, 1);
        grid.add(onHotList, 1, 2);
        getDialogPane().setContent(grid); // Puts the stuff on the window

        // Enable/Disable OK button depending on whether username was entered.
        Node okButton = getDialogPane().lookupButton(okButtonType);
        okButton.setDisable(true); // Disable upon start
        nameField.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {
                okButton.setDisable(nameField.getText().trim().isEmpty() ||
                        addressField.getText().trim().isEmpty());
            }
        });
        // Enable/Disable OK button depending on whether address was entered.
        addressField.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {
                okButton.setDisable(nameField.getText().trim().isEmpty() ||
                        addressField.getText().trim().isEmpty());
            }
        });
        // Enable OK button if hotList has changed
        onHotList.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                okButton.setDisable(nameField.getText().trim().isEmpty() ||
                        addressField.getText().trim().isEmpty());
            }
        });

        //set result to an Email buddy containing information set in the dialog box
        setResultConverter(new Callback<ButtonType,EmailBuddy>(){
            public EmailBuddy call(ButtonType b){
                if(b == okButtonType){
                    bud.setName(nameField.getText());
                    bud.setAddress(addressField.getText());
                    bud.OnHotList(onHotList.isSelected());
                    return bud;
                }
                return null;
            }
            });


    }

}
