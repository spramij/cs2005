package activitytracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame {
    static private JFrame landing;
    static private JTextField username;
    static public List<Profile> allUsers;

    public static void main(String[] args) {
        landing = new JFrame("Authenticator");
        landing.setSize(720,480);
        landing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        landingPanel welcome = new landingPanel();
        landing.add(welcome);

        landing.setVisible(true);

//        DataManager sohilData = new DataManager();
//        Data[] sohilRuns = sohilData.loadRuns("sohil");
//        System.out.println(sohilRuns);

        Data run1 = new Data(10,10,10,"2018/1/1");
        Data run2 = new Data(12,12,12,"2011");
        Data run3 = new Data(12,12,12,"2011");

        List<Data> list1 = new ArrayList<Data>();
        list1.add(run1);
        list1.add(run2);
        list1.add(run3);
        Profile sohil = new Profile("sohil", list1,true);

        sohil.addFriend(new Profile("haha"));
        sohil.addFriend(new Profile("blabla"));

        allUsers = new ArrayList<Profile>();
        allUsers.add(sohil);
    }



    private static class landingPanel extends JPanel{
        private landingPanel(){
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
    private static class doValidation implements ActionListener {
        public void actionPerformed(ActionEvent validateUsername){
            String usrInput = username.getText();
            Boolean existent = false;
            Profile current = null;

            for (Profile i:allUsers){
                if (usrInput.equals(i.getName())){
                    existent=true;
                    current=i;
                }
            }
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
