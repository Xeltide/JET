package gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;

public abstract class JetMenu extends JMenu implements ActionListener {

    public JetMenu(String string) {
        super(string);
    }

}
