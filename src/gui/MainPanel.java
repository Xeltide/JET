package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {
    
    ObjectHierarchy objH;
    BlockViewer blkView;
    Console console;
    
    MainPanel(Dimension size) {
        setLayout(new MigLayout("insets 0, wrap 3",
                "0[20%, grow, fill][60%, grow, fill][20%, grow, fill]0",
                "0[70%, fill][30%, fill]0"));
        objH = new ObjectHierarchy();
        console = new Console();
        blkView = new BlockViewer();
        
        add(objH);
        add(new SceneViewer());
        add(blkView, "span 1 2");
        add(console, "newline, span 2");
    }
}
