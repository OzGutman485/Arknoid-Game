

package geometrytools;

import Game.GameLevel;
import Listener.HitListener;
import Listener.HitNotifier;
import biuoop.DrawSurface;
import collisiondetectiontools.Block;
import collisiondetectiontools.Collidable;
import collisiondetectiontools.CollisionInfo;
import collisiondetectiontools.GameEnvironment;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private int r;
    private java.awt.Color colorinside;
    private java.awt.Color colorOutside;
    private double dx;
    private double dy;
    private Velocity v;
    private double mindistancefromwidth;
    private double maxdistancefromwidth;
    private double mindistancefromlentgh;
    private double maxdistancefromlentgh;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;

    /**
     * this is the constructor of the object ball.
     * we define a new object in space who ball, thats accutelly is a circle, ball has 4 fields ,the x value of
     * middle point,the y value of the middle point, the radius of the circle and the colotr of the circle.
     *
     * @param x            the x value of the middle point
     * @param y            the y value of the middle point
     * @param r            the redius of the ball
     * @param colorinside  the color of the ball
     * @param colorOutside the color outside
     */
// constructor
    public Ball(double x, double y, int r, java.awt.Color colorinside, java.awt.Color colorOutside) {
        this.center = new Point(x, y);
        this.r = r;
        this.colorinside = colorinside;
        this.colorOutside = colorOutside;
        this.dx = 0;
        this.dy = 0;
        this.v = null;
    }

    /**
     * this is the constructor of the object ball.
     * its like the previous method constructor but in this method we get diraction the middle point of the
     * ball and we not need to define the middle point.
     *
     * @param point           the  middle point
     * @param r               the radius
     * @param colorinside     the color of the ball.
     * @param colorOutside    the color outside
     * @param gameEnvironment the game environment
     */
    public Ball(Point point, int r, java.awt.Color colorinside, java.awt.Color colorOutside,
                GameEnvironment gameEnvironment) {
        this.center = point;
        this.r = r;
        this.colorinside = colorinside;
        this.colorOutside = colorOutside;
        this.dx = 0;
        this.dy = 0;
        this.v = null;
        this.gameEnvironment = gameEnvironment;
        this.hitListeners = new LinkedList<>();
    }


    /**
     * the method return the x value of the center of the ball.
     *
     * @return the x value of the middle point of point
     */
// accessors
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * the method return the y value of the center of the ball.
     *
     * @return the y value of the middle point of point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * the method return the radius of the ball.
     *
     * @return the radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets center of the ball.
     *
     * @return the center of the ball
     */
    public Point getCenter() {
        return this.center;
    }


    /**
     * the function draw the ball in  the surface by using the gui package.
     *
     * @param surface the surface of the gui package
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.colorinside);
        surface.fillCircle((int) center.getX(), (int) center.getY(), r);
        surface.setColor(this.colorOutside);
        surface.drawCircle((int) center.getX(), (int) center.getY(), r);
    }

    /**
     * Set mindistancefromwidth.
     *
     * @param x the x
     */
    public void setMindistancefromwidth(double x) {
        this.mindistancefromwidth = x;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public double getmindistancefromwidth() {
        return this.mindistancefromwidth;
    }

    /**
     * Set maxdistancefromwidth.
     *
     * @param x the x
     */
    public void setMaxdistancefromwidth(double x) {
        this.maxdistancefromwidth = x;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public double getmaxdistancefromwidth() {
        return this.maxdistancefromwidth;
    }

    /**
     * Set mindistancefromlentgh.
     *
     * @param y the y
     */
    public void setMindistancefromlentgh(double y) {
        this.mindistancefromlentgh = y;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public double getmindistancefromlentgh() {
        return this.mindistancefromlentgh;
    }

    /**
     * Set maxdistancefromlentgh.
     *
     * @param y the y
     */
    public void setMaxdistancefromlentgh(double y) {
        this.maxdistancefromlentgh = y;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public double getmaxdistancefromlentgh() {
        return this.maxdistancefromlentgh;
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * the function sets the velocity of the ball to the velocity he gets.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.v = v;
        this.dx = this.v.getDx();
        this.dy = this.v.getDy();
    }

    /**
     * .
     * the function return the velocity of the ball
     *
     * @return the velocity of the ball
     */
    public Velocity getVelocity() {
        if (this.v == null) {
            return new Velocity(this.dx, this.dy);
        }
        return this.v;
    }

    /**
     * this function give us the velocity in x diraction.
     *
     * @return the dx of ball.
     */
    public double getdx() {
        return this.dx;
    }

    /**
     * this function give us the velocity in y diraction.
     *
     * @return thedy of ball
     */
    public double getdy() {
        return this.dy;
    }


    /**
     * move one step we changing the ball position
     * <p>
     * this is a query method.
     * first in the method we check if the ball going to cross any block in his move, if he not we move him, if he
     * intersection we find in whice line he will cross and we change his position to be acroding this collision
     * point that the ball will touch the block and will move with the method of hit of the block himself.
     * any move of the ball,cross rectangle or no we check the ball not cross the bounds of our game,
     * if he is we move him to be less from the bounds that he will be touch in the bounds and not collision in them.
     *
     * </p>
     */
    public void moveOneStep() {
        Point endmovement = new Point(this.center.getX() + this.getdx(), this.center.getY() + this.getdy());
        Line trajectory = new Line(this.getCenter(), endmovement, Color.black);
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Point collision = collisionInfo.collisionPoint();
            Collidable collidable = collisionInfo.collisionObject();
            Rectangle rectangleColliadable = collidable.getCollisionRectangle();
            /* we went to know how to move the ball center according the object he intersection
            if his move getting the upperleft we move the ball center back by his x or y value,if he
            intersection the down right we promote this x or y value */
            // we find the upperleft and downright of the object we collision for caculate the new center.
            Point upperleft = rectangleColliadable.getUpperLeft();
            double width = rectangleColliadable.getWidth();
            double height = rectangleColliadable.getHeight();
            Point upright = new Point(upperleft.getX() + width, upperleft.getY());
            Point downleft = new Point(upperleft.getX(), upperleft.getY() + height);
            Point downright = new Point(upperleft.getX() + width, upperleft.getY() + height);
            //we find in whice line of the tringle the ball is collision, by this we find its new location
            if (trajectory.intersectionWith(new Line(upperleft, downleft, Color.black)) != null
                    && trajectory.intersectionWith(new Line(upperleft, downleft, Color.black)).equals(collision)) {
                this.center = new Point(collision.getX() - getSize(), collision.getY());
            }
            if (trajectory.intersectionWith(new Line(upright, downright, Color.black)) != null
                    && trajectory.intersectionWith(new Line(upright, downright, Color.black)).equals(collision)) {
                this.center = new Point(collision.getX() + getSize(), collision.getY());
            }
            if (trajectory.intersectionWith(new Line(upperleft, upright, Color.black)) != null
                    && trajectory.intersectionWith(new Line(upperleft, upright, Color.black)).equals(collision)) {
                this.center = new Point(collision.getX(),
                        collision.getY() - getSize());
            }
            if (trajectory.intersectionWith(new Line(downleft, downright, Color.black)) != null
                    && trajectory.intersectionWith(new Line(downleft, downright, Color.black)).equals(collision)) {
                this.center = new Point(collision.getX(),
                        collision.getY() + getSize());
            }
            // now we want to change the ball velocity
            setVelocity(collidable.hit(this, collision, getVelocity()));
        }
        /* now we check the ball not cross the limit of our screen that defined in our blocks
            if he pass we defined the center according the mamx or min value
             */
        if (this.center.getX() >= this.getmaxdistancefromwidth() - this.getSize()) {
            this.center = new Point(this.maxdistancefromwidth - this.getSize(), this.getY());
        } else {
            if (this.center.getX() <= this.getmindistancefromwidth() + this.getSize()) {
                this.center = new Point(this.mindistancefromwidth + this.getSize(), this.getY());
            }
        }
        if (this.center.getY() + this.getSize() >= this.getmaxdistancefromlentgh()) {
            this.center = new Point(this.getX(), this.maxdistancefromlentgh - this.getSize());
        } else {
            if (this.center.getY() <= this.getmindistancefromlentgh() + this.getSize()) {
                this.center = new Point(this.getX(), this.mindistancefromlentgh + this.getSize());
            }
        }

    }

    /**
     * Remove ball from game.
     *
     * @param g the g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }


    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Notify hit of the ball the list who listen to this.
     *
     * @param block the block
     */
    public void notifyHit(Block block) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(block, this);
        }
    }
}


