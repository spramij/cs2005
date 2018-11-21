package activitytracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataImport {

    public List<String> userlistDB() throws FileNotFoundException {

        List<String> userlist = new ArrayList<>();

        Scanner readfile = new Scanner(new File("userlist.csv"));

        readfile.useDelimiter(",");
        while (readfile.hasNext()) {
            userlist.add(readfile.next());
        }
        return userlist;
    }

    public ArrayList<Data> ProfileRuns(String name) throws FileNotFoundException {
//    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Data> runs = new ArrayList<Data>();
        Scanner readProfileRuns = new Scanner(new File(name+"_runs.csv"));
        readProfileRuns.useDelimiter(",");
        Data run;
        while (readProfileRuns.hasNextLine()) {
            int test1 = Integer.parseInt(readProfileRuns.next());
            int test2 = Integer.parseInt(readProfileRuns.next());
            float test3 = Float.parseFloat(readProfileRuns.next());
            String test4 = readProfileRuns.next();

            run = new Data(test1,test2,test3,test4);
            runs.add(run);
            readProfileRuns.nextLine();
        }

        return runs;
    }
    public ArrayList<String> ProfileFriends(String name) throws FileNotFoundException {
        ArrayList<String> friends = new ArrayList<String>();
        Scanner readProfileFriends = new Scanner(new File(name+"_friends.csv"));
        readProfileFriends.useDelimiter(",");
        String friend;
        while (readProfileFriends.hasNext()) {
            friend=readProfileFriends.next();
            friends.add(friend);
        }
        return friends;
    }
}
