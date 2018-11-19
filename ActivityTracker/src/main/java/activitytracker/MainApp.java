package activitytracker;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

public  class MainApp {
    private static MainAppMenu navbarTop;
    private static MainAppSideBar sidebar;
    private static JPanel body;
    private static JFrame GUI;
    private static int mainX;
    private static int mainY;
    private static String name;
    private static Profile activeProfile;

    private static JMenuBar sidebarMenu;

    public static void main(Profile active) {
        activeProfile = active;
        name = "Sohil";
        mainX = 720;
        mainY = 480;

        GUI = new JFrame();
        GUI.setTitle("Fitness Tracker");
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setSize(mainX, mainY);

        GUI.setLayout(new BorderLayout());

        body = new JPanel();

        navbarTop = new MainAppMenu();
        sidebar = new MainAppSideBar();

        GUI.add(sidebar, BorderLayout.WEST);
        GUI.add(body, BorderLayout.EAST);

        GUI.setJMenuBar(navbarTop);

        GUI.setVisible(true);
    }


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

    private static class MainAppSideBar extends JPanel {
        private MainAppSideBar() {
            int sidebarX = (int) Math.round(mainX * 0.2);

            JPanel sidebarPanel = this;
            sidebarPanel.setSize(sidebarX, mainY);

            sidebarPanel.setBackground(Color.black);
            JMenuBar sidebarMenu = new JMenuBar();
            sidebarMenu.setLayout(new GridLayout(3, 0));

            JMenu item1 = new JMenu("Run information");
            JMenu item2 = new JMenu("Goals and Objectives");
            JMenu item3 = new JMenu("Friends");
            sidebarMenu.add(item1);
            sidebarMenu.add(item2);
            sidebarMenu.add(item3);

            sidebarPanel.add(sidebarMenu);
        }
    }
}
