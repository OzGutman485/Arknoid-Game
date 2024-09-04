package Levels;

import collisiondetectiontools.Block;
import geometrytools.Ball;
import geometrytools.Line;
import geometrytools.Point;
import geometrytools.Rectangle;
import geometrytools.Velocity;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import Game.Background;

/**
 * The type Direct hit level.
 */
public class DirectHitLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Velocity velocity = new Velocity(0, -5);
        List<Velocity> list = new LinkedList<>();
        list.add(velocity);
        return list;
    }

    @Override
    public List<Point> getcenterpoint() {
        List<Point> list = new LinkedList<>();
        Point center1 = new Point(430, 550);
        list.add(center1);
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }
    @Override
    public Point paddlelocation() {
        return new Point(400, 570);
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> list = new LinkedList<>();
        Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 600, Color.black);
        list.add(rectangle);
        for (int i = 0; i < 3; i++) {
            Ball ball = new Ball(415, 165, 120 - i * 30, Color.BLACK, Color.BLUE);
            list.add(ball);
        }
        Line middle = new Line(new Point(280, 165), new Point(550, 165), Color.blue);
        Line up = new Line(new Point(415, 0), new Point(415, 300), Color.blue);
        list.add(middle);
        list.add(up);
        return new Background(list);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new LinkedList<>();
        Block block = new Block(new Point(400, 150), 30, 30, Color.RED);
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
