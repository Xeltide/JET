package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class BlockPanel extends JPanel {

    protected BlockPanel(String name) {
        setLayout(new MigLayout("insets 0"));
        add(new JLabel(name));
    }

}
