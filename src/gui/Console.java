package gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
        textBox.setLayout(new BoxLayout(textBox, 1));
        add(pane);
    }
    
    public static void log(String str) {
        textBox.add(new JTextArea(str));
    }
    
    public static void log(long str) {
        textBox.add(new JTextArea(str + ""));
    }
    
    public static void log(int str) {
        textBox.add(new JTextArea(str +""));
    }
}
