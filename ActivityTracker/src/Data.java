package ActivityTracker.src.main.java.activitytracker;


public class Data {
    private String name;
    private int distance;
    private int duration;

    // constructor method
    public Data(String inName, int inDistance, int inDuration) {
        this.name = inName;
        this.distance = inDistance;
        this.duration = inDuration;
    }

    // retrieves all the info about a run, and prints it out
    public void getData() {
        System.out.println("Name: " + this.name + "\nDistance: " + this.distance + "\nDuration: " + this.duration);
    }

    // retrieves individual entries
    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getDuration() {
        return this.duration;
    }

    // allows to edit every entry
    public void setName(String newName) {
        this.name = newName;
    }

    public void setDuration(int newDuration) {
        this.duration = newDuration;
    }

    public void setDistance(int newDistance) {
        this.distance = newDistance;
    }

    // main method, for testing purposes
    /*
     * public static void main (String[] args) { Data run1 = new
     * Data("East Coast trail", 10,104); System.out.println(run1.getData()); }
     */
}
