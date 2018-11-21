// package ActivityTracker.src.main.java.activitytracker;
package activitytracker;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<Data> runData;
    private boolean shareMyData;
    private List<String> friendsList;
    private Challenge myChallenges;

    public Profile(String name) {
        this.name = name;
    }

    // constructor method
    public Profile(String inName, List<Data> inRuns, Boolean inPrivacy, List<String> friends, String[] challenges) {
        this.name = inName;
        this.runData = inRuns;
        this.shareMyData = inPrivacy;
        this.friendsList = friends;
        this.myChallenges = new Challenge(challenges[0], challenges[1], challenges[2]);
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

    public List<Data> getAllRunsList() {
        return this.runData;
    }

    public List<String> getAllFriendsList() {
        return this.friendsList;
    }

    public Boolean getPrivacy() {
        return this.shareMyData;
    }

    public void getChallenge() {
        this.myChallenges.getChallenges();
    }

    public void getFriends() {
        //fix

//        System.out.println("You are friends with: \n");
//        for (Profile friend : friendsList) {
//            System.out.println(friend.getName());
//        }
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

    public void setFriendsList(ArrayList<String> newFriendsList) { this.friendsList = newFriendsList;}
    // uses the method implemented in the Challenge class
    public void setMyChallenges(String chall1, String chall2, String chall3) {
        this.myChallenges.setChallenge(chall1, chall2, chall3);
    }

    public void addFriend(Profile newFriend) {
        //fix

//        this.friendsList.add(newFriend);
//        System.out.println("You have successfully added " + newFriend.getName() + " as your friend!");
    }
}
