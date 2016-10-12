package gui;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import objects.VObject;

public class ObjectHierarchy extends JPanel {
    
    static ArrayList<VObject> objects = new ArrayList<VObject>();
    JPanel objectBox = new JPanel();
    static JScrollPane objectList = new JScrollPane();
    JLabel title = new JLabel("Hierarchy");
    
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
        for (VObject curObj : objects) {
            objectList.add(new JLabel(curObj.getName()));
        }
    }
}
