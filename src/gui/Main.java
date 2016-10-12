package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * <p>Main.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class Main extends JFrame {

    JetMenuBar jmb;
    JPanel mainPanel;
    ObjectHierarchy objH;
    SceneViewer scnView;
    BlockViewer blkView;
    public Console console;

    public Main() {
        super("Java Engine Tools");
        objH = new ObjectHierarchy();
        scnView = new SceneViewer();
        blkView = new BlockViewer();
        console = new Console();
        jmb = new JetMenuBar(this);
        mainPanel = new JPanel();
        setLayout(new MigLayout("insets 0, wrap 1",
                "[grow, fill]",
                "[grow, fill]"));
        setJMenuBar(new JetMenuBar(this));
        
        mainPanel.setLayout(new MigLayout("insets 0, wrap 3",
                "0[20%, grow, fill][60%, grow, fill][20%, grow, fill]0",
                "0[70%, fill][30%, fill]0"));
        
        mainPanel.add(objH);
        mainPanel.add(scnView);
        mainPanel.add(blkView, "span 1 2");
        mainPanel.add(console, "newline, span 2");
        
        add(mainPanel);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainListener());
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    /**
     * <p>MainListener.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class MainListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            jmb.exit();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
