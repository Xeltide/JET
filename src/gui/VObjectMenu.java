package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import objects.LocRot;
import objects.VObject;

/**
 * <p>VObjectMenu.</p>
 */
public class VObjectMenu extends JetMenu {

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
            VObject newVObj = Main.main.objH.newObject();
            newVObj.addBlock(new LocRot());
            Console.log("VObject created");
            revalidate();
        }
    }

}
