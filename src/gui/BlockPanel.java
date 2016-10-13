package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;

public abstract class BlockPanel extends JPanel {

    protected BlockPanel(BlockType type) {
        setLayout(new MigLayout("insets 0"));
        add(new JLabel(type.getName()));
    }

}
