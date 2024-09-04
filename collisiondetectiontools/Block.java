package collisiondetectiontools;

import Game.GameLevel;
import Listener.HitListener;
import biuoop.DrawSurface;

import java.awt.Color;

import geometrytools.Line;
import geometrytools.Point;
import geometrytools.Ball;
import geometrytools.Rectangle;
import geometrytools.Velocity;
import spritesGame.Sprite;
import Listener.HitNotifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Point upperleftstart;
    private int width;
    private int lentgh;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * <p>we define a new class as a block, block is actully a rectangle but he had abillty that he
     * change the veloctiy of object that colliadbled in him.</p>
     *
     * @param upperleftstart the upperleftstart
     * @param width          the width
     * @param lentgh         the lentgh
     * @param color          the color
     */
    public Block(Point upperleftstart, int width, int lentgh, Color color) {
        this.upperleftstart = upperleftstart;
        this.width = width;
        this.lentgh = lentgh;
        this.color = color;
        this.hitListeners = new LinkedList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(this.upperleftstart, this.width, this.lentgh, Color.black);
    }

    /**
     * <p>
     * the func are return the new velocity of ball that intersection in block, we find in whice line of the
     * rectangle the ball are intersection, and by this we can move his vertical velocity or horizontal velocity, if
     * we intersection in right or left lines we change the vertical velocity, if we cross the up or down lines
     * we change the horizontal velocity.
     * </p>
     *
     * @return the collision point, the velocity of the ball.
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Rectangle shape = getCollisionRectangle();
        Point upperleft = shape.getUpperLeft();
        Point upperight = new Point(upperleft.getX() + shape.getWidth(), upperleft.getY());
        Point downleft = new Point(upperleft.getX(), upperleft.getY() + shape.getHeight());
        Point downright = new Point(upperleft.getX() + shape.getWidth(), upperleft.getY() + shape.getHeight());
        // we check where was the collision point, if in x axis or in y axis by the upperleft of tringle of the shape
        Line help = new Line(upperleft, upperight, Color.black);
        if (help.pointonline(collisionPoint, help)) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        Line help2 = new Line(downleft, downright, Color.black);
        if (help2.pointonline(collisionPoint, help2)) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        Line help3 = new Line(upperleft, downleft, Color.black);
        if (help3.pointonline(collisionPoint, help3)) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        Line help4 = new Line(upperight, downright, Color.black);
        if (help4.pointonline(collisionPoint, help4)) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        if (this.upperleftstart.equals(new Point(0, 610))) {
            hitter.notifyHit(this);
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface, Color color) {
        surface.setColor(color);
        surface.fillRectangle((int) this.upperleftstart.getX(), (int) this.upperleftstart.getY(), width, lentgh);
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.upperleftstart.getX(), (int) this.upperleftstart.getY(), width, lentgh);
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawOn(d, this.color);
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Remove block from game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
