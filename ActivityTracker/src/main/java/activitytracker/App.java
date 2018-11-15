// package ActivityTracker.src.main.java.activitytracker;
package activitytracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // creates a temporary DB as a list
        Profile sohil = new Profile("Sohil");
        Profile zahin = new Profile("Zahin");
        Profile demetri = new Profile("Demetri");
        Profile simanto = new Profile("Simanto");

        List<Profile> tempDB = new ArrayList<Profile>();
        tempDB.add(sohil);
        tempDB.add(zahin);
        tempDB.add(demetri);
        tempDB.add(simanto);
        // and adds some temporary profiles in it

        System.out.println("Hello ! Welcome to our Activity Tracker program");
        System.out.println("Here, you will be able to keep track of any runs you do in your free time!");

        System.out.println("Please, start by typing in your username: ");

        Scanner reader = new Scanner(System.in);
        String usrInput = reader.next();
        boolean present = false;

        for (Profile i : tempDB) {
            if (i.getName().equals(usrInput)) {
                present = true;
                break;
            }
        }
        if (present) {
            System.out.println("Connected!");
        } else {
            System.out.println("Your profile isnt present on our system!");
        }

        reader.close();
    }
}
