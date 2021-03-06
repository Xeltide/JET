package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

/**
 * <p>ViewMenu.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class ViewMenu extends JetMenu {

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
