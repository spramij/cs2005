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

    //sets the layoutmanager to have space at the bottom for and extra button as well as every friend
    public runPanel(Profile current, JFrame input) {
        activeProfile = current;
        GUI = input;
        main=this;
        int runs = activeProfile.getAllRunsList().size() + 1;
        main.setLayout(new GridLayout(runs, 0));
        viewing();
    }

    //makes sure the JPanel is empty, and populates it with sub-JPanels for every runData
    public void viewing() {
        main=this;
        main.removeAll();
        JPanel run;

        for (Data eachRun : activeProfile.getAllRunsList()) {
            run = new viewPanel(eachRun);
            main.add(run);
        }
        //adds an edit button at the end of the JPanel, so that we can switch every runData into an editable one
        edit = new JButton("Edit data?");
        edit.addActionListener(this);
        main.add(edit);
        main.setVisible(true);
    }
    //same thing, but uses JTextFields instead of JLabel, to edit
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

    //if the button is pressed...
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //...from edit, make the entries editable
        if (actionEvent.getSource() == edit) {
            editing();
            GUI.setVisible(true);
        }
        //...from save, save the new entries and switch back to non-editable
        else if (actionEvent.getSource() == save) {
            viewing();
            GUI.setVisible(true);
        }
    }


    //creates the individual JPanels for viewing, using JLabels
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

    //creates the individual JPanels for edit, using JTextFields
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