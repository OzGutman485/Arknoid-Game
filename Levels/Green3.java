package Levels;

import Game.Background;
import collisiondetectiontools.Block;
import geometrytools.Ball;
import geometrytools.Point;
import geometrytools.Velocity;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public Point paddlelocation() {
        return new Point(400, 570);
    }

    /**
     * Gets .
     *
     * @return the
     */
    public List<Point> getcenterpoint() {
        List<Point> list = new LinkedList<>();
        Point center1 = new Point(400, 550);
        list.add(center1);
        Point center2 = new Point(400, 550);
        list.add(center2);
        return list;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new LinkedList<>();
        Velocity velocity1 = new Velocity(5, -5);
        list.add(velocity1);
        Velocity velocity2 = new Velocity(-5, -5);
        list.add(velocity2);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> list = new LinkedList<>();
        Block block = new Block(new Point(0, 0), 800, 600, Color.GREEN);
        list.add(block);
        Ball ball = new Ball(130, 200, 10, Color.gray, Color.gray);
        list.add(ball);
        Ball ball1 = new Ball(130, 200, 7, Color.red, Color.red);
        list.add(ball1);
        list.add(new Ball(130, 200, 3, Color.WHITE, Color.white));
        Block rectangle = new Block(new Point(123, 210), 10, 200, Color.DARK_GRAY);
        Block rectangle1 = new Block(new Point(113, 410), 30, 50, Color.darkGray);
        list.add(rectangle);
        list.add(rectangle1);
        Block rectangle2 = new Block(new Point(83, 460), 90, 140, Color.DARK_GRAY);
        list.add(rectangle2);
        for (int i = 0; i < 5; i++) {
            Block rectangle3 = new Block(new Point(100 + 12 * i, 470), 10, 20, Color.white);
            list.add(rectangle3);
        }
        for (int i = 0; i < 5; i++) {
            Block rectangle3 = new Block(new Point(100 + 12 * i, 495), 10, 20, Color.white);
            list.add(rectangle3);
        }
        for (int i = 0; i < 5; i++) {
            Block rectangle3 = new Block(new Point(100 + 12 * i, 520), 10, 20, Color.white);
            list.add(rectangle3);
        }
        for (int i = 0; i < 5; i++) {
            Block rectangle3 = new Block(new Point(100 + 12 * i, 545), 10, 20, Color.white);
            list.add(rectangle3);
        }
        for (int i = 0; i < 5; i++) {
            Block rectangle3 = new Block(new Point(100 + 12 * i, 570), 10, 20, Color.white);
            list.add(rectangle3);
        }
        return new Background(list);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Point(275 + 50 * i, 200), 50, 25, Color.gray);
            list.add(block);
        }
        for (int i = 0; i < 9; i++) {
            Block block = new Block(new Point(325 + 50 * i, 225), 50, 25, Color.red);
            list.add(block);
        }
        for (int i = 0; i < 8; i++) {
            Block block = new Block(new Point(375 + 50 * i, 250), 50, 25, Color.yellow);
            list.add(block);
        }
        for (int i = 0; i < 7; i++) {
            Block block = new Block(new Point(425 + 50 * i, 275), 50, 25, Color.BLUE);
            list.add(block);
        }
        for (int i = 0; i < 6; i++) {
            Block block = new Block(new Point(475 + 50 * i, 300), 50, 25, Color.white);
            list.add(block);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
