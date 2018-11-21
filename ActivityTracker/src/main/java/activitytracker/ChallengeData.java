package activitytracker;

import java.util.Random;

public class ChallengeData {
    private int distance;
    private int duration;
    private double altitude;
    Random rand = new Random();

    public ChallengeData(int dist, int dur, double alt) {
        this.distance = dist;
        this.duration = dur;
        this.altitude = alt;
    }
    public int distChallenge() {
        if (distance > 5) {
            this.distance = distance + rand.nextInt(11) - 5;
        }
        else if(distance > 0){
            this.distance = distance + rand.nextInt(10);
        }
        else {
            this.distance = rand.nextInt(10);
        }
        return distance;
    }
    public int durChallenge(){

        if (duration > 15){
            this.duration= duration + rand.nextInt(31)-1;

        }
        else if (duration > 0) {
            this.duration = duration +rand.nextInt(30);
        }
        else {
            this.duration = rand.nextInt(30);

        }
        return duration;
    }
}
