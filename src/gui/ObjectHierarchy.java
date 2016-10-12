package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private static JPanel panelBox = new JPanel();
    private static JPanel objectBox = new JPanel();
    private static JScrollPane objectList = new JScrollPane(objectBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JLabel title = new JLabel("Hierarchy");
    
    ObjectHierarchy() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        objectBox.setLayout(new BoxLayout(objectBox, 1));
        setPreferredSize(new Dimension(150, 3000));
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
    
    public static void refreshList() {
        objectList = new JScrollPane(objectBox);
        panelBox.add(objectList);
        for (VObject curObj : objects) {
            objectBox.add(new JLabel(curObj.getName()));
        }
    }
}
