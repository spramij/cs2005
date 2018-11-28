package activitytracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

public class ClassData {
    private int distance;
    private int duration;
    private float altitude;
    private Date date;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    // constructor method
    public ClassData(int duration, int distance, float altitude, Date date) {
        this.duration = duration;
        this.distance = distance;
        this.altitude = altitude;
        this.date = date;
    }

    @JsonGetter("duration")
    public int getDuration() {
        return this.duration;
    }

    @JsonGetter("distance")
    public int getDistance() {
        return this.distance;
    }

    @JsonGetter("altitude")
    public float getAltitude() {
        return this.altitude;
    }

    @JsonGetter("date")
    public String getDate() {
        return this.formatter.format(this.date);
    }

    @JsonSetter(value = "distance", nulls = Nulls.SKIP)
    public void setDistance(int newDistance) {
        this.distance = newDistance;
    }

    @JsonSetter(value = "duration", nulls = Nulls.SKIP)
    public void setDuration(int newDuration) {
        this.duration = newDuration;
    }

    @JsonSetter(value = "altitude", nulls = Nulls.SKIP)
    public void setAltitude(float newAltitude) {
        this.altitude = newAltitude;
    }

    @JsonSetter(value = "date", nulls = Nulls.SKIP)
    public void setDate(String newDate) {
        try {
            this.date = formatter.parse(newDate);
        } catch (ParseException ex) {
            System.err.println("Error is parsing date: " + ex.toString());
        }
    }

    // [Simanto]: conversion of data to string should always be done through 'toString' method
    @Override
    public String toString() {
        return "Distance: " + this.distance + "\nDuration: " + this.duration;
    }

    // main method, for testing purposes
    /*
     * public static void main (String[] args) { Data run1 = new
     * Data("East Coast trail", 10,104); System.out.println(run1.getData()); }
     */
}
