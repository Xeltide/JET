package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.BlockPanel;
import gui.Console;
import gui.Main;
import gui.Renderer2DPanel;

public class Renderer2D extends Block {

    private BufferedImage img;
    private String link;

    Renderer2D() {
        super(BlockType.RENDERER_2D);
        link = "C:/";
        img = null;
    }

    public void setImg(String location) {
        link = location;
        try {
            img = ImageIO.read(new File(link));
        } catch (IOException e) {
            img = null;
            Console.log("Error loading image.");
        }
    }
    
    public String getImg() {
        return link;
    }

    public BufferedImage getImage() {
        try {
            return ImageIO.read(Main.class.getClassLoader().getResourceAsStream("./images/chiaki.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
//        return img;
    }

    @Override
    public BlockPanel getNewPanel(VObject obj) {
        return new Renderer2DPanel(obj);
    }
}
