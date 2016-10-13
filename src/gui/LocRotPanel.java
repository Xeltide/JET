package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;
import objects.LocRot;

public class LocRotPanel extends BlockPanel {

    private LocRot locRot;
    
    private JPanel panel;
    private JTextField xCoord;
    private JTextField yCoord;
    
    LocRotPanel(LocRot locRotBlock) {
        super(BlockType.LOC_ROT.getName());
        panel = new JPanel();
        panel.setLayout(new MigLayout("insets 0, wrap 4"));
        locRot = locRotBlock;
        xCoord = new JTextField(200);
        xCoord.setText("" + locRot.x());
        yCoord = new JTextField(200);
        yCoord.setText("" + locRot.y());
        panel.add(new JLabel("Location:"), "newline, span 4");
        panel.add(new JLabel("X:"));
        panel.add(xCoord);
        panel.add(new JLabel("Y:"));
        panel.add(yCoord);
        add(panel, "newline");
    }

}
