package activitytracker;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runPanel extends JPanel  {
    private JPanel main;
    private Profile activeProfile;
    JButton edit;
    JButton save;


    public runPanel(Profile current /*, String action*/) {
        activeProfile = current;
        main = this;
        int runs = current.getAllRunsList().size();
        main.setLayout(new GridLayout(runs, 0));
        System.out.println("heyyy");
        JPanel run;

//        if (action.equals("view")) {

        for (Data eachRun : activeProfile.getAllRunsList()) {
            run = new viewPanel(eachRun);
            main.add(run);
        }
//        } else {
//            for (Data eachRun : activeProfile.getAllRunsList()) {
//                run = new editPanel(eachRun);
//                main.add(run);
//            }
//        }
    }


    public class viewPanel extends JPanel /*implements ActionListener*/ {
        JPanel run;
        Data runData;

        private viewPanel(Data data) {
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
//            edit = new JButton("Edit ?");
//            edit.addActionListener(this);

            run.add(durationTXT);
            run.add(duration);
            run.add(distanceTXT);
            run.add(distance);
            run.add(altitudeTXT);
            run.add(altitude);
            run.add(dateTXT);
            run.add(date);
//            run.add(edit);
        }

//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            run = new editPanel(runData);
//        }
    }

    public class editPanel extends JPanel /*implements ActionListener*/ {
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
//            save = new JButton("Save your changes");

            run.add(durationTXT);
            run.add(duration);
            run.add(distanceTXT);
            run.add(distance);
            run.add(altitudeTXT);
            run.add(altitude);
            run.add(dateTXT);
            run.add(date);
//            run.add(save);
        }

//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            run = new viewPanel(runData);
//        }
    }

}