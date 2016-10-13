package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;
import objects.LocRot;
import objects.VObject;

public class LocRotPanel extends BlockPanel {

    private VObject obj;
    private LocRot locRot;

    private JPanel panel;
    private JTextField xCoord;
    private JTextField yCoord;

    public LocRotPanel(VObject obj) {
        super(BlockType.LOC_ROT);
        panel = new JPanel();
        panel.setLayout(new MigLayout("insets 0, wrap 4"));
        this.obj = obj;
        locRot = (LocRot) obj.getBlockByType(BlockType.LOC_ROT);
        xCoord = new JTextField(200);
        xCoord.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    requestFocusInWindow();
                    revalidate();
                }
            }

        });
        xCoord.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                locRot = new LocRot(Float.parseFloat(xCoord.getText()), locRot.y());
                obj.setBlockByType(BlockType.LOC_ROT, locRot);
                Main.main.objH.setVObject(obj.getName(), obj);
                Main.main.repaint();
            }

        });
        xCoord.setText("" + locRot.x());
        yCoord = new JTextField(200);
        yCoord.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    requestFocusInWindow();
                    revalidate();
                }
            }

        });
        yCoord.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                locRot = new LocRot(locRot.x(), Float.parseFloat(yCoord.getText()));
                obj.setBlockByType(BlockType.LOC_ROT, locRot);
                Main.main.objH.setVObject(obj.getName(), obj);
                Main.main.repaint();
            }

        });
        yCoord.setText("" + locRot.y());
        panel.add(new JLabel("Location:"), "newline, span 4");
        panel.add(new JLabel("X:"));
        panel.add(xCoord);
        panel.add(new JLabel("Y:"));
        panel.add(yCoord);
        add(panel, "newline");
    }

}
