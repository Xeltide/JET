package objects;

public enum BlockType {
    LOC_ROT("LocRot"),
    RENDERER_2D("Renderer2D");

    String name;
    BlockType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
