package activitytracker;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private static MainAppMenu navbarTop;
    private static MainAppSideBar sidebar;
    private static JPanel body;
    private static JFrame GUI;
    private static int mainX;
    private static int mainY;
    private static String name;
    private static Profile activeProfile;

    private static JMenuBar sidebarMenu;

    // takes Profile from super(), to know what the current active profile is
    public static void main(Profile active) {
        //basic JFrame, calls resepctive methods to populate
        activeProfile = active;
        name = "Sohil";
        mainX = 720;
        mainY = 480;

        GUI = new JFrame();
        GUI.setTitle("Fitness Tracker");
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setSize(mainX, mainY);

        GUI.setLayout(new BorderLayout());

        navbarTop = new MainAppMenu();
        sidebar = new MainAppSideBar();

        GUI.add(sidebar, BorderLayout.WEST);
        GUI.setJMenuBar(navbarTop);

        GUI.setVisible(true);
    }

    // the navbar from up top
    //TO-DO: add ActionListeners for every action
    private static class MainAppMenu extends JMenuBar {
        private MainAppMenu() {
            JMenuBar navbarTop = this;
            JMenu username = new JMenu(name);
            JMenu confidentiality = new JMenu("Confidentiality");
            JMenu dataMngmnt = new JMenu("Import data");

            JMenu logout = new JMenu("Logout");

            navbarTop.add(username);
            navbarTop.add(confidentiality);
            navbarTop.add(dataMngmnt);
            navbarTop.add(logout);
        }
    }

    // creates the side panel, using buttons
    private static class MainAppSideBar extends JPanel implements ActionListener {
        JButton item1;
        JButton item2;
        JButton item3;
        private MainAppSideBar() {
            int sidebarX = (int) Math.round(mainX * 0.2);

            JPanel sidebarPanel = this;
            sidebarPanel.setSize(sidebarX, mainY);

            sidebarPanel.setBackground(Color.black);
            JMenuBar sidebarMenu = new JMenuBar();
            sidebarMenu.setLayout(new GridLayout(3, 0));

            item1 = new JButton("Run information");
            item2 = new JButton("Goals and Objectives");
            item3 = new JButton("Friends");

            item1.addActionListener(this);
            item2.addActionListener(this);
            item3.addActionListener(this);
            sidebarMenu.add(item1);
            sidebarMenu.add(item2);
            sidebarMenu.add(item3);

            sidebarPanel.add(sidebarMenu);
        }

        // init setup for ActionListeners
        public void actionPerformed(ActionEvent actionEvent) {
            //creates the `body` JPanel according to user input
            if (actionEvent.getSource() == item1) {
                //passes GUI as a parameter as we need to refer to it to update the JFrame
                body = new runPanel(activeProfile, GUI);
            }
//            else if (actionEvent.getSource() == item2) {
//                body = new goalsPanel();
//            }
            else if (actionEvent.getSource() == item3) {
                body = new friendPanel(activeProfile, GUI);
            }

            GUI.add(body);
            GUI.setVisible(true);
        }
    }
}
