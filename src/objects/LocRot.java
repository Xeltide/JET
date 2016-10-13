package objects;
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
    LocRot(float x, float y) {
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
}
