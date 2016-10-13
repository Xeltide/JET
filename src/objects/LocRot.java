package objects;

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
    public BlockPanel getNewPanel(VObject obj) {
        return new LocRotPanel(obj);
    }
}
