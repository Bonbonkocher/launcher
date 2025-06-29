package de.bonbonkocher.launcher.window;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class MainWindow extends JFrame{

    private final GamePanel Panel;
    public static int windowL = 600;
    public static int windowH = 400;
     
    public MainWindow() {
        String N = " ";
        String P = ".";
        String MAJOR = "0";
        String MINOR = "0";
        String PATCH = "0";
        
        String PHASES = "TEST ";
        String SEMVER = "Version" + N + MAJOR + P + MINOR + P + PATCH;
        String GAMENAME = "Erstes Game";
        
        String VERSION = PHASES + N + SEMVER;
         
        Panel = new GamePanel();      
        Panel.setPreferredSize(new Dimension(windowL, windowH));
        registerWindowListener();
        createMenu();
        add(Panel);
        pack();
         
        setTitle(GAMENAME + N + VERSION);
        setLocationRelativeTo(getParent());
        //setLocation(50, 50);
        setResizable(false);
         
        setVisible(true);
    }
    
     
    private void registerWindowListener() {        
        addWindowListener(new WindowAdapter() {            
            @Override
            public void windowClosing(WindowEvent e) { 
                System.exit(0); 
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
                // hier werden wir später unser Spiel pausieren  
            Panel.pauseGame();              
            }
            @Override
            public void windowActivated(WindowEvent e) {
                // hier werden wir später unser Spiel wieder fortsetzen
            Panel.continueGame();
            }            
        });        
    }
    private void createMenu() {
         
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
         
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");
         
        menuBar.add(fileMenu);        
        menuBar.add(gameMenu);        
        menuBar.add(prefMenu);
        
        addFileMenuItems(fileMenu);
        addPrefMenuItems(prefMenu);
    }
     
    private void addFileMenuItems(JMenu fileMenu) {

        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener((ActionEvent e) -> {System.exit(0);
        }); 
    }
    
    private void addPrefMenuItems(JMenu prefMenu) {
         
        JMenuItem settingItem = new JMenuItem("Setting");
        prefMenu.add(settingItem);
        //new SettingWindow();
    }
     
}