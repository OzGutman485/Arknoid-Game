package collisiondetectiontools;
import biuoop.DrawSurface;
import geometrytools.Ball;
import geometrytools.Point;
import geometrytools.Rectangle;
import geometrytools.Velocity;


import java.awt.Color;

/**
 * /*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public interface Collidable {
    /**
     * <p>
     * the func return the rectangle of the shape we going to collidable.
     * </p>
     *
     * @return the collision rectangle of the object we going to collidable
     */
    Rectangle getCollisionRectangle();

    /**
     * <p>
     * the func gets the point we going to colliable in the rectangle,and return new velocity
     * of the shape that are colliable in our rectangle.
     * </p>
     *
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * <p>
     * the func are getting the surface in the game and color of the block that was defined and draw him to
     * the object.
     * </p>
     * DrawSurface surface, Color color
     *
     * @param surface the surface
     * @param color   the color
     */
    void drawOn(DrawSurface surface, Color color);
}
