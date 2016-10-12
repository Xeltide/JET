package engine;

/**
 * <p>
 * Entrance point for the engine loop testing. Will be cut when the
 * live run time is available.
 * </p>
 * 
 * @author Xeltide
 * @version 0.1a
 */
public class EngineDriver {

    public static void main(String[] args) {
        EngineLoop loop = new EngineLoop();
        while (true) {
            loop.run();
        }

    }

}
