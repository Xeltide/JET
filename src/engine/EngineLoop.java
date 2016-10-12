package engine;

import gui.Console;

/**
 * <p>
 * Main engine loop. Requires handlers before function are added
 * back in.
 * </p>
 * 
 * @author Xeltide
 * @version 0.1a
 */
public class EngineLoop {
    //frame maximum time
    public static final long T_PER_UPDATE = 20000;
    
    public void run() {
        long lastTime = getTime();
        long lag = 0;
        while (true) {
            long currentTime = getTime();
            long deltaTime = currentTime - lastTime;
            lastTime = currentTime;
            lag += deltaTime;
            
            //getInput();
            
            while (lag >= T_PER_UPDATE) {
              //updateState(deltaTime);
                lag -= T_PER_UPDATE;
            }
            //render(lag / T_PER_UPDATE);
            Console.log(deltaTime);
        }
    }
    
    private long getTime() {
        return System.nanoTime();
    }

}
