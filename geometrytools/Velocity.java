package geometrytools;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * we define a new object, in real its just a fields for ball and this is the velocity of the ball in
     * space, he had 2 components, speed in x junction, and speed in y junction.
     * this is the contractor for this fields
     *
     * @param dx the dx- speed in x junction
     * @param dy the dy-speed in y junction
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * * we define a new object, in real its just a fields for ball and this is the velocity of the ball in
     * * space, now we can define him that he had 2 components another, vector of speed in space, he had
     * a component in x junction and in y junction,but he had olso a angle from the vector from the x junction
     * in this method we define the object velocity by this component and we extract the component in
     * x and y junction with trigomentria in space.
     *
     * @param angle the angle of the vector
     * @param speed the vector speed in space
     * @return object a velocity we define him here.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy = speed * (Math.cos((Math.toRadians(angle + 180))));
        double dx = speed * (Math.sin((Math.toRadians(angle))));
        return new Velocity(dx, dy);
    }

    /**
     * .
     * the function return the dx component of we added to speed in x junction
     *
     * @return the dx of we added to speed in space
     */
    public double getDx() {
        return dx;
    }

    /**
     * .
     * the function return the dy component of we added to speed in y junction
     *
     * @return the dy of we added to speed in space
     */
    public double getDy() {
        return dy;
    }


    /**
     * .
     * <p>
     * the function gets a point and return another point with the change of velocity
     * </p>
     *
     * @param p the point
     * @return the new point with the added of velocity.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

}
