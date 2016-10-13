package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import net.miginfocom.swing.MigLayout;
import objects.Block;
import objects.BlockType;
import objects.VObject;

public class AddBlockFrame extends JFrame {

    JButton button;
    JList list;
    VObject selected;

    public AddBlockFrame(JButton button, VObject selected) {
        super("Add Block");
        this.button = button;
        this.selected = selected;
        button.setEnabled(false);
        setLayout(new MigLayout("insets, wrap 1",
                "0[grow, fill]0",
                "0[grow, fill][]0"));
        AddBlockFrameAdapter adapter = new AddBlockFrameAdapter();
        list = new JList(BlockType.values());
        list.setSelectedIndex(0);
        list.addKeyListener(new KeyboardAdapter());
        add(list);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ok();
            }
        });
        add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        add(cancelButton);

        setUndecorated(true);
        toFront();
        pack();
        setVisible(true);
        list.requestFocus();
    }

    public void ok() {
        BlockType type = (BlockType) list.getSelectedValue();
        if (type != null) {
            Block block = type.getNewInstance();
            selected.addBlock(block);
            Main.main.blkView.loadVObject(selected);
            Main.main.blkView.revalidate();
        }
        button.setEnabled(true);
        dispose();
    }

    private class AddBlockFrameAdapter extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            button.setEnabled(true);
        }
        @Override
        public void windowClosed(WindowEvent e) {
            button.setEnabled(true);
        }
        @Override
        public void windowDeactivated(WindowEvent e) {
            dispose();
        }

    }
    
    private class KeyboardAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                ok();
                break;
            case KeyEvent.VK_ESCAPE:
                button.setEnabled(true);
                dispose();
                break;
            }
        }
    }
    
}
