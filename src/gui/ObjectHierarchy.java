package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

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

    private ArrayList<VObject> objects = new ArrayList<VObject>();
    private JPanel panelBox = new JPanel();
    private JPanel objectBox = new JPanel();
    private JScrollPane objectList = new JScrollPane(objectBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JLabel title = new JLabel("Hierarchy");
    private ArrayList<JLabel> labels;
    private ObjectHierarchyMouseAdapter adapter;

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
        adapter = new ObjectHierarchyMouseAdapter();
        add(panelBox);
        panelBox.add(title);
        panelBox.add(objectList);
        labels = new ArrayList<JLabel>();
    }

    /**
     * <p>ObjectHierarchyMouseAdapter.</p>
     * @author Stephen Cheng
     * @version 0.1a
     */
    private class ObjectHierarchyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            JLabel src = (JLabel) e.getSource();
            if (SwingUtilities.isLeftMouseButton(e)) {
                for (int i = 0; i < labels.size(); i++) {
                    if (src == labels.get(i)) {
                        labels.get(i).setOpaque(true);
                        labels.get(i).setBackground(PresetColors.SELECT_COLOR);
                        JetMenu.main.blkView.loadVObject(objects.get(i));
                    } else {
                        labels.get(i).setOpaque(false);
                        labels.get(i).setBackground(Color.WHITE);
                    }
                }
                revalidate();
            }
        }

    }

    public void newObject() {
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

    public ArrayList<VObject> getVObjects() {
        return objects;
    }

    public void addToBoxList(String name) {
        JLabel label = new JLabel(name);
        label.addMouseListener(adapter);
        objectBox.add(label);
        labels.add(label);
    }
    
    public void setVObject(String name, VObject newObj) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equals(newObj.getName())) {
                objects.set(i, newObj);
                break;
            }
        }
    }
}
