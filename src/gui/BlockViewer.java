package gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.Block;
import objects.Renderer2D;
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
    private SpritePreviewPanel sprite;

    BlockViewer() {
        blockPanels = new ArrayList<BlockPanel>();
        this.setLayout(new MigLayout("insets 0, wrap 1",
            "0[100%, grow, fill]0",
            "0[][grow, fill]0"));
        blockPanels = new ArrayList<BlockPanel>();
        viewer = new JPanel(new MigLayout("insets 0, wrap 1"));
        viewer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                viewer.requestFocus();
                revalidate();
            }
        });
        add(new JLabel("BlockViewer"));
        add(viewer);

        sprite = new SpritePreviewPanel();
        sprite.setVisible(false);
        add(sprite);

        addBlockButton = new JButton("Add Block");
        addBlockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (selectedObject == null) {
                    return;
                }
                AddBlockFrame frame = new AddBlockFrame(addBlockButton, selectedObject);
                Point pos = addBlockButton.getLocationOnScreen();
                frame.setLocation(pos);
            }
        });
    }

    public void loadVObject(VObject vObj) {
        selectedObject = vObj;
        blockPanels.clear();
        viewer.removeAll();
        JLabel name = new JLabel(vObj.getName());
        viewer.add(name);
        sprite.setVisible(false);
        for (Block block : vObj.getObjBlk()) {
            BlockPanel temp = block.getNewPanel(vObj);
            blockPanels.add(temp);
            viewer.add(temp);
            if (block instanceof Renderer2D) {
                Renderer2D tmp = (Renderer2D) block;
                sprite.updateImage(tmp.getBufImg());
                sprite.setVisible(true);
            }
        }
        viewer.add(addBlockButton, "x 0.5al, grow 0 0");
        Main.main.repaint();
    }

}
