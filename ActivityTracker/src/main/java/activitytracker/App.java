// package ActivityTracker.src.main.java.activitytracker;
package activitytracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    static private JFrame landing;
    static private JTextField username;
    public static void main(String[] args) {
        landing = new JFrame("Authenticator");
        landing.setSize(720,480);
        landing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        landingPanel welcome = new landingPanel();
        landing.add(welcome);

        landing.setVisible(true);
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
            System.out.println(usrInput);
            landing.setVisible(false);
            landing.dispose();
            MainApp.main();
        }

    }
}
