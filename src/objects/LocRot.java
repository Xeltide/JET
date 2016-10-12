package objects;


public class LocRot extends Block {

    Vector2 v;
    
    LocRot(Vector2 vector) {
        super("LocRot");
        v = vector;
    }

    LocRot(float x, float y) {
        this(new Vector2(x, y));
    }
    
    LocRot() {
        this(new Vector2(0,0));
    }
}
