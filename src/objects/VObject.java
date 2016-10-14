package objects;

import java.util.ArrayList;
/**
 * <p>
 * Basic game object for the engine. Contains a list of all
 * components attached to the object and properties.
 * </p>
 *
 * @author Xeltide
 * @version 0.2a
 */
public class VObject {

    private String name;
    private BlockBuilder builder;
    /**
     * <p>
     * VObject constructor sets name and creates a BlockBuilder for each
     * object. Every object is given a LocRot block by default.
     * </p>
     *
     * @param name of the object
     */
    public VObject(String name) {
        this.name = name;
        builder = new BlockBuilder();
//        builder.newBlock(new LocRot());
    }
    /**
     * Returns the ArrayList of blocks attached to the VObject.
     *
     * @return ArrayList<Block>
     */
    public ArrayList<Block> getObjBlk() {
        return builder.getBlocks();
    }
    /**
     * Returns the name of the object.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the VObject.
     *
     * @param newName String name
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * Adds new block to the BlockBuilder.
     *
     * @param newBlock Block to add
     */
    public void addBlock(Block newBlock) {
        builder.newBlock(newBlock);
    }
    /**
     * Returns the block base on enum type.
     *
     * @param type enum of accepted types
     * @return Block matching type
     */
    public Block getBlockByType(BlockType type) {
        return builder.getBlockByType(type);
    }

    public void setBlockByType(BlockType type, Block newBlock) {
        builder.setBlockByType(type, newBlock);
    }
}
