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
                "0[33%, grow, fill][33%, grow, fill][33%, grow, fill]0",
                "0[50%, fill][50%, fill]0"));
        objH = new ObjectHierarchy();
        console = new Console();
        blkView = new BlockViewer();
        
        add(objH);
        add(new SceneViewer());
        add(blkView);
        add(console, "newline, span 3");
    }
}
