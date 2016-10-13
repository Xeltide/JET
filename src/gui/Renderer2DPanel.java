package gui;

import javax.swing.JTextField;

import objects.BlockType;
import objects.Renderer2D;
import objects.VObject;

public class Renderer2DPanel extends BlockPanel {

    private Renderer2D rend;
    private JTextField imgLink;

    public Renderer2DPanel(VObject obj) {
        super(BlockType.RENDERER_2D);

        imgLink = new JTextField();
        add(imgLink);
    }

}
