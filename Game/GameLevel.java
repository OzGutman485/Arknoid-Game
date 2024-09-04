package Game;

import Levels.LevelInformation;
import biuoop.DrawSurface;
import RemoverObjectfromGame.BallRemover;
import biuoop.KeyboardSensor;
import collisiondetectiontools.Block;
import RemoverObjectfromGame.BlockRemover;
import collisiondetectiontools.Collidable;
import RemoverObjectfromGame.Counter;
import collisiondetectiontools.GameEnvironment;
import geometrytools.Ball;
import geometrytools.Point;
import geometrytools.Velocity;
import spritesGame.Paddle;
import spritesGame.ScoreIndicator;
import spritesGame.Sprite;
import spritesGame.SpriteCollection;
import Listener.ScoreTrackingListener;


import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter reminingblocks;
    private Counter reminingballs;
    private Counter score;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new Game, that have a gui, sprite in game, rectangle for color the game, and collidable blocks
     * that defined in game enveriments.
     *
     * @param levelInformation the level information
     * @param animationRunner  the animation runner
     * @param keyboard         the keyboard
     * @param score            the score
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner, KeyboardSensor keyboard,
                     Counter score) {
        this.runner = animationRunner;
        // we defined the keyboard that respones for move the paddle
        this.keyboard = keyboard;
        this.score = score;
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.reminingblocks = new Counter();
        this.reminingballs = new Counter();
    }

    /**
     * we Add collidable block for the list of collidables.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * we Add sprite to the list of sprites.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * we Initialize the game.
     */
// Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    public void initialize() {
        BallRemover ballRemover = new BallRemover(this, new Counter());
        int i;
        List<Point> centerballs = this.levelInformation.getcenterpoint();
        List<Velocity> velocitiesballs = this.levelInformation.initialBallVelocities();
        // initilish each ball of the game
        for (i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Point center = centerballs.get(i);
            Ball ball = new Ball(center, 5, Color.white, Color.black, this.environment);
            ballRemover.setCounter(1);
            ball.addHitListener(ballRemover);
            this.reminingballs.increase(1);
            ball.setMindistancefromwidth(20);
            ball.setMaxdistancefromwidth(780);
            ball.setMindistancefromlentgh(35);
            ball.setMaxdistancefromlentgh(615);
            Velocity velocity = velocitiesballs.get(i);
            ball.setVelocity(new Velocity(velocity.getDx(), velocity.getDy()));
            ball.addToGame(this);
        }
        this.reminingballs = ballRemover.getRemainingBlocks();
        Block leftside = new Block(new Point(0, 0), 25, 600, Color.gray);
        leftside.addToGame(this);
        Block rightside = new Block(new Point(775, 0), 25, 600, Color.gray);
        rightside.addToGame(this);
        Block upside = new Block(new Point(0, 0), 800, 40, Color.gray);
        upside.addToGame(this);
        Block downside = new Block(new Point(0, 610), 800, 20, Color.black);
        downside.addToGame(this);
        // we sent the paddle the balls for paddle not cross in them.
        Paddle paddle = new Paddle(this.levelInformation.paddlelocation(), this.levelInformation.paddleWidth(),
                15, keyboard, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        BlockRemover blockRemover = new BlockRemover(this, new Counter());
        // we initlish the blocks in game.
        List<Block> list = this.levelInformation.blocks();
        for (i = 0; i < this.levelInformation.numberOfBlocksToRemove(); i++) {
            Block block = list.get(i);
            block.addToGame(this);
            blockRemover.setCounter(1);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
        this.reminingblocks = blockRemover.getRemainingBlocks();
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreTrackingListener.getCurrentScore(),
                this.levelInformation.levelName());
        this.score = scoreTrackingListener.getCurrentScore();
        scoreIndicator.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Do one frame-doOneFrame(DrawSurface) is in charge of the logic, made the
     * program we shold do in each frame, move sprites and draw them.
     *
     * @param d the d.
     */
    public void doOneFrame(DrawSurface d) {
        this.levelInformation.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new PauseScreen(this.keyboard)));
        }
        if (this.reminingblocks.getValue() == 0) {
            score.increase(100);
            this.running = false;
        }
        if (this.reminingballs.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * Should stop the loop if the block or balls are zero , return boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        List<Collidable> list = new ArrayList<>(this.environment.getList());
        list.remove(c);
        this.environment.setList(list);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        List<Sprite> list = new ArrayList<>(this.sprites.getSpriteList());
        list.remove(s);
        this.sprites.setList(list);
    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getblocksnumber() {
        return this.reminingblocks.getValue();
    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getnumballs() {
        return this.reminingballs.getValue();
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return this.score;
    }
}
