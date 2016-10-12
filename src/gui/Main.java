package gui;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

/**
 * <p>Main.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class Main extends JFrame {

    public Main() {
        super("Java Engine Tools");
        setLayout(new MigLayout("insets 0",
                "[500]",
                "[500]"));
        setJMenuBar(new JetMenuBar());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
