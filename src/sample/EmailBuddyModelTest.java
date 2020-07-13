package sample;

public class EmailBuddyModelTest {
    public static void main(String[] args) {
        EmailBuddyList buddyList = new EmailBuddyList();
        EmailBuddy bud1 = new EmailBuddy("Jason","j@gmail.com");
        buddyList.addBuddy(bud1);
        System.out.println("Getting Size of BuddyList");
        System.out.println(buddyList.getSize());
        System.out.println("Getting Buddies from BuddyList");
        System.out.println(buddyList.getBuddies());
        System.out.println("Getting Buddies from BuddyList");
        System.out.println(buddyList.getBuddy(0));

    }

}
