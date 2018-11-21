package activitytracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class friendPanel extends JPanel {
    public JPanel main;
    public Profile activeProfile;
    public JButton edit;
    public JButton save;
    JFrame GUI;

    public friendPanel(Profile current, JFrame input) {
        activeProfile = current;
        int friends = activeProfile.getAllFriendsList().size() + 1;

        friendList();
        main.setLayout(new GridLayout(friends, 0));
        GUI=input;

    }

    public void friendList() {
        main=this;
        main.removeAll();
        JPanel friend;

        for (Profile eachFriend:activeProfile.getAllFriendsList()) {
            friend = new viewFriends(eachFriend);
            main.add(friend);
        }

        main.setVisible(true);
    }


    private class viewFriends extends JPanel {
        JPanel friendPanel;
        Profile friend;
        public viewFriends(Profile i) {
            friend = i;
            friendPanel = this;
            JLabel name = new JLabel(friend.getName());
            JButton info = new JButton("View runs");
            friendPanel.add(name);
            friendPanel.add(info);
        }
    }
}