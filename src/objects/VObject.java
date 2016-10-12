package objects;

import java.util.ArrayList;
/**
 * <p>
 * Basic game object for the engine. Contains a list of all
 * components attached to the object and properties.
 * </p>
 * 
 * @author Xeltide
 * @version 0.1a
 */
public class VObject {
    
    private String name;
    private static BlockBuilder builder;
    
    public VObject(String name) {
        this.name = name;
        builder = new BlockBuilder();
        BlockBuilder.newBlock(new LocRot());
    }
    
    static ArrayList<Block> getObjBlk() {
        return builder.getBlocks();
    }
    
    public String getName() {
        return name;
    }
}
