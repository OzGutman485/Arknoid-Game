package geometrytools;


/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Point {

    static final double EPSILON = 0.00001;
    private double x;
    private double y;

    /**
     * the class will define the object point, point has 2 fields:x value on space and y value on space.
     *
     * @param x the x
     * @param y the y
     */
// constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the function will return the distance between point 1 and point 2 according the define of distance,
     * the sqrt op x1-x2 in pow 2 + y1-y2 in pow 2.
     *
     * @param other another point in space
     * @return the distance between the point who was excautued the method to another point.
     */
// distance -- return the distance of this point to the other point
    public double distance(Point other) {
        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    /**
     * the function will get another point in space and will return boolean value if the points
     * are equal in actully if the x value of this points and the y value of this points are
     * equal, we check if the points are equal in threswhold method.
     *
     * @param other another point
     * @return boolean if the point who was excauted the method are equal to another point
     */
// equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        return Math.abs(this.getY() - other.getY()) <= EPSILON && Math.abs(this.getX() - other.getX()) <= EPSILON;
    }


    /**
     * .
     * the function will return the x value of the point in space
     *
     * @return the x point of value in space
     */
// Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * .
     * the function will return the y value of the point in space
     *
     * @return the y point of value in space
     */
    public double getY() {
        return this.y;
    }
}

