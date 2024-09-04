package RemoverObjectfromGame;

import Game.GameLevel;
import Listener.HitListener;
import collisiondetectiontools.Block;
import geometrytools.Ball;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter reminingballs;

    /**
     * Instantiates a new Ball remover that delete the ball from game.
     *
     * @param gameLevel    the game
     * @param counter the counter
     */
    public BallRemover(GameLevel gameLevel, Counter counter) {
        this.gameLevel = gameLevel;
        this.reminingballs = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        gameLevel.removeSprite(hitter);
        hitter.removeHitListener(this);
        hitter.removeFromGame(gameLevel);
        this.reminingballs.decrease(1);
    }

    /**
     * Sets counter of the block in game.
     *
     * @param num the num
     */
    public void setCounter(int num) {
        this.reminingballs.increase(num);
    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.reminingballs;
    }
}
