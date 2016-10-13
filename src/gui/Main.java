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

    public static Main main;
    JetMenuBar jmb;
    JPanel mainPanel;
    ObjectHierarchy objH;
    RoomViewer scnView;
    BlockViewer blkView;
    public TabbedPanel tabPnl;

    public Main() {
        super("Java Engine Tools");
        Main.main = this;
        objH = new ObjectHierarchy();
        scnView = new RoomViewer();
        blkView = new BlockViewer();
        tabPnl = new TabbedPanel();
        jmb = new JetMenuBar();
        mainPanel = new JPanel();
        setLayout(new MigLayout("insets 0, wrap 1",
                "[grow, fill]",
                "[grow, fill]"));
        setJMenuBar(jmb);

        mainPanel.setLayout(new MigLayout("insets 0, wrap 3",
                "0[20%, grow, fill][60%, grow, fill][20%, grow, fill]0",
                "0[70%, fill][30%, fill]0"));

        mainPanel.add(objH);
        mainPanel.add(scnView);
        mainPanel.add(blkView, "span 1 2");
        mainPanel.add(tabPnl, "newline, span 2");

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
