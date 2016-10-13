package gui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.Block;
import objects.LocRot;
import objects.VObject;

/**
 * <p>BlockViewer.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class BlockViewer extends JPanel {

    private JPanel viewer;
    private ArrayList<BlockPanel> blockPanels;

    BlockViewer() {
        blockPanels = new ArrayList<BlockPanel>();
        this.setLayout(new MigLayout("insets 0, wrap 1",
            "0[100%, grow, fill]0",
            "0[][grow, fill]0"));
        viewer = new JPanel(new MigLayout("insets 0, wrap 1"));
        add(new JLabel("BlockViewer"));
        add(viewer);
    }

    public void loadVObject(VObject vObj) {
        blockPanels.clear();
        viewer.removeAll();
        viewer.add(new JLabel(vObj.getName()));
        for (Block block : vObj.getObjBlk()) {
            BlockPanel temp = null;
            switch (block.getType()) {
            case LOC_ROT:
                temp = new LocRotPanel((LocRot) block);
                break;
            }
            blockPanels.add(temp);
            viewer.add(temp);
        }
        repaint();
    }

}
