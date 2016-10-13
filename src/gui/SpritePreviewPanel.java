package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * <p>SpritePreviewPanel.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class SpritePreviewPanel extends JPanel {

    BufferedImage img;

    public SpritePreviewPanel() {
        setLayout(new MigLayout("insets 0, wrap 1",
                "0[grow, fill]0",
                "0[][grow, fill]0"));
        add(new JLabel("Sprite Preview"));
        add(new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img == null) {
                    return;
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setBackground(PresetColors.BG_COLOR);
                g2.clearRect(0, 0, this.getWidth(), this.getHeight());
                g2.drawImage(img, 0, 0, null);
            }
        });
    }

    public void updateImage(BufferedImage img) {
        this.img = img;
    }

}
