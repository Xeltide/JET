package objects;
/**
 * 2D coordinate system.
 * 
 * @author Xeltide
 * @version 0.1a
 */
public class Vector2 {
    
    private float x;
    private float y;
    /**
     * Default constructor for Vector2.
     * Sets x and y.
     * 
     * @param x float of x
     * @param y float of y
     */
    Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Return x coordinate.
     * 
     * @return float of x
     */
    private float x() {
        return this.x;
    }
    /**
     * Return y coordinate.
     * 
     * @return float of y.
     */
    private float y() {
        return this.y;
    }
}
