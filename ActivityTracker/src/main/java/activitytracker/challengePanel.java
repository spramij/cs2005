package activitytracker;
import javax.swing.*;
import java.awt.*;

public class challengePanel extends JPanel{
        public JPanel main;
        JFrame GUI;
        public challengePanel(JFrame input) {
            GUI = input;
            main=this;

            viewing();

        }
    public void viewing() {
        main=this;
        main.removeAll();
        JPanel challengeP;
        challengeP = new challengePanel.viewChallenges();
        main.add(challengeP);
        main.setVisible(true);
    }


    //
    public class viewChallenges extends JPanel {
        JPanel challengePanel;
        Data runData;

        public viewChallenges() {

            challengePanel = this;
            challengePanel.setLayout(new BorderLayout());
            JLabel chall1 = new JLabel("1) Run For A Total Of x Mins Today");
            JLabel chall2 = new JLabel("2)Run x KMs");
            JLabel chall3 = new JLabel("3)Run To An Altitude Of x");

            challengePanel.add(chall1, BorderLayout.NORTH);
            challengePanel.add(chall2, BorderLayout.CENTER);
            challengePanel.add(chall3, BorderLayout.SOUTH);

        }
    }
}
