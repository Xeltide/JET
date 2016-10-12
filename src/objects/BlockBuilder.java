package objects;

import java.util.ArrayList;

import gui.Console;

public class BlockBuilder {

    static ArrayList<Block> blocks = new ArrayList<Block>();
    
    public static void newBlock(Block newBlock) {
        boolean exists = false;
        for (Block curBlock : blocks) {
            if (curBlock.getName().equals(newBlock.getName())) {
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
