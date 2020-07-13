package sample;

public class EmailBuddyList {
    public final int MAXIMUM_SIZE = 100;
    private EmailBuddy[] buddies;
    private int size;

    //zero parameter constructor
    public EmailBuddyList() {
        buddies = new EmailBuddy[MAXIMUM_SIZE];
        size = 0;
    }


    //Get methods
    public int getSize() { return size; }
    public EmailBuddy[] getBuddies() { return buddies; }
    public EmailBuddy getBuddy(int i) { return buddies[i]; }
    //return number of buddies on the hotlist
    public int getHotListSize(){
        int count = 0;
        for(int i = 0; i<size;i++){
            if(buddies[i].isOnHotList())
                count++;
        }
        return count;
    }
    //Get a particular buddy from the given hotlist
    public EmailBuddy getHotBuddy(int i){
        int count = 0;
        for(int j=0;j<size;j++){
            if(buddies[j].isOnHotList()) {
                if (count == i)
                    return buddies[j];
                    count++;
            }
        }
        return null;
    }


    //Add Method for adding new buddies to the list
    public void addBuddy(EmailBuddy buddy){
        if(size<MAXIMUM_SIZE){
            buddies[size++] = buddy;
        }
    }

    //Remove method for removing buddies from the list
    public void removeBuddy(int index){
        //Make sure index given is valid
        if(index>=0 && index < size) {
            // move each item in front of index back one (filling in the index specified, thus removing that item)
            for (int i = index; i < size - 1; i++) {
                buddies[i] = buddies[i + 1];
            }
            size = size - 1; //reduce size by 1
        }
    }

}
