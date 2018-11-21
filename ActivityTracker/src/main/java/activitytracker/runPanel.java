package activitytracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runPanel extends JPanel implements ActionListener {
    public JPanel main;
    public Profile activeProfile;
    public JButton edit;
    public JButton save;
    JFrame GUI;

    public runPanel(Profile current, JFrame input) {
        activeProfile = current;
        GUI = input;
        main=this;
        int runs = activeProfile.getAllRunsList().size() + 1;
        main.setLayout(new GridLayout(runs, 0));
        viewing();
    }

    public void viewing() {
        main=this;
        main.removeAll();
        JPanel run;

        for (Data eachRun : activeProfile.getAllRunsList()) {
            run = new viewPanel(eachRun);
            main.add(run);
        }
        edit = new JButton("Edit data?");
        edit.addActionListener(this);
        main.add(edit);
        main.setVisible(true);
    }
    public void editing() {
        main=this;
        main.removeAll();
        JPanel run;

        for (Data eachRun : activeProfile.getAllRunsList()) {
            run = new editPanel(eachRun);
            main.add(run);
        }
        save = new JButton("Save changes");
        save.addActionListener(this);
        main.add(save);
        main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == edit) {
            editing();
            GUI.setVisible(true);
        }
        else if (actionEvent.getSource() == save) {
            viewing();
            GUI.setVisible(true);
        }
    }


    public class viewPanel extends JPanel {
        JPanel run;
        Data runData;

        public viewPanel(Data data) {
            run = this;
            runData = data;
            JLabel durationTXT = new JLabel("Duration: ");
            JLabel duration = new JLabel(String.valueOf(runData.getDuration()));
            JLabel distanceTXT = new JLabel("Distance: ");
            JLabel distance = new JLabel(String.valueOf(runData.getDistance()));
            JLabel altitudeTXT = new JLabel("Change in altitude: ");
            JLabel altitude = new JLabel(String.valueOf(runData.getAltitude()));
            JLabel dateTXT = new JLabel("Distance: ");
            JLabel date = new JLabel(runData.getDate());
            run.add(durationTXT);
            run.add(duration);
            run.add(distanceTXT);
            run.add(distance);
            run.add(altitudeTXT);
            run.add(altitude);
            run.add(dateTXT);
            run.add(date);
        }
    }

    public class editPanel extends JPanel {
        JPanel run;
        Data runData;

        public editPanel(Data data) {
            run = this;
            runData = data;
            run.setSize(1000, 50);
            JLabel durationTXT = new JLabel("Duration: ");
            JTextField duration = new JTextField(String.valueOf(runData.getDuration()));
            JLabel distanceTXT = new JLabel("Distance: ");
            JTextField distance = new JTextField(String.valueOf(runData.getDistance()));
            JLabel altitudeTXT = new JLabel("Change in altitude: ");
            JTextField altitude = new JTextField(String.valueOf(runData.getAltitude()));
            JLabel dateTXT = new JLabel("Distance: ");
            JTextField date = new JTextField(runData.getDate());

            run.add(durationTXT);
            run.add(duration);
            run.add(distanceTXT);
            run.add(distance);
            run.add(altitudeTXT);
            run.add(altitude);
            run.add(dateTXT);
            run.add(date);
        }
    }
}