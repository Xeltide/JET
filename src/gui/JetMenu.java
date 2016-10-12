package gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;

public abstract class JetMenu extends JMenu implements ActionListener {

    protected static Main main;
    
    public JetMenu(String string) {
        super(string);
    }
 
    public static void setMain(Main main) {
        JetMenu.main = main;
    }
    
}
