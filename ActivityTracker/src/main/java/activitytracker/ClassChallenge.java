package activitytracker;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassChallenge {
    @JsonProperty("chall1")
    public String challenge1;

    @JsonProperty("chall2")
    public String challenge2;

    @JsonProperty("chall3")
    public String challenge3;

    // @JsonProperty("map")
    @JsonIgnore
    private Map<String, Boolean> map;

    public ClassChallenge() {
        challenge1 = null;
        challenge2 = null;
        challenge3 = null;
    }

    public ClassChallenge(String chall1, String chall2, String chall3) {
        this.challenge1 = chall1;
        this.challenge2 = chall2;
        this.challenge3 = chall3;
    }

    public void setComplete(int index, Boolean value) {
        if (index == 1) {
            map.put(challenge1, value);
        } else if (index == 2) {
            map.put(challenge2, value);
        } else if (index == 3) {
            map.put(challenge3, value);
        }
    }

    @Override
    public String toString() {
        return "Your challenges this week are:\n" + this.challenge1 + "\n" + this.challenge2 + "\n" + this.challenge3;
    }
}
