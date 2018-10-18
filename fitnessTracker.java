//It should be noted that this is a dummy version, and the code is greatly redundant where many things
//should be handled differently.


import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;


public class fitnessTracker {
    //creates global vars
    private static JMenuBar topBar;
    private static JPanel sidebar;
    private static JPanel body;
    private static JFrame GUI;
    private static int mainX;
    private static int mainY;
    private static int sidebarX;
    private static int bodyX;

    //main function,
    public static void main(String[] args) {
        //creates the window with defaults behavior, sets size...
        GUI = new JFrame();
        topBar = new JMenuBar();

        mainX = 720;
        mainY = 480;
        sidebarX = (int) Math.round(mainX * 0.2);
        bodyX = (int) Math.round(mainX * 0.8);

        GUI.setTitle("Fitness Tracker");
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setSize(mainX, mainY);

        landingPage();

        GUI.setVisible(true);
    }

    //generates the content of the window
    private static void landingPage() {
        //window is empty, simply calls the navbar constructor
        landingMenu();
    }

    //generates the top navbar for the landing page
    private static void landingMenu() {
        //starts from blank slate
        topBar.removeAll();

        //adds single element
        JMenu loginMenu = new JMenu("Login");
        topBar.add(loginMenu);
        //and its listener
        loginMenu.addMenuListener(new loginListener());

        GUI.setJMenuBar(topBar);
    }

    //main page constructor, once user has logged in
    private static void mainPage() {
        //calls the new top navbar constructor
        mainMenu();
        GUI.setLayout(new BorderLayout());

        //creates the sidebar navbar
        sidebar = new JPanel();
        body = new JPanel();

        sidebar.setBackground(Color.black);

        GUI.add(sidebar, BorderLayout.WEST);
        GUI.add(body);

        JMenuBar sidebarMenu = new JMenuBar();
        sidebarMenu.setLayout(new GridLayout(3, 0));

        JMenu item1 = new JMenu("Stats");
        JMenu item2 = new JMenu("Runs");
        JMenu item3 = new JMenu("Friends");
        sidebarMenu.add(item1);
        sidebarMenu.add(item2);
        sidebarMenu.add(item3);

        //along with its event listeners
        item1.addMenuListener(new statListener());
        item2.addMenuListener(new runListener());
        item3.addMenuListener(new friendListener());

        sidebar.add(sidebarMenu);
        GUI.setVisible(true);
    }

    private static void mainMenu() {
        topBar.removeAll();

        //main top navbar creator

        JMenu profileMenu = new JMenu("Profile");
        JMenu logoutMenu = new JMenu("Logout");

        JMenuItem persoData = new JMenuItem("Personal information");
        JMenuItem confidentiality = new JMenuItem("Confidentiality");
        profileMenu.add(persoData);
        profileMenu.add(confidentiality);

        logoutMenu.addMenuListener(new logoutListener());

        topBar.add(profileMenu);
        topBar.add(logoutMenu);
        GUI.setJMenuBar(topBar);
    }

    //changes the body JPanel to have the JTable of data it should
    private static void runPage() {
        mainMenu();
        body.removeAll();
        body.setLayout(new FlowLayout());

        String[] columnName = {"Name", "Distance", "Duration", "Calories burnt"};

        Object[][] data = {
                {"East Cosat Trail", "2km", "30min", "100"},
                {"Trail", "6km", "3h20", "320"}
        };

        JTable runData = new JTable(data, columnName);
        JScrollPane statdataPane = new JScrollPane(runData);
        runData.setFillsViewportHeight(true);

        body.add(statdataPane);
        GUI.add(body);
        GUI.setVisible(true);


    }

    private static void statPage() {
        mainMenu();
        body.removeAll();

        String[] columnName = {"Calories burnt", "Heart Rate", "Pace"};

        Object[][] data = {
                {"200", "120", "2km/h"},
                {"10", "0.1km", "0.5km/h"}
        };

        JTable runData = new JTable(data, columnName);

        JScrollPane rundataPane = new JScrollPane(runData);
        runData.setFillsViewportHeight(true);

        body.add(rundataPane);
        GUI.add(body);

        GUI.setVisible(true);
    }

    private static void friendPage() {
        mainMenu();
        body.removeAll();

        String[] columnName = {"Name", "Added?"};

        Object[][] data = {
                {"Sohil", "Friend"},
                {"Demetri", "not friend"},
                {"Simanto", "not friend"},
                {"Zahin", "friend"},
        };

        JTable friendData = new JTable(data, columnName);

        JScrollPane friendataPane = new JScrollPane(friendData);
        friendData.setFillsViewportHeight(true);

        body.add(friendataPane);
        GUI.add(body);
        GUI.setVisible(true);
    }

//    private static void persoPage() {
//        GUI.removeAll();
//
////        String[] columnName = {"First Name", "Last Name", "Age", "Address", "wtvr"};
////
////        Object[][] data = {
////                {"Sohil", "Pramij","19","MUN","idk"}};
////
////        JTable personalData = new JTable(data, columnName);
////
////        JScrollPane personaldataPane = new JScrollPane(personalData);
////        personalData.setFillsViewportHeight(true);
////
////        GUI.add(personaldataPane);
//        GUI.setVisible(true);
//    }
//    private static void confidPage() {
//        GUI.removeAll();
//
//
//    }

    //event listeners that triggers different actions
    static class loginListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            JOptionPane.showInputDialog("Enter ID: ");
            mainPage();
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }

    static class logoutListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            JOptionPane.showMessageDialog(topBar.getParent(), "You have been disconnected");
            landingPage();
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }

    static class statListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            statPage();
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }

    static class runListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            runPage();
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }

    static class friendListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            friendPage();
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }
}
