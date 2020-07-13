import javafx.application.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;
import java.util.*;


public class DialogBoxExample extends Application {
    private GridPane aPane ;

    public void start(Stage primaryStage) {
        aPane = new GridPane();
        aPane.setPadding(new Insets(10, 10, 10, 10));
        aPane.setHgap(5);
        aPane.setVgap(5);
        Scene scene = new Scene(aPane, 600, 300);


        String[] buttonNames = {"Information Message Box", "Warning Message Box", "Error Message Box", "Expandable Message Box",
                "Confirmation Dialog Box", "Multiple Option Dialog Box",
                "Choice Dialog Box", "Text Input Dialog Box",
                "Password Dialog Box"};
        Button[] buttons = new Button[9];


        //for loop creating the 9 buttons and storing them in "buttons with the names from "buttonNames"
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++) {
                buttons[row * 3 + col] = new Button(buttonNames[row * 3 + col]);
                buttons[row * 3 + col].setPrefWidth(200);
                buttons[row * 3 + col].setPrefHeight(100);
                aPane.add(buttons[row * 3 + col], col, row);
            }
        }



        //EVENT HANDLERS

        //Event Handler - Information Message Box
        buttons[0].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message to User");
                alert.setHeaderText(null);
                alert.setContentText("This is a reminder to always wear a coat when it is below 5 degrees Celsius to avoid catching a cold.");
                alert.showAndWait();
            }});

        //Event Handler - Warning Message Box
        buttons[1].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning to User!");
                alert.setHeaderText(null);
                alert.setContentText("Warning! Never stick your tongue to a frozen pole!");
                alert.showAndWait();
            }});

        //Event Handler - Error Message Box
        buttons[2].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText(null);
                alert.setContentText("Your quantum spanner is malfunctioning." + "\n"+ "Please insert 3 blorgons to repair.");
                alert.showAndWait();
            }});

        //Event Handler - Expandable Message Box
        buttons[3].setOnAction(new EventHandler<ActionEvent>(){
           public void handle(ActionEvent e){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Expandable Error Message!");
               alert.setHeaderText(null);
               alert.setContentText("Ahoy Matey! Welcome aboard black beards vessel! Sign here with yar blood to join thar crew");
               Label label = new Label("See the Pirate Contract:");
               TextArea contract = new TextArea("You be selling yer soul to the ship. Any gold plundered is split among the ship with yer cut being 1%. " +
                       "Upon yar death your skeleton will continue to work these decks until that thar sun burns this planet to a crisp! " +
                       "All orders from the captain must be obeyed or else yar be cursed to the bottom of the sea where the sharks" +
                       " are a plenty. Benefits include:" + "\n" + "-Health Insurance" + "\n" + "-$500 towards any physical activity" + "\n" +
                       "-$400 dollars towards dental" + "\n" + "-$300 dollars in massages or physiotherapy" + "\n" + "\n" + "Blood Signature Here:" + "\n"
                       + "_____________");
               contract.setEditable(false);
               contract.setWrapText(true);
               contract.setWrapText(true);
               contract.setMaxWidth(Double.MAX_VALUE);
               contract.setMaxHeight(Double.MAX_VALUE);
               aPane.setVgrow(contract, Priority.ALWAYS);
               aPane.setHgrow(contract, Priority.ALWAYS);
               GridPane expandableContent = new GridPane();
               expandableContent.setMaxWidth(Double.MAX_VALUE);
               expandableContent.add(label, 0, 0);
               expandableContent.add(contract, 0, 1);

               alert.getDialogPane().setExpandableContent(expandableContent);
               alert.showAndWait();
           }});

        //Event Handler - Confirmation Message Box
        buttons[4].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Answer this question to win big!");
                alert.setHeaderText(null);
                alert.setContentText("True or false. Mantis shrimps have the most complex eyes in the animal kingdom that " +
                        "can see ultraviolet and polarized light.");
                alert.getButtonTypes().setAll(); // Erases the default buttons
                ButtonType[] buttons = new ButtonType[2];
                buttons[0] = new ButtonType("True!");
                buttons[1] = new ButtonType("False!");
                alert.getButtonTypes().add(buttons[0]);
                alert.getButtonTypes().add(buttons[1]);

                Optional<ButtonType> result = alert.showAndWait(); //Creates option of outputting things based on specific button clicks

                if(result.get() == buttons[0]){
                    System.out.println("You are correct! Your prize is ... knowledge! Congratulations!");
                }
                else{
                    System.out.println("You are incorrect! You should study your shrimp facts.");
                }
            }});

        //Event Handler - Multiple Option Dialog Box
        buttons[5].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("The Lone Cucumber");
                alert.setHeaderText(null);
                alert.setContentText("There is a cucumber on the table. Just sitting there. What do you do to it?");
                alert.getButtonTypes().setAll(); // Erases the default buttons
                ButtonType[] buttons = new ButtonType[5];
                String[] optionButtonNames = {"Pickle","Tickle","Throw","Chop","Eat"};
                for(int i = 0; i<buttons.length;i++) {
                    buttons[i] = new ButtonType(optionButtonNames[i]);
                    alert.getButtonTypes().add(buttons[i]);
                }

                Optional<ButtonType> result = alert.showAndWait(); //Creates option of outputting things based on specific button clicks

                if(result.get() == buttons[0])
                    System.out.println("You grab a jar, add some vinegar and spices. After a few weeks you got one tasty pickle.");
                if(result.get() == buttons[1])
                    System.out.println("It smiles a little");
                if(result.get() == buttons[2])
                    System.out.println("It slams against the wall with a 'THUD' and a little cucumber juice sprays out");
                if(result.get() == buttons[3])
                    System.out.println("You make some bite size cucumber slices. One step closer to a tasty salad");
                if(result.get() == buttons[4])
                    System.out.println("You eat it like an animal. People start staring at your obnoxiously loud chomping noises.");
            }});

        //Event Handler - Choice Dialog Box
        buttons[6].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                String[] options = {"Memes","Dreams","Reams","Beams","Steams","Seams"};
                ChoiceDialog<String> dialog = new ChoiceDialog<String>("Memes",options);//Choicedialog box with the choice "options" and default "memes"
                dialog.setTitle("Choices.. Choices");
                dialog.setHeaderText(null);
                dialog.setContentText("Choose your Occupation:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    StringBuilder inputString = new StringBuilder(result.get());
                    inputString.deleteCharAt(inputString.length()-1);
                    if(result.get() == "Memes")
                        System.out.println("Your occupation is: " + inputString + "r");
                    else
                        System.out.println("Your occupation is: " + inputString + "er");
                }
            }});

        //Event Handler - Text Field Message Box
        buttons[7].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Sense Smacker");
                dialog.setHeaderText(null);
                dialog.setContentText("Please type in your aspiration: ");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    System.out.println("You will never achieve '" + result.get() + "'! Quit now! You're a failure!" + "\n" +
                            "Thank you for picking Sense Smacker. Whenever you need some sense smacked into you and to get your life back on track.");
                }
            }});

        //Event Handler - Text Field Message Box - Password login
        buttons[8].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Dialog dialog = new Dialog();
                dialog.setTitle("Login Dialog");
                dialog.setHeaderText(null);
                ButtonType loginButtonType = new ButtonType("Login",
                        ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                        ButtonType.CANCEL);
                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(10, 10, 10, 10));
                TextField username = new TextField();
                username.setPromptText("Username");
                PasswordField password = new PasswordField();
                password.setPromptText("Password");
                grid.add(new Label("Username:"), 0, 0);
                grid.add(username, 1, 0);
                grid.add(new Label("Password:"), 0, 1);
                grid.add(password, 1, 1);
                dialog.getDialogPane().setContent(grid);

                username.requestFocus();

                // Enable/Disable login btn depending on whether username was entered.
                Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
                loginButton.setDisable(true); // Disable upon start
                username.textProperty().addListener(new ChangeListener() {
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        loginButton.setDisable(((String)newValue).trim().isEmpty());
                    }});

                dialog.setResultConverter(
                        new Callback<ButtonType, Pair<String, String>>() {
                            public Pair<String, String> call(ButtonType b) {
                                if (b == loginButtonType) {
                                    return new Pair<String,String>(username.getText(),
                                            password.getText());
                                }
                                return null;
                            }
                        });


                Optional<Pair<String, String>> result = dialog.showAndWait();




                if (result.isPresent())
                    System.out.println("Username = " + result.get().getKey() +
                            ", Password = " + result.get().getValue());

            }});
        primaryStage.setTitle("Dialog Boxes Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
