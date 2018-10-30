import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<Data> runData;
    private boolean shareMyData;

    //constructor method
    public Profile(String inName,List inRuns,Boolean inPrivacy){
        this.name=inName;
        this.runData=inRuns;
        this.shareMyData = inPrivacy;
    }

    //prints out all the info from the profile
    public void getProfile(){
        System.out.println("Name: "+this.name + "\nYou have been on the following runs: ");
        for (Data x:this.runData){
            x.getData();
            System.out.println();
        }
    }

    //individual get methods for a Profile object
    public String getName(){
        return this.name;
    }
    public void getRunData(){
        for (Data x:this.runData) {
            x.getData();
        }
    }
    public Boolean getPrivacy(){
        return this.shareMyData;
    }

    //individual set method for Profile objects
    public void setName(String newName){
        this.name=newName;
    }
    public void setRuns(List<Data> newRuns){
        this.runData=newRuns;
    }
    public void setPrivacy(Boolean newPrivacy){
        this.shareMyData=newPrivacy;
    }

    //main method, for testing purposes
    public static void main(String[] args){
        Data run1 = new Data("East Coast Trail",10,104);
        Data run2 = new Data("somethingelse Trail",7,73);

        List<Data> list1 = new ArrayList<Data>();
        list1.add(run1);
        list1.add(run2);

        Profile profile1 = new Profile("Sohil",list1,true);

        profile1.getProfile();
    }
}
