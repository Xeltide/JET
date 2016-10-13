package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.Block;
import objects.VObject;

/**
 * <p>BlockViewer.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class BlockViewer extends JPanel {

    private JPanel viewer;
    private ArrayList<BlockPanel> blockPanels;
    private JButton addBlockButton;
    private VObject selectedObject;

    BlockViewer() {
        blockPanels = new ArrayList<BlockPanel>();
        this.setLayout(new MigLayout("insets 0, wrap 1",
            "0[100%, grow, fill]0",
            "0[][grow, fill]0"));
        blockPanels = new ArrayList<BlockPanel>();
        viewer = new JPanel(new MigLayout("insets 0, wrap 1"));
        add(new JLabel("BlockViewer"));
        add(viewer);

        addBlockButton = new JButton("Add Block");
        addBlockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (selectedObject == null) {
                    return;
                }
//                BlockType type = (BlockType) JOptionPane.showInputDialog(null, "Choose one", "Add Component", JOptionPane.PLAIN_MESSAGE, null, BlockType.values(), 1);
//                if (type == null) {
//                    return;
//                }
//                Block block = type.getNewInstance();
//                selectedObject.addBlock(block);
//                loadVObject(selectedObject);
//                revalidate();
                new AddBlockFrame(addBlockButton, selectedObject);
            }
        });
    }

    public void loadVObject(VObject vObj) {
        selectedObject = vObj;
        blockPanels.clear();
        viewer.removeAll();
        JLabel name = new JLabel(vObj.getName());
        viewer.add(name);
        for (Block block : vObj.getObjBlk()) {
            BlockPanel temp = block.getNewPanel();
            blockPanels.add(temp);
            viewer.add(temp);
        }
        viewer.add(addBlockButton, "x 0.5al, grow 0 0");
        repaint();
    }

}
