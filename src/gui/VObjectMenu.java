package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * <p>VObjectMenu.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class VObjectMenu extends JMenu implements ActionListener {

    private JMenuItem newVObjectItem;

    public VObjectMenu() {
        super("VObject");

        newVObjectItem = new JMenuItem("New VObject");
        newVObjectItem.addActionListener(this);
        add(newVObjectItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();
        if (src == newVObjectItem) {
            // add a new vobject
        }
    }

}
