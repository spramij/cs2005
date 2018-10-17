import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class fitnessTracker {
    private static JMenuBar topBar;
    private static JPanel sidebar;
    private static JPanel body;
    private static JFrame GUI;
    private static int mainX;
    private static int mainY;
    private static int sidebarX;
    private static int bodyX;
    private static JMenuBar sidebarMenu;

    public static void main(String[] args) {
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

    private static void landingPage() {
        landingMenu();
    }

    private static void landingMenu() {
        topBar.removeAll();

        JMenu loginMenu = new JMenu("Login");
        topBar.add(loginMenu);
        loginMenu.addMenuListener(new loginListener());

        GUI.setJMenuBar(topBar);
    }

    private static void mainPage() {
        mainMenu();
        GUI.setLayout(new BorderLayout());

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

        sidebar.add(sidebarMenu);
        GUI.setVisible(true);
    }

    private static void mainMenu() {
        topBar.removeAll();

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

}
