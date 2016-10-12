package objects;

abstract public class Block {
    
    private boolean changed;
    private boolean enabled;
    private String name;
    
    Block(String name) {
        changed = false;
        enabled = true;
        this.name = name;
    }
    
    void setFlag(boolean val) {
        changed = val;
    }
    
    void setEnabled(boolean val) {
        enabled = val;
    }
    
    String getName() {
        return name;
    }

}
