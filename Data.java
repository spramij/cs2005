public class Data {
    private String name;
    private int distance;
    private int duration;

    //constructor method
    public Data(String inName, int inDistance, int inDuration) {
        this.name = inName;
        this.distance = inDistance;
        this.duration = inDuration;
    }

    //retrieves all the info about a run, and prints it out
    public void getData() {
        System.out.println("Name: " + this.name + "\nDistance: " + this.distance + "\nDuration: " + this.duration);
    }

    //retrieves individual entries
    private String getName(){
        return this.name;
    }
    private int getDistance(){
        return this.distance;
    }
    private int getDuration(){
        return this.duration;
    }

    //allows to edit every entry
    private void setName(String newName) {
        this.name = newName;
    }
    private void setDuration(int newDuration) {
        this.duration = newDuration;
    }
    private void setDistance(int newDistance) {
        this.distance = newDistance;
    }

    //main method, for testing purposes
/*    public static void main (String[] args) {
        Data run1 = new Data("East Coast trail", 10,104);
        System.out.println(run1.getData());
    }*/
}
