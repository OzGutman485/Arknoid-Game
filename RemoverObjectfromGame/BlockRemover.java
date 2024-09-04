package RemoverObjectfromGame;

import Listener.HitListener;
import collisiondetectiontools.Block;
import geometrytools.Ball;
import Game.GameLevel;

/**
 * &author oz gutman < oz gutman@liva.biu.ac.il>.
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */


public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     * // a BlockRemover is in charge of removing blocks from the game, as well as keeping count
     * * // of the number of blocks that remain.
     *
     * @param gameLevel          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.removeSprite(beingHit);
        this.gameLevel.removeCollidable(beingHit);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        this.remainingBlocks.decrease(1);
    }

    /**
     * Sets counter of the block in game.
     *
     * @param num the num
     */
    public void setCounter(int num) {
        this.remainingBlocks.increase(num);
    }

    /**
     * Gets remaining blocks of block in game.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}
