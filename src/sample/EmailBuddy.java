package sample;

public class EmailBuddy {
    private String name;
    private String address;
    private boolean onHotList;

    //constructor zero parameter
    public EmailBuddy(){
        name = "";
        address = "";
        onHotList = false;
    }

    //constructor with name and address parameters passed in
    public EmailBuddy(String aName, String anAddress){
        name = aName;
        address = anAddress;
        onHotList = false;
    }

    //get methods
    public String getName(){return name;}
    public String getAddress(){return address;}
    public boolean isOnHotList(){return onHotList;}

    //set methods
    public void setName(String newName){name = newName;}
    public void setAddress(String newAddress){address = newAddress;}
    public void OnHotList(boolean onList){onHotList = onList;}

    public String toString(){
        return name;
    }
}
