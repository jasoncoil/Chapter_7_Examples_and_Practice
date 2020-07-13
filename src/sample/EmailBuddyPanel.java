package sample;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class EmailBuddyPanel extends GridPane{
    private EmailBuddyList model; //List of buddies

    //Components on the window
    private ListView<EmailBuddy> buddyList;
    private Button addBuddyButton;
    private Button removeBuddyButton;
    private CheckBox hotListButton;
    private TextArea buddyInfo;

    //respective get methods for each component
    public ListView<EmailBuddy> getBuddyList(){return buddyList;}
    public Button getAddBuddyButton(){return addBuddyButton;}
    public Button getRemoveBuddyButton(){return removeBuddyButton;}
    public CheckBox getHotListButton(){return hotListButton; }
    public TextArea getBuddyInfo(){return buddyInfo;}


    public EmailBuddyPanel(EmailBuddyList m){
        model = m; //store model so update method can update it

        setPadding(new Insets(10,10,10,10));

        buddyList = new ListView<EmailBuddy>();
        buddyList.setItems(FXCollections.observableArrayList(m.getBuddies()));
        add(buddyList,0,0,1,4);//placed on column 0 row 0 but spans 1 column and 3 rows
        buddyList.setPrefHeight(Integer.MAX_VALUE);
        buddyList.setMinWidth(200);
        buddyList.setPrefWidth(Integer.MAX_VALUE);

        addBuddyButton = new Button("Add");
        add(addBuddyButton,1,0);
        setMargin(addBuddyButton, new Insets(0,0,10,10));
        setValignment(addBuddyButton,VPos.TOP);
        setHalignment(addBuddyButton,HPos.CENTER);
        addBuddyButton.setMinHeight(25);
        addBuddyButton.setMinWidth(100);

        removeBuddyButton = new Button("Remove");
        add(removeBuddyButton,1,1);
        setMargin(removeBuddyButton, new Insets(0, 0, 10, 10));
        setValignment(removeBuddyButton, VPos.TOP);
        setHalignment(removeBuddyButton, HPos.CENTER);
        removeBuddyButton.setMinHeight(25);
        removeBuddyButton.setMinWidth(100);

        hotListButton = new CheckBox("Show Hot List");
        add(hotListButton,1,2);
        setMargin(hotListButton, new Insets(0, 0, 10, 10));
        setValignment(hotListButton, VPos.TOP);
        setHalignment(hotListButton, HPos.CENTER);
        hotListButton.setMinHeight(25);
        hotListButton.setMinWidth(100);

        buddyInfo = new TextArea();
        add(buddyInfo,1,3);
        buddyInfo.setEditable(false);
        buddyInfo.setPrefHeight(Integer.MAX_VALUE);
        buddyInfo.setMinWidth(200);
        buddyInfo.setPrefWidth(Integer.MAX_VALUE);
        buddyInfo.setWrapText(true);

        update(); //update components by filling them in as changes are made

    }
    //update components so they reflect the changes made to the model
    public void update(){
        // Remember what was selected
        int selectedItem = buddyList.getSelectionModel().getSelectedIndex();

        EmailBuddy[] exactList;
        if (hotListButton.isSelected()) {
            exactList = new EmailBuddy[model.getHotListSize()];
            for (int i = 0; i < model.getHotListSize(); i++)
                exactList[i] = model.getHotBuddy(i);
        }
        else {
            exactList = new EmailBuddy[model.getSize()];
            for (int i=0; i<model.getSize(); i++)
                exactList[i] = model.getBuddy(i);
        }
//        buddyList.setItems(null); /// Seems to be required for a proper update
        buddyList.setItems(FXCollections.observableArrayList(exactList));

        if(buddyList.getSelectionModel().getSelectedIndex() >= 0){
            String text = "Name: " + model.getBuddy(buddyList.getSelectionModel().getSelectedIndex()).getName() + " \n"
             + "Address: " + model.getBuddy(buddyList.getSelectionModel().getSelectedIndex()).getAddress() + " \n" +
                    "Hot? --> " + model.getBuddy(buddyList.getSelectionModel().getSelectedIndex()).isOnHotList();
            buddyInfo.setText(text);
        }

        // Reselect the selected item
        buddyList.getSelectionModel().select(selectedItem);

        //disable remove button if nothing is selected
        removeBuddyButton.setDisable(buddyList.getSelectionModel().getSelectedIndex() < 0);

    }
}
