package activitytracker;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ClassChallenge {
    String challenge1;
    String challenge2;
    String challenge3;

    List<String> taskList;

    public ClassChallenge(String chall1, String chall2, String chall3) {
        this.challenge1 = chall1;
        this.challenge2 = chall2;
        this.challenge3 = chall3;
    }

    public ClassChallenge(String[] tasks) {
        setChallenge(tasks);
    }

    @JsonGetter("challanges")
    public String[] getChallenges() {
        return taskList.toArray(new String[taskList.size()]);
    }

    @JsonSetter("challanges")
    public void setChallenge(String[] tasks) {
        taskList = new ArrayList<String>();

        for (int i = 0; i < tasks.length; i++) {
            this.taskList.add(tasks[i]);
        }
    }

    @Override
    public String toString() {
        return "Your challenges are this week are:\n" + this.challenge1 + "\n" + this.challenge2 + "\n"
        + this.challenge3;
    }
}
