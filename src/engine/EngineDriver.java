package engine;

public class EngineDriver {

    public static void main(String[] args) {
        EngineLoop loop = new EngineLoop();
        while (true) {
            loop.run();
        }

    }

}
