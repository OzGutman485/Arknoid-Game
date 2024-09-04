package Levels;

import Game.Background;
import collisiondetectiontools.Block;
import geometrytools.Ball;
import geometrytools.Line;
import geometrytools.Point;
import geometrytools.Velocity;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The  Wide easy level.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public List<Point> getcenterpoint() {
        List<Point> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Point center = new Point(500, 560);
            list.add(center);
        }
        return list;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Velocity velocity = new Velocity(-5 * (Math.pow(-1, i)), -5);
            list.add(velocity);
        }
        for (int i = 0; i < 3; i++) {
            Velocity velocity = new Velocity(5, -5 * (Math.pow(-1, i)));
            list.add(velocity);
        }
        for (int i = 0; i < 2; i++) {
            Velocity velocity = new Velocity(5 * (Math.pow(-1, i)), 5);
            list.add(velocity);
        }
        for (int i = 0; i < 2; i++) {
            Velocity velocity = new Velocity(5, 5 * (Math.pow(-1, i)));
            list.add(velocity);
        }
        return list;
    }

    @Override
    public Point paddlelocation() {
        return new Point(200, 570);
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 550;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> list = new LinkedList<>();
        Block block = new Block(new Point(0, 0), 800, 600, Color.orange);
        list.add(block);
        Ball ball1 = new Ball(150, 125, 60, Color.red, Color.red);
        Ball ball2 = new Ball(150, 125, 40, Color.green, Color.green);
        Ball ball3 = new Ball(150, 125, 25, Color.yellow, Color.yellow);
        list.add(ball1);
        list.add(ball2);
        list.add(ball3);
        for (int i = 0; i < 18; i++) {
            Line line = new Line(new Point(100 + 2 * i, 150 + 2 * i), new Point(23 + 4 * i, 250), Color.red);
            list.add(line);
        }
        for (int i = 0; i < 10; i++) {
            Line line = new Line(new Point(134 + 2 * i, 184), new Point(95 + 3 * i, 250),
                    Color.red);
            list.add(line);
        }
        for (int i = 0; i < 7; i++) {
            Line line = new Line(new Point(154 + 2 * i, 184), new Point(125 + 3 * i, 250),
                    Color.red);
            list.add(line);
        }
        for (int i = 0; i < 25; i++) {
            Line line = new Line(new Point(168 + i, 184 - i), new Point(146 + 3 * i,
                    250), Color.red);
            list.add(line);
        }
        for (int i = 0; i < 25; i++) {
            Line line = new Line(new Point(193 + 0.5 * i, 159 - 0.7 * i), new Point(220 + 3 * i,
                    250), Color.red);
            list.add(line);
        }
        for (int i = 0; i < 35; i++) {
            Line line = new Line(new Point(205 + 0.1 * i, 141 - 0.7 * i), new Point(295 + i,
                    250), Color.red);
            list.add(line);
        }
        for (int i = 0; i < 50; i++) {
            Line line = new Line(new Point(208 - 0.3 * i, 116.5 - 0.7 * i), new Point(325 + i,
                    250), Color.red);
            list.add(line);
        }
        return new Background(list);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(25 + i * 50, 250), 50, 15, Color.RED);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(125 + i * 50, 250), 50, 15, Color.orange);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(225 + i * 50, 250), 50, 15, Color.YELLOW);
            list.add(block);
        }
        for (int i = 0; i < 3; i++) {
            Block block = new Block(new Point(325 + i * 50, 250), 50, 15, Color.green);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(475 + i * 50, 250), 50, 15, Color.BLUE);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(575 + i * 50, 250), 50, 15, Color.pink);
            list.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Point(675 + i * 50, 250), 50, 15, Color.CYAN);
            list.add(block);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
