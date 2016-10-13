package objects;

public enum BlockType {
    LOC_ROT("LocRot");

    String name;
    BlockType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
