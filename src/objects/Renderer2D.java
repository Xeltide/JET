package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.Console;

public class Renderer2D extends Block {

    private BufferedImage img;

    Renderer2D() {
        super(BlockType.RENDERER_2D);
        img = null;
    }

    void setImg(String location) {
        try {
            img = ImageIO.read(new File(location));
        } catch (IOException e) {
            Console.log("Error loading image.");
        }
    }
}
