package activitytracker;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import activitytracker.data.RunManager;

import javax.swing.*;

public class ClassProfile {
    private String userName;
    private String firstName;
    private String lastName;
    private RunManager runManager;
    private boolean shareMyData;
    private ArrayList<String> friendsList;
    private ClassChallenge myChallenges;

    public ClassProfile(String userName) {
        this.userName = userName;
    }

    @JsonCreator
    public ClassProfile(@JsonProperty("user_name") String userName, @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName, @JsonProperty("run_data") ClassData[] runData,
            @JsonProperty("share") boolean privacy, @JsonProperty("friends") String[] friends,
            @JsonProperty("challenges") ClassChallenge challenges) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.runManager = new RunManager();

        this.runManager.setRunDatas(runData);

        this.shareMyData = privacy;

        this.friendsList = new ArrayList<String>();

        if (friends != null) {
            for (String user : friends) {
                this.friendsList.add(user);
            }
        }

        if (challenges != null)
            this.myChallenges = challenges;
        else
            this.myChallenges = new ClassChallenge();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Name: " + this.userName + "\n");
        strBuilder.append("Runs:\n");
        System.out.println("Name: " + this.userName + "\nYou have been on the following runs: ");

        ClassData[] runDatas = this.runManager.getRunDatas();
        for (ClassData x : runDatas) {
            strBuilder.append("\t" + x.toString());
        }
        strBuilder.append("Share: " + this.getPrivacy() + "\n");
        strBuilder.append("Challanges: " + this.myChallenges.toString());

        return strBuilder.toString();
    }

    // individual get methods for a Profile object
    @JsonGetter("user_name")
    public String getUserName() {
        return this.userName;
    }

    @JsonGetter("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonGetter("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonGetter("share")
    public Boolean getPrivacy() {
        return this.shareMyData;
    }

    @JsonGetter("friends")
    public String[] getFriends() {
        if (this.friendsList.size() == 0)
            return null;
        else
            return this.friendsList.toArray(new String[this.friendsList.size()]);
    }

    @JsonGetter("challenges")
    public ClassChallenge getChallenge() {
        return this.myChallenges;
    }

    @JsonGetter("run_data")
    public ClassData[] getRunDatas() {
        ClassData[] runDatas = this.runManager.getRunDatas();

        if (runDatas.length == 0)
            return null;
        else
            return runDatas;
    }

    // individual set method for Profile objects
    @JsonSetter(value = "user_name", nulls = Nulls.DEFAULT)
    public void setName(String newName) {
        this.userName = newName;
    }

    @JsonSetter("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonSetter("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonSetter("share")
    public void setPrivacy(Boolean newPrivacy) {
        this.shareMyData = newPrivacy;
    }

    @JsonSetter(value = "friends", nulls = Nulls.DEFAULT)
    public void setFriendsList(String[] newFriendsList) {
        this.friendsList.clear();

        for (String friend : newFriendsList) {
            this.friendsList.add(friend);
        }
    }

    @JsonSetter(value = "run_data", nulls = Nulls.DEFAULT)
    public void setRunDatas(ClassData[] runDatas) {
        this.runManager = new RunManager(runDatas);
    }

    @JsonIgnore
    public void addRunDatas(ClassData[] dataSet) {
        this.runManager.addRunDatas(dataSet);
    }

    @JsonSetter(value = "challenges", nulls = Nulls.DEFAULT)
    public void setChallange(ClassChallenge challenge) {
        this.myChallenges = challenge;
    }

    @JsonIgnore
    public ClassData[] getRunDatas(Date from, Date to) {
        return this.runManager.getRunDatas(from, to);
    }

    @JsonIgnore
    // return the total distance ran by the Profile user
    public double getAllRunDistance() {
        double totalDist = 0;
        ClassData[] runDatas = this.runManager.getRunDatas();
        for (ClassData runs : runDatas) {
            totalDist += runs.getDistance();
        }
        return totalDist;
    }

    @JsonIgnore
    // return the total time ran by the Profile user
    public double getAllTimeRan() {
        double totalTime = 0;
        ClassData[] runDatas = this.runManager.getRunDatas();
        for (ClassData runs : runDatas) {
            totalTime += runs.getDuration();
        }
        return totalTime;
    }

    @JsonIgnore
    // return the average inclination of runs
    public double getAverageInclination() {
        double averageIncli = 0;
        int numRuns = 0;
        ClassData[] runDatas = this.runManager.getRunDatas();
        for (ClassData runs : runDatas) {
            averageIncli += runs.getAltitude();
            numRuns++;
        }
        averageIncli /= numRuns;
        return averageIncli;
    }

    @JsonIgnore
    // return the entire array of run data
    public ClassData[] getAllRuns() {
        return this.runManager.getRunDatas();
    }

    @JsonIgnore
    public void addFriend(String newFriend) {
        this.friendsList.add(newFriend);
        JOptionPane.showMessageDialog(null, "You have added your friend!");
    }

    @JsonIgnore
    public void removeFriend(String oldFriend) {
        this.friendsList.remove(oldFriend);
        JOptionPane.showMessageDialog(null, "You just lost a friend!");
    }
}
