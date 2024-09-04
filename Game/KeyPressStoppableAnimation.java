package Game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.keyboardSensor.isPressed(key)) {
            animation.doOneFrame(d);
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        if (this.keyboardSensor.isPressed(key) && !isAlreadyPressed) {
            return true;
        }
        return false;
    }
}
