package activitytracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App extends JFrame {
    static private JFrame landing;
    static private JTextField username;
    static public List<Profile> allUsers;
    static public List<String> userlist;
    static dataImport dataImporter;

    public static void main(String[] args) throws FileNotFoundException {
        //basic JFrame containing the rest of the stuff
        landing = new JFrame("Authenticator");
        landing.setSize(720,480);
        landing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        landingPanel welcome = new landingPanel();
        landing.add(welcome);

        landing.setVisible(true);

        dataImporter = new dataImport();
        userlist = dataImporter.userlistDB();
    }

    // JPanel with welcome message and a usrInput field to enter his name
    private static class landingPanel extends JPanel{
        //
        private landingPanel() {
            JPanel welcome = this;
            welcome.setLayout(new GridLayout(2,1));
            JLabel message = new JLabel("<html> <h1>Hello! Welcome to our Activity Tracker app!</h1><br><h2> Here, you will be able to add, edit, see and remove any data from " +
                    "runs you've been on recently!</h2> <br><h4>To get started, please enter your ID</h4></html>");

            JPanel auth = new JPanel();
            JLabel id = new JLabel("Username: ");
            username = new JTextField();
            username.setPreferredSize(new Dimension(100,50));
            JButton validate = new JButton("OK");
            validate.addActionListener(new doValidation());

            auth.add(id);
            auth.add(username);
            auth.add(validate);

            welcome.add(message);
            welcome.add(auth);
        }
    }

    // input validate: checks if the username given by user is in db,
    private static class doValidation implements ActionListener {
        public void actionPerformed(ActionEvent validateUsername){
            String usrInput = username.getText();
            Boolean existent = false;
            Profile current=null;

            if (userlist.contains(usrInput)){
                existent=true;
                try {
                    ArrayList<Data> runs = dataImporter.ProfileRuns(usrInput);
                    ArrayList<String> friends = dataImporter.ProfileFriends(usrInput);
                    current = new Profile(usrInput);
                    current.setRuns(runs);
                    current.setFriendsList(friends);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

            //if yes, then gets rid of current window and creates a new one from `MainApp.java`
            if (existent){
                JOptionPane.showMessageDialog(landing, "Congratulations! You have been logged in!");
                landing.setVisible(false);
                landing.dispose();
                MainApp.main(current);
            }
            else {
                JOptionPane.showMessageDialog(landing, "Sorry! We couldn't recognize your username!");
            }
            System.out.println(usrInput);
        }
    }
}
