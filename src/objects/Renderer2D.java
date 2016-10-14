package objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import gui.BlockPanel;
import gui.Console;
import gui.Renderer2DPanel;

public class Renderer2D extends Block {

    private BufferedImage img;
    private String link;
    private int order;

    Renderer2D() {
        super(BlockType.RENDERER_2D);
        link = "C:/";
        img = null;
        order = 0;
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

    public BufferedImage getBufImg() {
        return img;
    }

    public int getOrder() {
        return order;
    }
    
    public void setOrder(int ord) {
        order = ord;
    }
    
    @Override
    public void readXml(Document doc, Element e) {
        link = e.getElementsByTagName("Path").item(0).getTextContent();
        setImg(link);
//        order = Integer.parseInt(e.getElementsByTagName("Order").item(0).getTextContent());
    }
    
    @Override
    public void writeXml(Document doc, Element e) {
        Element blkElement = doc.createElement("Block");
        blkElement.setAttribute("type", type.toString());
        e.appendChild(blkElement);
        Element path = doc.createElement("Path");
        path.setTextContent(link);
        Element orderEle = doc.createElement("Order");
        orderEle.setTextContent("" + order);
        blkElement.appendChild(path);
        blkElement.appendChild(orderEle);
        e.appendChild(blkElement);
    }

    @Override
    public BlockPanel getNewPanel(VObject obj) {
        return new Renderer2DPanel(obj);
    }
}
