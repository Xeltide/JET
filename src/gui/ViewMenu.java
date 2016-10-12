package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewMenu extends JMenu implements ActionListener {

    public ViewMenu() {
        super("View");
        setMnemonic(KeyEvent.VK_V);
        getAccessibleContext().setAccessibleDescription("The view menu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();
    }
}
