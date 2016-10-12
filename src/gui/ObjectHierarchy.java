package gui;

import java.util.ArrayList;
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
    private static JPanel objectBox = new JPanel();
    private static JScrollPane objectList = new JScrollPane();
    private JLabel title = new JLabel("Hierarchy");
    
    ObjectHierarchy() {
        setLayout(new BoxLayout(this, 1));
        objectBox.setLayout(new BoxLayout(objectBox, 1));
        objectList.setLayout(new BoxLayout(objectList, 1));
        add(objectBox);
        objectBox.add(title);
        objectBox.add(objectList);
    }
    
    public static void newObject() {
        String newName;
        int counter = 0;
        boolean match = false;
        newName = "VObject";
        do {
            for (VObject curObj: objects) {
                if (curObj.getName().equals(newName)) {
                    counter++;
                    newName += counter;
                    match = true;
                    break;
                } else {
                    match = false;
                }
            }
        } while (match);
        objects.add(new VObject(newName));
        refreshList();
    }
    
    public static void refreshList() {
        objectList = new JScrollPane();
        objectList.setLayout(new BoxLayout(objectList, 1));
        objectBox.add(objectList);
        for (VObject curObj : objects) {
            objectList.add(new JLabel(curObj.getName()));
        }
    }
}
