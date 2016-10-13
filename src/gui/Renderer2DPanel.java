package gui;

import javax.swing.JTextField;

import objects.BlockType;
import objects.Renderer2D;

public class Renderer2DPanel extends BlockPanel {
    
    private Renderer2D rend;
    private JTextField imgLink;
    
    protected Renderer2DPanel(Renderer2D rend) {
        super(BlockType.RENDERER_2D.getName());
        this.rend = rend;
        
        imgLink = new JTextField();
        add(imgLink);
    }

}
