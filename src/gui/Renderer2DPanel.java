package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;
import objects.Renderer2D;
import objects.VObject;

public class Renderer2DPanel extends BlockPanel {

    private VObject obj;
    private Renderer2D rend;

    private JPanel panel;
    private JTextField imgLink;
    private JTextField order;

    public Renderer2DPanel(VObject obj) {
        super(BlockType.RENDERER_2D);
        panel = new JPanel();
        panel.setLayout(new MigLayout("insets 0, wrap 3",
                "0[][]0[]0",
                "0[grow, fill]0"));
        this.obj = obj;
        rend = (Renderer2D) obj.getBlockByType(BlockType.RENDERER_2D);
        imgLink = new JTextField(200);
        imgLink.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    requestFocusInWindow();
                    revalidate();
                }
            }
        });
        imgLink.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                changeImage();
            }
        });
        order = new JTextField(200);
        order.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    requestFocusInWindow();
                    revalidate();
                }
            }
        });
        order.addFocusListener(new FocusAdapter() {
            
            @Override
            public void focusLost(FocusEvent e) {
                rend.setOrder(Integer.parseInt(order.getText()));
                obj.setBlockByType(BlockType.RENDERER_2D, rend);
                JetMenu.main.objH.setVObject(obj.getName(), obj);
            }
        });
        order.setText("" + rend.getOrder());
        imgLink.setText(rend.getImg());
        panel.add(new JLabel("File:"));
        panel.add(imgLink);
        JButton browse = new JButton("Browse");
        browse.addActionListener(new BrowserListener());
        panel.add(browse);
        panel.add(new JLabel("Order:"));
        panel.add(order);
        add(panel, "newline");
    }

    private void changeImage() {
        rend.setImg(imgLink.getText());
        obj.setBlockByType(BlockType.RENDERER_2D, rend);
        JetMenu.main.objH.setVObject(obj.getName(), obj);
        JetMenu.main.blkView.loadVObject(obj);
    }

    private class BrowserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
            chooser.setFileFilter(filter);
            int v = chooser.showOpenDialog(Renderer2DPanel.this);
            if (v == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                imgLink.setText(file.getAbsolutePath());
                changeImage();
            }
        }

    }

}
