package objects;

import java.util.ArrayList;

import gui.Console;
/**
 * Every VObject has a BlockBuilder to organize all of the Blocks
 * attached to an object.
 *
 * @author Xeltide
 * @version 0.2a
 */
public class BlockBuilder {

    private ArrayList<Block> blocks;
    /**
     * Default constructor to create empty list
     * of blocks.
     */
    BlockBuilder() {
        blocks = new ArrayList<Block>();
    }
    /**
     * Returns the Block at the specified index.
     *
     * @param index int of location
     * @return Block at index
     */
    public Block getBlockAt(int index) {
        return blocks.get(index);
    }
    /**
     * Returns the entire BlockBuilder.
     *
     * @return ArrayList<Block>
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    
    public Block getBlockByType(BlockType type) {
        for (Block block : blocks) {
            if (block.getType() == type) {
                return block;
            }
        }
        System.err.println("VObject does not contain this Block.");
        return null;
    }
    
    public void setBlockByType(BlockType type, Block newBlock) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getType() == type) {
                blocks.set(i, newBlock);
            }
        }
    }
    /**
     * <p>
     * Adds a new Block to the BlockBuilder if the
     * Block is not already attached.
     * </p>
     *
     * @param newBlock Block to add
     */
    public void newBlock(Block newBlock) {
        boolean exists = false;
        for (Block curBlock : blocks) {
            if (curBlock.getType() == newBlock.getType()) {
                exists = true;
                break;
            }
        }

        if (exists) {
            Console.log("VObject already contains this block.");
        } else {
            blocks.add(newBlock);
        }
    }
}
