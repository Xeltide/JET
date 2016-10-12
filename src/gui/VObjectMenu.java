package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
        newVObjectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        newVObjectItem.addActionListener(this);
        add(newVObjectItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();
        if (src == newVObjectItem) {
            ObjectHierarchy.newObject();
            Console.log("VObject created");
            revalidate();
        }
    }

}
