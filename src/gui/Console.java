package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
/**
 * <p>
 * Creates a basic console panel using Console.log to display
 * different outputs.
 * </p>
 * 
 * @author Xeltide
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Console extends JPanel {
    
    private static JPanel textBox = new JPanel();
    private JScrollPane pane = new JScrollPane(textBox);
    
    Console() {
        this.setLayout(new MigLayout("insets 0, wrap 1",
                "0[100%, grow, fill]0",
                "0[][grow, fill]0"));
        textBox.setLayout(new MigLayout("insets 0, wrap 1",
                "0[100%, grow, fill]0",
                "0[]0"));
        add(new JLabel("Console"));
        textBox.setBackground(Color.WHITE);
        add(pane);
    }
    
    public static void log(String str) {
        JTextArea area = new JTextArea(str);
        area.setEditable(false);
        textBox.add(area);
    }
    
    public static void log(long str) {
        log("" + str);
    }
    
    public static void log(int str) {
        log("" + str);
    }
}
