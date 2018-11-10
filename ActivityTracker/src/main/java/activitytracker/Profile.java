package activitytracker;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<Data> runData;
    private boolean shareMyData;
    private List<Profile> friendsList;
    private Challenge myChallenges;

    // constructor method
    public Profile(String inName, List inRuns, Boolean inPrivacy) {
        this.name = inName;
        this.runData = inRuns;
        this.shareMyData = inPrivacy;
        this.friendsList = new ArrayList<Profile>();
        this.myChallenges = new Challenge("default", "default", "default");
    }

    // prints out all the info from the profile
    public void getProfile() {
        System.out.println("Name: " + this.name + "\nYou have been on the following runs: ");
        for (Data x : this.runData) {
            x.getData();
            System.out.println();
        }
        System.out.println("You have chosen to share your personal information: " + this.getPrivacy());
        this.myChallenges.getChallenges();
    }

    // individual get methods for a Profile object
    public String getName() {
        return this.name;
    }

    public void getRunData() {
        for (Data x : this.runData) {
            x.getData();
        }
    }

    public Boolean getPrivacy() {
        return this.shareMyData;
    }

    public void getChallenge() {
        this.myChallenges.getChallenges();
    }

    public void getFriends() {
        System.out.println("You are friends with: \n");
        for (Profile friend : friendsList) {
            System.out.println(friend.getName());
        }
    }

    // individual set method for Profile objects
    public void setName(String newName) {
        this.name = newName;
    }

    public void setRuns(List<Data> newRuns) {
        this.runData = newRuns;
    }

    public void setPrivacy(Boolean newPrivacy) {
        this.shareMyData = newPrivacy;
    }

    // uses the method implemented in the Challenge class
    public void setMyChallenges(String chall1, String chall2, String chall3) {
        this.myChallenges.setChallenge(chall1, chall2, chall3);
    }

    public void addFriend(Profile newFriend) {
        this.friendsList.add(newFriend);
        System.out.println("You have successfully added " + newFriend.getName() + " as your friend!");
    }

    // main method, for testing purposes

    /*
     * public static void main(String[] args){ Data run1 = new
     * Data("East Coast Trail",10,104); Data run2 = new
     * Data("somethingelse Trail",7,73);
     * 
     * List<Data> list1 = new ArrayList<Data>(); list1.add(run1); list1.add(run2);
     * 
     * Profile profile1 = new Profile("Sohil",list1,true);
     * 
     * profile1.getProfile(); }
     */

}
