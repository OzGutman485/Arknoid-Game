package collisiondetectiontools;

import java.util.LinkedList;
import java.util.List;

import geometrytools.Line;
import geometrytools.Point;
import geometrytools.Rectangle;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class GameEnvironment {
    /**
     * The Defaultpoint.
     */
    static final Point DEFAULTPOINT = new Point(1000000000, 100000000);
    private List<Collidable> list;

    /**
     * <p> we defined the list that embodied the blocks or the paddle of the game.</p>
     */
    public GameEnvironment() {
        this.list = new LinkedList<>();
    }

    /**
     * <p>
     * we add the colliadable object to list of colliable object that the ball can collide in them.
     * </p>
     *
     * @param c the colliadelable;
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * we return the list of colliadbles for check if the ball cross in them.
     *
     * @return the list
     */
    public List<Collidable> getList() {
        return this.list;
    }

    /**
     * Sets list of the block in game.
     *
     * @param list the list
     */
    public void setList(List<Collidable> list) {
        this.list = list;
    }

    /**
     * <p>
     * the function are return the closeset intersection point of line in block, the line are represent the move
     * of the ball, by this line we can know the closeset intersection of the ball in block, first we find list of
     * the collision point of ball in block in list, after this we pass the list and if we find the closest intersection
     * to the start of line that represent the center of the ball, actully we find the closet intersection of the
     * center of the ball in block, if we not find interection we return null and we can check this by check if the
     * object we need to return his collision point not change in the pass of list of collision point in blocks.
     * </p>
     *
     * @param trajectory the trajectory= the line of the movement of the ball.
     * @return the closest collision that ball going to collision in object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> collisionInfos = new LinkedList<>();
        for (Collidable c : this.list) {
            Rectangle rectangle = c.getCollisionRectangle();
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(rectangle);
            CollisionInfo collisionInfo = new CollisionInfo(collisionPoint, c);
            collisionInfos.add(collisionInfo);
        }
        CollisionInfo closetoline = new CollisionInfo(DEFAULTPOINT, null);
        for (CollisionInfo c : collisionInfos) {
            if (c.collisionPoint() != null && c.collisionPoint().distance(trajectory.start())
                    < closetoline.collisionPoint().distance(trajectory.start())) {
                closetoline = c;
            }
        }
        if (closetoline.collisionPoint().equals(DEFAULTPOINT)) {
            return null;
        }
        return closetoline;
    }

}
