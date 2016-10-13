package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;
import objects.VObject;

public class AddBlockFrame extends JFrame {

    JButton button;
    JList list;
    VObject selected;

    public AddBlockFrame(JButton button, VObject selected) {
        super("Add Block");
        button.setEnabled(false);
        this.selected = selected;
        setLayout(new MigLayout("insets 0, wrap 1",
                "0[grow, fill]0",
                "0[grow, fill][]0"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                button.setEnabled(true);
            }
        });
        list = new JList(BlockType.values());
        add(list, "span 2");

        JButton okButton = new JButton("Ok");
        add(okButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);
        toFront();
        pack();
        setVisible(true);
    }

    public void ok() {

    }

}
