package objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import gui.BlockPanel;
import gui.LocRotPanel;

/**
 * Basic LocRot with only Location supported so far.
 *
 * @author Xeltide
 * @version 0.1a
 */
public class LocRot extends Block {

    Vector2 v;
    /**
     * Default constructor for LocRot that sets the Location
     * to a vector.
     *
     * @param vector
     */
    LocRot(Vector2 vector) {
        super(BlockType.LOC_ROT);
        v = vector;
    }
    /**
     * Overloaded constructor to take in two floats.
     *
     * @param x float of x
     * @param y float of y
     */
    public LocRot(float x, float y) {
        this(new Vector2(x, y));
    }
    /**
     * <p>
     * Overloaded constructor to default location to
     * 0,0.
     * </p>
     */
    LocRot() {
        this(new Vector2(0,0));
    }
    
    public float x() {
        return v.x();
    }
    
    public float y() {
        return v.y();
    }
    
    public Vector2 getVector() {
        return v;
    }
    
    @Override
    public void readXml(Document doc, Element e) {
        float x = Float.parseFloat(e.getElementsByTagName("x").item(0).getTextContent());
        float y = Float.parseFloat(e.getElementsByTagName("y").item(0).getTextContent());
        v = new Vector2(x, y);
    }
    
    @Override
    public void writeXml(Document doc, Element e) {
        Element blkElement = doc.createElement("Block");
        blkElement.setAttribute("type", type.toString());
        Element x = doc.createElement("x");
        x.setTextContent("" + x());
        Element y = doc.createElement("y");
        y.setTextContent("" + y());
        e.appendChild(blkElement);
        blkElement.appendChild(x);
        blkElement.appendChild(y);
    }

    @Override
    public BlockPanel getNewPanel(VObject obj) {
        return new LocRotPanel(obj);
    }
}
