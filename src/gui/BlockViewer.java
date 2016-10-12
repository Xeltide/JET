package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * <p>BlockViewer.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class BlockViewer extends JPanel {

    private JPanel viewer;
    
    BlockViewer() {
        this.setLayout(new MigLayout("insets 0, wrap 1",
            "0[100%, grow, fill]0",
            "0[][grow, fill]0"));
        viewer = new JPanel(new MigLayout());
        add(new JLabel("BlockViewer"));
        add(viewer);
    }
    
}
