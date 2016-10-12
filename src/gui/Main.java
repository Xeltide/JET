package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

/**
 * <p>Main.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class Main extends JFrame {

    JetMenuBar jmb;

    public Main() {
        super("Java Engine Tools");
        jmb = new JetMenuBar();
        setLayout(new MigLayout("insets 0",
                "[500]",
                "[500]"));
        setJMenuBar(new JetMenuBar());

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainListener());
        pack();
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
        new Main();
    }

}
