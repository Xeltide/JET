package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import objects.BlockType;
import objects.LocRot;
import objects.Renderer2D;
import objects.VObject;

/**
 * <p>SceneViewer.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public class RoomViewer extends JPanel {

    int radius = 5;
    private JPanel room;
    private int viewHeight = 200;
    private int viewWidth;
    private Point cameraPos = new Point(0, 0);
    float screenToWorldRatio;
    
    RoomViewer() {
        this.setLayout(new MigLayout("insets 0, wrap 1",
                "0[grow, fill]0",
                "0[][grow, fill]0"));
        add(new JLabel("RoomViewer"));
        viewWidth = viewHeight * room.getWidth() / room.getHeight();
        screenToWorldRatio = 1.0f * room.getWidth() / viewWidth;
        room = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                g.clearRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                for (VObject vObj : Main.main.objH.getVObjects()) {
                    LocRot loc = (LocRot) vObj.getBlockByType(BlockType.LOC_ROT);
                    g.setColor(Color.DARK_GRAY);
                    Renderer2D ren = (Renderer2D) vObj.getBlockByType(BlockType.RENDERER_2D);
                    if (ren != null && ren.getBufImg() != null) {
                        g.drawImage(ren.getBufImg(), (int)loc.x(), (int)loc.y(), null);
                    } else {
                        g.fillOval((int)loc.x() - radius, (int)loc.y() - radius, 2*radius, 2*radius);
                    }

                }
            }
        };
        room.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                viewWidth = viewHeight * room.getWidth() / room.getHeight();
                repaint();
            }
        });
        room.setBackground(PresetColors.BG_COLOR);
        add(room);
    }
    
    private Point worldToScreenCoordinates(Point p) {
        int x = cameraPos.x + viewWidth / 2 + p.x;
        int y = cameraPos.y + viewHeight / 2 + p.y;
        x *= screenToWorldRatio;
        y *= screenToWorldRatio;
        return new Point(x, y);
    }

}
