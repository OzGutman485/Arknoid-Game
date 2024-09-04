package Listener;

import collisiondetectiontools.Block;
import geometrytools.Ball;
import RemoverObjectfromGame.Counter;


/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener and add points when block is hit.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * Gets current score of the score in game.
     *
     * @return the current score
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }
}
