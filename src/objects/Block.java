package objects;

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
    private String name;
    /**
     * <p>
     * Default constructor for block.
     * Sets enabled to true and changed to false.
     * </p>
     * 
     * @param name String
     */
    Block(String name) {
        changed = false;
        enabled = true;
        this.name = name;
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
        return name;
    }

}
