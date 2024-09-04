package Listener;

import collisiondetectiontools.Block;
import geometrytools.Ball;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public interface HitListener {
    /**
     * // This method is called whenever the block object is hit.
     * // The hitter parameter is the Ball that's doing the hitting.
     * this function called for all who listener and say them about the hit.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */

    void hitEvent(Block beingHit, Ball hitter);
}
