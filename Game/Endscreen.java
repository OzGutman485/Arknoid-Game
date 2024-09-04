package Game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collisiondetectiontools.Block;
import geometrytools.Point;

import java.awt.Color;

/**
 * The type Endscreen.
 */
public class Endscreen implements Animation {
    private KeyboardSensor keyboard;
    private KeyPressStoppableAnimation keyPressStoppableAnimation;
    private int score;
    private boolean win;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k     the k
     * @param score the score
     * @param win   the win
     */
    public Endscreen(KeyboardSensor k, int score, boolean win) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.win = win;
        this.keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboard, "space", this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Block block = new Block(new Point(0, 0), 800, 600, Color.gray);
        block.drawOn(d);
        if (win) {
            d.drawText(200, 100, "You Win!", 50);
            d.setColor(Color.green);
            d.drawText(200, 250, " Your score is: " + this.score, 50);
            d.setColor(Color.orange);
            d.drawText(200, 400, " Press space to continue", 50);
        } else {
            d.drawText(200, 100, "Game Over", 50);
            d.setColor(Color.green);
            d.drawText(200, 250, " Your score is: " + this.score, 50);
            d.setColor(Color.orange);
            d.drawText(200, 400, " Press space to continue", 50);
        }
        this.stop = this.keyPressStoppableAnimation.shouldStop();
    }

    @Override

    public boolean shouldStop() {
        return this.stop;
    }
}
