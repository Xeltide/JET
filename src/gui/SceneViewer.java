package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * <p>SceneViewer.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class SceneViewer extends JPanel {

    private JPanel scene;
    
    SceneViewer() {
        this.setLayout(new MigLayout("insets 0, wrap 1",
                "0[grow, fill]0",
                "0[][grow, fill]0"));
        scene = new JPanel();
        scene.setBackground(PresetColors.BG_COLOR);
        add(new JLabel("SceneViewer"));
        add(scene);
    }
    
}
