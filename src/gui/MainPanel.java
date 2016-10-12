package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
    
    ObjectHierarchy objH;
    Console console;
    
    MainPanel(Dimension size) {
        setLayout(new BorderLayout());
        objH = new ObjectHierarchy();
        console = new Console();
        
        add(objH, BorderLayout.LINE_START);
        add(console, BorderLayout.PAGE_END);
    }
}
