package Levels;

import collisiondetectiontools.Block;
import geometrytools.Point;
import geometrytools.Velocity;

import java.util.List;

import spritesGame.Sprite;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Paddlelocation point.
     *
     * @return the point
     */
    Point paddlelocation();

    /**
     * // The initial velocity of each ball.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the Paddle speed.
     *
     * @return the int of the speed.
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * // the level name will be displayed at the top of the screen.
     *
     * @return the string
     */
    String levelName();

    /**
     * // Returns a list of the center of the ball we want to initlish.
     *
     * @return the background
     */
    List<Point> getcenterpoint();

    /**
     * Gets background.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * // The Blocks that make up this level, each block contains
     * // its size, color and location.
     *
     * @return the list
     */
    List<Block> blocks();

    /**
     * // Number of blocks that should be removed
     * // before the level is considered to be "cleared".
     * // This number should be <= blocks.size();
     *
     * @return the int
     */
    int numberOfBlocksToRemove();
}