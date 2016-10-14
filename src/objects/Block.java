package objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import gui.BlockPanel;

abstract public class Block {
    /**
     * <p>
     * Flag for if the block has changed.
     * Unchanged blocks should be ignored at runtime.
     * </p>
     */
    private boolean changed;
    /**
     * <p>
     * Flag for if the block is enabled in the BlockViewer.
     * Disabled blocks are ignored at runtime.
     * </p>
     */
    private boolean enabled;
    protected BlockType type;

    Block(BlockType type) {
        changed = false;
        enabled = true;
        this.type = type;
    }

    /**
     * Sets the changed flag.
     *
     * @param val flag changed
     */
    void setChanged(boolean val) {
        changed = val;
    }
    /**
     * Sets the enabled flag.
     *
     * @param val flag enabled
     */
    void setEnabled(boolean val) {
        enabled = val;
    }
    /**
     * Returns the name of the block.
     *
     * @return String name
     */
    public String getName() {
        return type.getName();
    }

    public BlockType getType() {
        return type;
    }

    public abstract BlockPanel getNewPanel(VObject obj);
    
    public abstract void readXml(Document doc, Element e);
    public abstract void writeXml(Document doc, Element e);

}
