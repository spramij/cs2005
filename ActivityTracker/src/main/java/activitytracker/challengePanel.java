package activitytracker;
import javax.swing.*;

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
        JPanel run;

    }
    //
    public class viewChallenges extends JPanel {
        JPanel challengePanel;
        Data runData;

        public viewChallenges() {
            challengePanel = this;
            JLabel chall1 = new JLabel("Do this for this long");
            JLabel chall2 = new JLabel("Run a lot of KMs");
            JLabel chall3 = new JLabel("Be nice to people");

            challengePanel.add(chall1);
            challengePanel.add(chall2);
            challengePanel.add(chall3);
        }
    }
}
