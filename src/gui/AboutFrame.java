package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;

/**
 * <p>AboutFrame.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class AboutFrame extends JFrame {

    private JTextPane text;

    public AboutFrame() {
        super("About");
        setLayout(new MigLayout("insets 0, wrap 1",
                "0[300]0",
                "0[0]0"));
        JLabel title = new JLabel("Java Engine Tools");
        add(title, "x 0.5al");

        text = new JTextPane();
        text.setText("Version 0.1a\n\n"
                + "Contributors\n"
                + "CST Students\n\n"
                + "\u00A9 2016");
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        text.setEditable(false);
        text.setOpaque(false);
        add(text, "x 0.5al");
        pack();
        setVisible(true);
        setResizable(false);
    }

}
