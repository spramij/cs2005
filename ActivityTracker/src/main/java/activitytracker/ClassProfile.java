package activitytracker;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ClassProfile {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private List<ClassData> runData;
    private boolean shareMyData;
    private List<String> friendsList;
    private ClassChallenge myChallenges;

    public ClassProfile(String userName) {
        this.userName = userName;
    }

    public ClassProfile(String userName, String firstName, String lastName, String password, ClassData[] runData, boolean privacy,
            String[] friends, ClassChallenge challenges) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.runData = new ArrayList<ClassData>();

        if (runData != null) {
            for (ClassData data : runData) {
                this.runData.add(data);
            }
        }

        this.shareMyData = privacy;

        this.friendsList = new ArrayList<String>();

        if (friends != null) {
            for (String user : friends) {
                this.friendsList.add(user);
            }
        }

        this.myChallenges = challenges;
    }

    // constructor method
    public ClassProfile(String inName, List<ClassData> inRuns, Boolean inPrivacy, List<String> friends, String[] challenges) {
        this.userName = inName;
        this.runData = inRuns;
        this.shareMyData = inPrivacy;
        this.friendsList = friends;
        this.myChallenges = new ClassChallenge(challenges[0], challenges[1], challenges[2]);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Name: " + this.userName + "\n");
        strBuilder.append("Runs:\n");
        System.out.println("Name: " + this.userName + "\nYou have been on the following runs: ");
        for (ClassData x : this.runData) {
            strBuilder.append("\t" + x.toString());
        }
        strBuilder.append("Share: " + this.getPrivacy() + "\n");
        strBuilder.append("Challanges: " + this.myChallenges.toString());

        return strBuilder.toString();
    }

    // individual get methods for a Profile object
    @JsonGetter("name")
    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    @JsonGetter("runs")
    public ClassData[] getRunData() {
        ClassData[] runDataSet = new ClassData[this.runData.size()];

        return this.runData.toArray(runDataSet);
    }

    public List<ClassData> getAllRunsList() {
        return this.runData;
    }

    public List<String> getAllFriendsList() {
        return this.friendsList;
    }

    @JsonGetter("share")
    public Boolean getPrivacy() {
        return this.shareMyData;
    }

    @JsonGetter("challanges")
    public void getChallenge() {
        this.myChallenges.getChallenges();
    }

    @JsonGetter("friends")
    public String[] getFriends() {
        String[] friends = new String[this.friendsList.size()];

        for (int i = 0; i < friends.length; i++) {
            friends[i] = friendsList.get(i);
        }

        return friends;
    }

    // individual set method for Profile objects
    @JsonSetter("name")
    public void setName(String newName) {
        this.userName = newName;
    }

    @JsonSetter("runs")
    public void setRuns(ClassData[] newRuns) {
        this.runData.clear();

        for (ClassData data : newRuns) {
            runData.add(data);
        }
    }

    @JsonSetter("share")
    public void setPrivacy(Boolean newPrivacy) {
        this.shareMyData = newPrivacy;
    }

    @JsonSetter("friends")
    public void setFriendsList(String[] newFriendsList) {
        this.friendsList.clear();

        for (String friend : newFriendsList) {
            this.friendsList.add(friend);
        }
    }

    // return the total distance ran by the Profile user
    public double getAllRunDistance() {
        double totalDist = 0;
        for (ClassData runs : this.runData) {
            totalDist += runs.getDistance();
        }
        return totalDist;
    }

    // return the total time ran by the Profile user
    public double getAllTimeRan() {
        double totalTime = 0;
        for (ClassData runs : this.runData) {
            totalTime += runs.getDuration();
        }
        return totalTime;
    }

    // return the average inclination of runs
    public double getAverageInclination() {
        double averageIncli = 0;
        int numRuns = 0;
        for (ClassData runs : this.runData) {
            averageIncli += runs.getAltitude();
            numRuns++;
        }
        averageIncli /= numRuns;
        return averageIncli;
    }

    // return the entire array of run data
    public ClassData[] getAllRuns() {
        return this.runData.toArray(new ClassData[this.runData.size()]);
    }

    // uses the method implemented in the Challenge class
    public void setMyChallenges(String chall1, String chall2, String chall3) {
        this.myChallenges.setChallenge(new String[] { chall1, chall2, chall3 });
    }

    public void addFriend(ClassProfile newFriend) {
        // fix

        // this.friendsList.add(newFriend);
        // System.out.println("You have successfully added " + newFriend.getName() + "
        // as your friend!");

        this.friendsList.add(newFriend.getUserName());
    }
}
