package gui;

import javax.swing.JMenu;

public abstract class JetMenu extends JMenu {

    protected static Main main;
    
    public JetMenu(String string) {
        super(string);
    }
 
    public static void setMain(Main main) {
        JetMenu.main = main;
    }
    
}
