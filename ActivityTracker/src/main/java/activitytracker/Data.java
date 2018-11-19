// package ActivityTracker.src.main.java.activitytracker;
package activitytracker;


public class Data {
    private String name;
    private int distance;
    private int duration;
    private int altitude;
    private String date;

    // constructor method
    public Data(int duration, int distance, int altitude, String date) {
        this.duration = duration;
        this.distance = distance;
        this.altitude = altitude;
        this.date = date;
    }

    // retrieves all the info about a run, and prints it out
    public void getData() {
        System.out.println("Name: " + this.name + "\nDistance: " + this.distance + "\nDuration: " + this.duration);
    }

    // retrieves individual entries
    public int getDuration() {
        return this.duration;
    }
    public int getDistance() {
        return this.distance;
    }
    public int getAltitude() {
        return this.altitude;
    }
    public String getDate() { return this.date; }

    // allows to edit every entry
    public void setDistance(int newDistance) {
        this.distance = newDistance;
    }
    public void setDuration(int newDuration) {
        this.duration = newDuration;
    }
    public void setAltitude(int newAltitude) {
        this.altitude = newAltitude;
    }
    public void setDate(String newDate) { this.date = newDate; }



    // [Simanto]: conversion of data to string should always be done through 'toString' method
    @Override
    public String toString()
    {
        return "Name: " + this.name + "\nDistance: " + this.distance + "\nDuration: " + this.duration;
    }

    // main method, for testing purposes
    /*
     * public static void main (String[] args) { Data run1 = new
     * Data("East Coast trail", 10,104); System.out.println(run1.getData()); }
     */
}
