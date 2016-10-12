package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import objects.VObject;
/**
 * <p>
 * Panel for object hierarchy. Deals with creating new objects with
 * unique namespaces.
 * </p>
 * 
 * @author Xeltide
 * @version 0.1a
 */
@SuppressWarnings("serial")
public class ObjectHierarchy extends JPanel {
    
    private static ArrayList<VObject> objects = new ArrayList<VObject>();
    private JPanel panelBox = new JPanel();
    private static JPanel objectBox = new JPanel();
    private JScrollPane objectList = new JScrollPane(objectBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JLabel title = new JLabel("Hierarchy");
    
    ObjectHierarchy() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new MigLayout("insets 0, wrap 1",
                "0[100%, grow, fill]0",
                "0[fill, grow]0"));
        panelBox.setLayout(new MigLayout("insets 0, wrap 1",
                "0[100%, grow, fill]0",
                "0[0][100%, grow, fill]0"));
        objectBox.setLayout(new MigLayout("insets 0, wrap 1",
                "0[grow, fill]0",
                "0[0]0"));
        objectBox.setBackground(Color.WHITE);
        add(panelBox);
        panelBox.add(title);
        panelBox.add(objectList);
    }
    
    public static void newObject() {
        String newName;
        int counter = 0;
        boolean match = false;
        String baseName = "VObject";
        newName = "VObject";
        do {
            for (VObject curObj: objects) {
                if (curObj.getName().equals(newName)) {
                    counter++;
                    newName = baseName + counter;
                    match = true;
                    break;
                } else {
                    match = false;
                }
            }
        } while (match);
        objects.add(new VObject(newName));
        addToBoxList(newName);
    }
    
    public static void addToBoxList(String name) {
        objectBox.add(new JLabel(name));
    }
}
