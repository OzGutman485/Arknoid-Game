package collisiondetectiontools;

import geometrytools.Point;


/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable object;

    /**
     * Instantiates a new Collision info, that defined the collision details by the object the ball collide  inhim
     * and the point the ball are collided the rectangle.
     *
     * @param collisionPoint the collision point
     * @param object         the object
     */
    public CollisionInfo(Point collisionPoint, Collidable object) {
        this.object = object;
        this.collisionPoint = collisionPoint;
    }

    /**
     * return the Collision point of the ball in the collidable.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * return the object of the ball are collidable.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return object;
    }
}
