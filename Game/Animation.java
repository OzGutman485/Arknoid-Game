package Game;

import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Do one frame-define what shold we do in this frame.
     *
     * @param d the d
     */
    void doOneFrame(DrawSurface d);

    /**
     * check if we Should stop the frame boolean.
     *
     * @return the boolean
     */
    boolean shouldStop();
}
