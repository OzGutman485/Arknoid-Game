package Game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collisiondetectiontools.Block;
import geometrytools.Point;


import java.awt.Color;


/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        Block block = new Block(new Point(0, 0), 800, 600, Color.green);
        block.drawOn(d);
        d.drawText(10, 200, "paused -- press space to continue", 32);
    }

    @Override

    public boolean shouldStop() {
        return this.stop;
    }
}
