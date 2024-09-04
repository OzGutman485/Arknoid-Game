
package spritesGame;

import Game.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collisiondetectiontools.Collidable;
import geometrytools.Ball;
import geometrytools.Point;
import geometrytools.Rectangle;
import geometrytools.Velocity;

import java.awt.Color;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Paddle implements Sprite, Collidable {
    /**
     * The Sizeball.
     */
    static final int SIZEBALL = 5;
    /**
     * The Widthmax.
     */
    static final int WIDTHMAX = 775;
    /**
     * The Widthmin.
     */
    static final int WIDTHMIN = 25;
    private biuoop.KeyboardSensor keyboard;
    private Point upperleft;
    private int width;
    private int height;
    private Color color;
    private int speedinx;

    /**
     * <p> we defined the paddle this is the player in the game, its a block that controlled by the
     * user and change the velocity of the ball every time the ball collidable in him.</p>
     *
     * @param upperleft the upperleft
     * @param width     the width
     * @param height    the height
     * @param keyboard  the keyboard
     * @param speedinx  the speedinx
     */
    public Paddle(Point upperleft, int width, int height, KeyboardSensor keyboard, int speedinx) {
        this.upperleft = upperleft;
        this.width = width;
        this.height = height;
        this.keyboard = keyboard;
        this.color = Color.yellow;
        this.speedinx = speedinx;
    }

    /**
     * <p>this function response on moving the paddle in space by adden to upper left of paddle factor 5 for move in
     * the next time we shoed him
     * ,olso he check every move of the paddle that the ball in game not cross beyond the paddle.</p>
     */
    public void moveLeft() {
        if (this.upperleft.getX() > WIDTHMIN) {
            this.upperleft = new Point(this.upperleft.getX() - this.speedinx, this.upperleft.getY());
        }
    }


    /**
     * <p>
     * this function response on moving the paddle in space,olso he check every move of the paddle that the ball in
     * game not cross beyond the paddle its like the previous but in the right move..</p>
     */
    public void moveRight() {
        if (this.upperleft.getX() + width < WIDTHMAX) {
            this.upperleft = new Point(this.upperleft.getX() + this.speedinx, this.upperleft.getY());
        }
    }


    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else {
            if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
                moveRight();
            }
        }
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return new Rectangle(upperleft, width, height, Color.YELLOW);
    }

    /**
     * <p>
     * this method are changing the velocity of the ball, the paddle divided to five, the velocity of the ball
     * are changing according its part he hit according the requirment of the mission, we use his vector of velocity
     * and give him speed by angle and this..
     * </p>
     **/

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        /*we fina a new velocity for ball after he collide in paddle according the angle he hit the paddle*/
        double width1 = this.width / 5.0;
        double width2 = (this.width / 5.0) * 2;
        double width3 = (this.width / 5.0) * 3;
        double width4 = (this.width / 5.0) * 4;
        double width5 = this.width;
        if (collisionPoint.getX() >= this.upperleft.getX() - SIZEBALL
                && collisionPoint.getX() <= this.upperleft.getX() + width1) {
            currentVelocity = Velocity.fromAngleAndSpeed(300,
                    Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
        } else {
            if (collisionPoint.getX() > this.upperleft.getX() + width1
                    && collisionPoint.getX() <= this.upperleft.getX() + width2) {
                currentVelocity = Velocity.fromAngleAndSpeed(330,
                        Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
            } else {
                if (collisionPoint.getX() > this.upperleft.getX() + width2
                        && collisionPoint.getX() <= this.upperleft.getX() + width3) {
                    currentVelocity = Velocity.fromAngleAndSpeed(360,
                            Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
                } else {
                    if (collisionPoint.getX() > this.upperleft.getX() + width3
                            && collisionPoint.getX() <= this.upperleft.getX() + width4) {
                        currentVelocity = Velocity.fromAngleAndSpeed(30,
                                Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2)));
                    } else {
                        if (collisionPoint.getX() > this.upperleft.getX() + width4
                                && collisionPoint.getX() <= this.upperleft.getX() + width5 + SIZEBALL) {
                            currentVelocity = Velocity.fromAngleAndSpeed(60,
                                    Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                                            + Math.pow(currentVelocity.getDy(), 2)));
                        }
                    }
                }
            }
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface, Color color) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.upperleft.getX(), (int) this.upperleft.getY(), width, height);
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.upperleft.getX(), (int) this.upperleft.getY(), width, height);
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawOn(d, this.color);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
