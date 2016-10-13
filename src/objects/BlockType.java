package objects;

/**
 * <p>BlockType.</p>
 * @author Stephen Cheng
 * @version 0.1a
 */
public enum BlockType {
    LOC_ROT("LocRot", LocRot.class),
    RENDERER_2D("Renderer2D", Renderer2D.class);

    String name;
    Class c;
    BlockType(String name, Class c) {
        this.name = name;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public static String[] getNames() {
        return null;
    }

    public Block getNewInstance() {
        Block block = null;
        try {
            block = (Block) c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return block;
    }

    @Override
    public String toString() {
        return name;
    }

}
