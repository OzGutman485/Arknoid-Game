
package geometrytools;

import Game.GameLevel;
import biuoop.DrawSurface;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.List;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Line implements Sprite {
    private Point startPoint;
    private Point endPoint;
    private java.awt.Color color;
    /**
     * The constant NOTINTERSECTION.
     */
    static final Point NOTINTERSECTION = new Point(-100, -100);
    /**
     * The constant EPSILON.
     */
    static final double EPSILON = 0.00001;

    /**
     * the class will define a new object a line in space, line has 2 fields a start point in space and
     * a end point in space.
     *
     * @param start the start point of a line
     * @param end   the end point of a line
     * @param color the color
     */
// constructors
    public Line(Point start, Point end, java.awt.Color color) {
        this.startPoint = start;
        this.endPoint = end;
        this.color = color;
    }

    /**
     * acutall like the previous method but in this method we getting the x and y value of the start point in
     * space and the x and y point in the end point and we define this point and according this we define
     * the new line.
     *
     * @param x1 the x 1 of the start point of the line
     * @param y1 the y 1 of the start point
     * @param x2 the x 2 of the end point of the line
     * @param y2 the y 2 of the end point of the line
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point startPoint = new Point(x1, y1);
        Point endPoint = new Point(x2, y2);
        this.startPoint = startPoint;
        this.endPoint = endPoint;

    }

    /**
     * Equals values boolean.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public boolean equalsValues(double x, double y) {
        return Math.abs(x - y) <= EPSILON;
    }


    /**
     * <p> we find the intersction points of the line in the rectangle and keeps them in list, after this
     * we find the closet intersection for the start of the line if we not find a new point we return
     * null-by check this  in using default point that we defined.</p>
     *
     * @param rect the rect
     * @return the point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //we find the intersection point of the tringle with line
        List<Point> list = rect.intersectionPoints(new Line(this.startPoint, this.endPoint, Color.black));
        // define a default point for return,if we not find enother point its means us that line doesnt intesction
        //with  the tringle
        Point closetintersection = new Point(-10000000, -10000000);
        for (Point point : list) {
            // if the point are closet so he will be the new closet point
            if (point != null) {
                if (point.distance(this.startPoint) < closetintersection.distance(this.startPoint)) {
                    closetintersection = point;
                }
            }
        }
        if (closetintersection.equals(new Point(-10000000, -10000000))) {
            return null;
        }
        return closetintersection;
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return startPoint.distance(endPoint);
    }

    /**
     * the function will return the middle point of the line by cacualte the middle point between the
     * start point and the end point according the method to caculate middle between 2 point.
     *
     * @return the middle point of the line
     */
// Returns the middle point of the line
    public Point middle() {
        double xMiddle = (this.startPoint.getX() + this.endPoint.getX()) / 2;
        double yMiddle = (this.startPoint.getY() + this.endPoint.getY()) / 2;
        return new Point(xMiddle, yMiddle);
    }

    /**
     * the function will return the point when the line start.
     *
     * @return the start point of the line
     */
// Returns the start point of the line
    public Point start() {
        return this.startPoint;
    }

    /**
     * the function will return the point was the line end.
     *
     * @return the end point of the line
     */
// Returns the end point of the line
    public Point end() {
        return this.endPoint;
    }

    /*first we need functions for caculate the incline of each line,and the b from ax+b of line equation
    after we had this parameters we can subtract each from another, divide them if the incline are'nt
    equal and get the intersection point of them.
     */

    /**
     * the function caculate the incline of line according the equation of incline of line.
     * y of the end point - y of the start point divide the x of the end point- x of the start point.
     * but we had special case when the dx is 0 and we need to return y because we cant divide in 0
     * so if is the case send 0 as a incline,else sand the dy -dx.
     *
     * @return the incline of the line
     */
    public double getIncline() {
        double y = (this.endPoint.getY() - this.startPoint.getY());
        double x = this.endPoint.getX() - this.startPoint.getX();
        if (x == 0) {
            return 0;
        } else {
            return y / x;
        }
    }

    /**
     * <p>
     * the function caculate the incline of line according the equation of incline of line.
     * y of the end point - y of the start point divide the x of the end point- x of the start point.
     * this method change from previous by this he get arugments and not executed on the object himself.
     * he exactued on aarguments he get.
     * </p>
     *
     * @param other other line he get
     * @return the incline of the line
     */
    public double getIncline(Line other) {
        double y = (other.endPoint.getY() - other.startPoint.getY());
        double x = other.endPoint.getX() - other.startPoint.getX();
        if (x == 0) {
            return 0;
        } else {
            return y / x;
        }
    }

    /**
     * the function caculate the incline of line 1- incline of line 2.
     * the function caculate the incline of other line and subtract him from the incline of original incline
     *
     * @param other other line
     * @return the incline mutel of lines- incline of line 1 - incline of line 2
     */
    public double getInclineMutel(Line other) {
        double inclineFirst = getIncline();
        double inclineSecond = getIncline(other);
        return inclineFirst - inclineSecond;

    }


    /**
     * Gets b of line from equation of line ax+b.
     * the function get a point on the line, and his incline and places the point for caculate the b of the line
     * according the equation of find b
     *
     * @param y       the y value of point on the line
     * @param x       the x value of point on the line
     * @param incline the incline of line
     * @return the b of the line
     */
    public double getB(double y, double x, double incline) {
        return y - (incline * x);
    }

    /**
     * the function caculate the b of line 1- b of line 2.
     * the function caculate the b of other line and subtract him from the b of original incline
     *
     * @param other other line
     * @return the b mutel of lines- b of line 1 - b of line 2
     */
    public double getBMutel(Line other) {
        double inclineFirst = getIncline();
        double inclineSecond = getIncline(other);
        double bFirst = getB(this.startPoint.getY(), this.startPoint.getX(), inclineFirst);
        double bSecond = getB(other.startPoint.getY(), other.startPoint.getX(), inclineSecond);
        return bSecond - bFirst;
    }

    /**
     * <p>
     * the function caculate the intersection point of the object with another line, by places one
     * equation of line front another, subtract one incline from another by method ,do as same for the b
     * and divide b by the incline.
     * special case: if the subtract from one line incline from another give us null its means us a few things
     * we need to check  few case and return by there values: one case we check if the lines are equal and we
     * return null beacuse the unit, second if they depend lineary so we send null, three case if they  diagnoal to
     * axis so we check if they unit or they had intersection point, and four if they parrall so we return
     * a special value for to know they are not unit.
     * </p>
     *
     * @param other other line
     * @return the intersection point of the object with another line
     */
    public Point intersectionWith(Line other) {
        double inclineMutel = getInclineMutel(other);
        double inclineFirst = getIncline();
        double inclineSecond = getIncline(other);
        if (inclineMutel == 0) {
            //if this lines has equal incline there is a change that the lines are equal each to enother and we check
            //this.
            if (equals(other)) {
                return null;
            }
            // now we check if the incline arent 0 so we check case they are depend lineray one on another.
            if (inclineFirst != 0 && inclineSecond != 0) {
                if (theyhadcommonpoint(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                    return returncommon(this.startPoint, this.endPoint, other.startPoint, other.endPoint);
                }
                if (dependinanother(other)) {
                    return null;
                }
            } else {
                /* in this situation we check if  the both of incline are equal to 0 ,in the case when one is zero
                 * we check in the case whan incline mutel isnt 0, so if we see that both incline are zero its
                 * means us that the lines are diagonal to axis so we check the intersection: if they had
                 * common area so the lines unit  together, if thay had common point in the start point or in
                 * the end point so this is the intersection point, the next case is the case when they had
                 * common value point in the x or y and not had in other values so we return , and the last case
                 * when they had diagonal so we return the diagonal*/
                if (inclineFirst == 0 && inclineSecond == 0) {
                    if (theyhadcommonarea(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                        return null;
                    } else {
                        if (theyhadcommonpoint(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                            return returncommon(this.startPoint, this.endPoint, other.startPoint, other.endPoint);
                        }
                    }
                    if (theyhadcommonareainx(new Line(this.startPoint, this.endPoint, Color.black), other)
                            || theyhadcommonareainy(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                        return NOTINTERSECTION;
                    }
                    if (theyhaddiagonalintersection(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                        return diagnoalintersection(new Line(this.startPoint, this.endPoint, Color.black), other);
                    }
                } else {
                    // they are parallal and they had equals incline.
                    return NOTINTERSECTION;
                }
            }
        } else {
            /* in this case the incline of two lines aren't equal so there is intersection point.
            before we check the intersection when one of the incline are 0 and we send to special func for this
            and if they are both noet zero we cacalue them by gets the b mutel and incline mutel and divide
            b by incline and we puts in one of the line equation for getting the y value.
             */
            if (theyhadcommonpoint(new Line(this.startPoint, this.endPoint, Color.black), other)) {
                return returncommon(this.startPoint, this.endPoint, other.startPoint, other.endPoint);
            }
            double intersectionPointX, intersectionPointY;
            double bFirst = getB(this.startPoint.getY(), this.startPoint.getX(), inclineFirst);
            double bMutel = getBMutel(other);
            double bSecond = getB(other.startPoint.getY(), other.startPoint.getX(), inclineSecond);
            if (inclineFirst == 0) {
                return caculatewhenonezero(inclineSecond, bSecond, this.startPoint, this.endPoint);
            }
            if (inclineSecond == 0) {
                return caculatewhenonezero(inclineFirst, bFirst, other.startPoint, other.endPoint);
            }

            intersectionPointX = bMutel / inclineMutel;
            intersectionPointY = (intersectionPointX * inclineFirst) + bFirst;
            return new Point(intersectionPointX, intersectionPointY);
        }
        return NOTINTERSECTION;
    }

    /**
     * the method return us boolean  express if the lines are intersction or no .
     * <p>
     * the method are getting the intersection point of the lines according the method of getting
     * the intersection point in the previous method,now we checking if the lines are equal or parallel if they
     * are we return boolean according the answer.
     * if the lines arent equal or parallel we check if the intersection point are actuall on the line x values
     * and if he are so we return true, if no we return false.
     * by the end of function if we not return value we return false.
     * </p>
     *
     * @param other other line
     * @return boolean express if the lines are intersection or no.
     */
    public boolean isIntersecting(Line other) {
        Point intersectionPoint = intersectionWith(other);
        //if we get a null its means us the lines are equal each to another and we return true
        if (intersectionPoint == null) {
            return true;
        }
        // if we get this values its means us the lines are parall and they are not equal each to another
        if (intersectionPoint.equals(NOTINTERSECTION)) {
            return false;
        }
        /* if the lines are not the same in incline,and we hava a x value to intesection point and y value to
        intersection point ite means us that we had intersection point,now we need to check if the
        values of the intersction point are really in the defines of the lines or the intersection just in the
        continue of the lines,so we check according  the start point and end point of each line if we find that
       the x value of  intersection point are in the limit of the start point and end point of each line
       its means us that the intesection point in the limit of lines
         */
        // lines one in this mention is our lines class, and line two is another lines that check if he interseection
        // in our line.
        // if the intersection point between the start point and end point of each line.
        if ((pointonline(intersectionPoint, new Line(other.startPoint, other.endPoint, Color.black))
                && pointonline(intersectionPoint, new Line(this.startPoint, this.endPoint, Color.black)))
                //option 2 if the intersection  point between the end point and start point of line 1 and start point
                //  and end line of line 2
                || (pointonline(intersectionPoint, new Line(this.endPoint, this.startPoint, Color.black))
                && pointonline(intersectionPoint, new Line(other.startPoint, other.endPoint, Color.black)))
                //option 3 if the intersection  point between the end point and start point of line 2 and start point
                //and end line of line 1
                || (pointonline(intersectionPoint, new Line(other.endPoint, other.startPoint, Color.black))
                && pointonline(intersectionPoint, new Line(this.startPoint, this.endPoint, Color.black)))
                //option 4 if the intersection point between the end point and start point of line 1 and the
                // end point and start point of line 2
                || (pointonline(intersectionPoint, new Line(other.endPoint, other.startPoint, Color.black))
                && pointonline(intersectionPoint, new Line(this.endPoint, this.startPoint, Color.black)))) {
            return true;
        }
        return false;
    }

    /**
     * the method return boolean express if line 1 is equal to line 2.
     * <p>
     * the method are checking if line 1 is equal to line 2 acorrding the start and end point of each
     * line, if the start point of line is the same start point of other line or he is the end, and the
     * end point of line is the end of other line, or according the start point, the lines are the same
     * and they equal and we return true
     * </p>
     *
     * @param other another line to equal.
     * @return boolean express if the lines are equal or not.
     */
// equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return ((this.startPoint.equals(other.startPoint) && this.endPoint.equals(other.endPoint))
                || (this.startPoint.equals(other.endPoint) && this.endPoint.equals(other.startPoint)));
    }

    /**
     * Checks if a given point with a specified x value is on a line segment between two other points.
     * <p>
     * This method checks whether a given point with a specified x value lies on a line segment
     * between two other points, represented by their x and y coordinates. It does this by
     * checking whether the x value of the given point lies between the x values of the
     * starting and ending points of the line segment. If the given point lies on the line
     * segment, this method returns true; otherwise, it returns false.
     * </p>
     * * @param xPoint     the x value of the point to be checked
     * * @param startPoint the starting point of the line segment
     * * @param endPoint   the ending point of the line segment
     * * @return true if the point is on the line segment, false otherwise
     *
     * @param xPoint     the x point
     * @param startPoint the start point
     * @param endPoint   the end point
     * @return the boolean
     */
    public boolean pointinhisxvaluesonline(double xPoint, Point startPoint, Point endPoint) {
        return xPoint >= startPoint.getX() && xPoint <= endPoint.getX()
                || xPoint <= startPoint.getX() && xPoint >= endPoint.getX();
    }

    /**
     * <p>
     * its like the x method.
     * </p>
     *
     * @param yPoint     the y point
     * @param startPoint the start point
     * @param endPoint   the end point
     * @return the boolean
     */
    public boolean pointinhisYvaluesonline(double yPoint, Point startPoint, Point endPoint) {
        return yPoint >= startPoint.getY() && yPoint <= endPoint.getY()
                || yPoint <= startPoint.getY() && yPoint >= endPoint.getY();
    }

    /**
     * <p>
     * the function check if point are on line, he check if the point in his values are bigger from start point
     * or smaller and accordingly on the lastpoint.
     * </p>
     *
     * @param point the point
     * @param line  the line
     * @return the boolean
     */
    public boolean pointonline(Point point, Line line) {
        return pointinhisxvaluesonline(point.getX(), line.startPoint, line.endPoint)
                && pointinhisYvaluesonline(point.getY(), line.startPoint, line.endPoint);
    }

    /**
     * Returns the mutual point between two lines defined by four points.
     * and if they don not had the method return null.
     *
     * @param x1 The first point on the first line.
     * @param y1 The second point on the first line.
     * @param x2 The first point on the second line.
     * @param y2 The second point on the second line.
     * @return The mutual point between the two lines. If the lines are parallel or do not intersect, returns null.
     */
    public Point returncommon(Point x1, Point y1, Point x2, Point y2) {
        if (x1.equals(x2)) {
            return x1;
        }
        if (y1.equals(y2)) {
            return y1;
        }
        if (x1.equals(y2)) {
            return x1;
        }
        if (x2.equals(y1)) {
            return x2;
        }
        return null;
    }


    /**
     * Checks whether this line depends linearly on another line.
     * <p>
     * The method checks if the incline and the y-intercept of both lines are proportional.
     * If they are proportional, the method returns true,
     * indicating that this line depends linearly on the other line.
     * </p>
     *
     * @param other The other line to check against.
     * @return true if this line depends linearly on the other line, false otherwise.
     */
    public boolean dependinanother(Line other) {
        double inclineFirst = this.getIncline();
        double inclineSecond = other.getIncline();
        double getBOne = this.getB(this.startPoint.getY(), this.startPoint.getX(), inclineFirst);
        double getBTwo = other.getB(other.startPoint.getY(), other.startPoint.getX(), inclineSecond);
        return inclineFirst / inclineSecond == getBOne / getBTwo;
    }

    /**
     * <p>This function gets two lines with an incline of 0, meaning they are diagonal to the axis.
     * It checks if the lines are diagonal to the x-axis and have the same x value. If so,
     * it sends them to a function to check if the lines are unit in y values. If the lines are diagonal to the y-axis
     * and have the same y value, it sends them to a function to check if they are unit in x values.
     * If the lines do not have the same value in the start and end points, the function returns false.</p>
     *
     * @param lineone lineone
     * @param linetwo linetwo
     * @return boolean if the lines are intersection or no
     */
    public boolean theyhadcommonarea(Line lineone, Line linetwo) {
        // if the lines has the same x value we check if they are unit in the y axis
        if (theyhadcommonareainx(lineone, linetwo)) {
            return theyhadcommonareainYarea(lineone, linetwo);
        }
        // if the lines has the same y value we check if the unit in x axis
        if (theyhadcommonareainy(lineone, linetwo)) {
            return theyhadcommonareainXarea(lineone, linetwo);
        }
        // if they dont had value that equals so the diagonal lines arent unit.
        return false;
    }


    /**
     * the function return if the lines that diagnoal to y axis unit together or no
     * <p>
     * the function gets lines that diagnoal to  y axis.
     * the function detrminate the max value and min value of y from each line and check if they had
     * a common point in edges its means us they not had common area,if they do not had we check for each case
     * whice max of lines are bigger, if line had  max in y bigger from another line and his min value bigger from
     * the max value of line they not intersection. if one of case not true its means us the lines can have
     * a commen area and we return true.
     * </p>
     *
     * @param lineone our line of the class
     * @param linetwo the linetwo
     * @return the boolean if they unit together
     */
    public boolean theyhadcommonareainYarea(Line lineone, Line linetwo) {
        double maxone = Math.max(lineone.startPoint.getY(), lineone.endPoint.getY());
        double minone = Math.min(lineone.startPoint.getY(), lineone.endPoint.getY());
        double maxtwo = Math.max(linetwo.startPoint.getY(), linetwo.endPoint.getY());
        double mintwo = Math.min(linetwo.startPoint.getY(), linetwo.endPoint.getY());
        if (theyhadcommon(maxone, minone, maxtwo, mintwo)) {
            return false;
        }
        if (maxone > maxtwo) {
            if (minone > maxtwo) {
                return false;
            }
        } else {
            if (maxtwo > maxone) {
                if (mintwo > maxone) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * the function return if the lines that diagnoal to x axis unit together or no
     * <p>
     * the function gets lines that diagnoal to x axis.
     * the function detrminate the max value and min value of x from each line and check if they had
     * a common point in edges its means us they not had common area,if they do not had we check for each case
     * whice max of lines are bigger, if line had bigger max from another line and his min value bigger from
     * the max value of line they not intersection. if one of case not true its means us the lines can have
     * a commen area and we return true.
     * </p>
     *
     * @param lineone our line of the class
     * @param linetwo the linetwo
     * @return the boolean if they unit together
     */
    public boolean theyhadcommonareainXarea(Line lineone, Line linetwo) {
        double maxone = Math.max(lineone.startPoint.getX(), lineone.endPoint.getX());
        double minone = Math.min(lineone.startPoint.getX(), lineone.endPoint.getX());
        double maxtwo = Math.max(linetwo.startPoint.getX(), linetwo.endPoint.getX());
        double mintwo = Math.min(linetwo.startPoint.getX(), linetwo.endPoint.getX());
        if (theyhadcommon(maxone, minone, maxtwo, mintwo)) {
            return false;
        }
        if (maxone > maxtwo) {
            if (minone > maxtwo) {
                return false;
            }
        } else {
            if (maxtwo > maxone) {
                if (mintwo > maxone) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks whether two lines have mutual points at their starting and ending points.
     *
     * <p>
     * The method checks if the maximum and minimum values of the two lines' starting and ending points are equal.
     * If they are equal, the method returns true,
     * indicating that the two lines have mutual points at their starting and ending points.
     * </p>
     *
     * @param maxone The maximum value of the first line's starting and ending points.
     * @param minone The minimum value of the first line's starting and ending points.
     * @param maxtwo The maximum value of the second line's starting and ending points.
     * @param mintwo The minimum value of the second line's starting and ending points.
     * @return true if the two lines have mutual points at their starting and ending points, false otherwise.
     */
    public boolean theyhadcommon(double maxone, double minone, double maxtwo, double mintwo) {
        return equalsValues(maxone, mintwo) || equalsValues(maxtwo, minone);
    }

    /**
     * <p>
     * the function check if the lines has a poine mutel in the edges of lines,the function check the start
     * point and end point of each line with the another.
     * </p>
     *
     * @param one our line of the class
     * @param two the second line that check if he intersection with our line
     * @return the boolean if thay had a common point in edges.
     */
    public boolean theyhadcommonpoint(Line one, Line two) {
        return one.endPoint.equals(two.startPoint) || two.endPoint.equals(one.startPoint)
                || one.startPoint.equals(two.startPoint) || one.endPoint.equals(two.endPoint);
    }

    /**
     * the function result the intersection point when one of the lines diagnoal to axis.
     * <p>
     * the function check  the case of the line that his incline 0 if the line is the x axis or the
     * y axis we cacualte the intersection point by putting x=0 or y=0 accordingly and
     * cacualte the x or y value in the equation line by placement.
     * if the line that incline 0 has the same x value that not 0 its means
     * us the intersection point is the x value and we placement this value in the another line.
     * same we doing if the y value are equal and the line that incline 0 diagnoal to y axis.
     * </p>
     *
     * @param incline    the incline of line that not 0
     * @param b          the b of line that his incline not 0
     * @param startPoint the start point of line that his incline 0
     * @param endPoint   the end point of line that his incline 0
     * @return the point that the lines intersection.
     */
    public Point caculatewhenonezero(double incline, double b, Point startPoint, Point endPoint) {
        Point point;
        if (startPoint.getX() == 0 && endPoint.getX() == 0) {
            point = new Point(0, b);
            return point;
        }
        if (equalsValues(startPoint.getX(), endPoint.getX())) {
            double newvalue = (startPoint.getX() * incline) + b;
            point = new Point(startPoint.getX(), newvalue);
            return point;
        }
        if (equalsValues(startPoint.getY(), endPoint.getY()) && startPoint.getY() != 0) {
            double newvaluesecond = (endPoint.getY() - b) / incline;
            point = new Point(newvaluesecond, startPoint.getY());
            return point;
        }
        double value = (-b) / incline;
        point = new Point(value, 0);
        return point;
    }

    /**
     * <p>
     * the function gets three nums and find if x in the range of y and z.
     * its for help us in diagnoal lines.
     * </p>
     *
     * @param x the x
     * @param y the y
     * @param z the z
     * @return the boolean if x in y and z range.
     */
    public boolean inrange(double x, double y, double z) {
        return x >= y && x <= z;
    }

    /**
     * the function return if the lines thats one diagnoal to x axis and one to y axis are intersection
     * <p>
     * the function check whice line are diagnoal to x axis and whice for y axis, the lines cant be both to
     * same axis beacuse we chack this case earliar in out intersection func.
     * after he find the range of line, he check if from the line that diagnoal to y axis has a point that get
     * inside the line that diagnoal to x axis,in his x value and in the y value if he find return true,else
     * return false.
     * </p>
     *
     * @param one the one
     * @param two the two
     * @return the boolean
     */
    public boolean theyhaddiagonalintersection(Line one, Line two) {
        // this is the check for our line  class diagnoal to x axis, and another line to y axis
        if (equalsValues(one.startPoint.getX(), one.endPoint.getX())
                && equalsValues(two.startPoint.getY(), two.endPoint.getY())) {
            if (two.endPoint.getX() >= one.startPoint.getX() && (inrange(two.endPoint.getY(), one.startPoint.getY(),
                    one.endPoint.getY()) || inrange(two.endPoint.getY(), one.endPoint.getY(),
                    one.startPoint.getY()))
                    || two.startPoint.getX() >= one.startPoint.getX()
                    && (inrange(two.startPoint.getY(), one.startPoint.getY(),
                    one.endPoint.getY()) || inrange(two.endPoint.getY(), one.endPoint.getY(),
                    one.startPoint.getY()))) {
                return true;
            }
            // this is the check for our line class diagnoal to y axis, and another line to x axis
        } else if (equalsValues(two.startPoint.getX(), two.endPoint.getX())
                && equalsValues(one.startPoint.getY(), one.endPoint.getY())) {
            if (one.endPoint.getX() >= two.startPoint.getX() && (inrange(one.endPoint.getY(), two.startPoint.getY(),
                    two.endPoint.getY()) || inrange(one.endPoint.getY(), two.endPoint.getY(),
                    two.startPoint.getY()))
                    || one.startPoint.getX() >= two.startPoint.getX()
                    && (inrange(one.startPoint.getY(), two.endPoint.getY(),
                    two.startPoint.getY()) || inrange(one.startPoint.getY(), two.startPoint.getY(),
                    two.endPoint.getY()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * the function return the intersection point of diagonal lines when one diagnoal to x axis and second to
     * y lines.
     * <p>
     * the function check  whice line are diagnoal to x axis and whice to y axis, in each case the function return
     * the x values of line that return to x axis any y value of line that diagnoal to y axis beacuse if
     * they intersection they are in this point.
     * </p>
     *
     * @param one our line of class the check if he intersection with another line
     * @param two the second line
     * @return the intersection point of the lines.
     */
    public Point diagnoalintersection(Line one, Line two) {
        if (equalsValues(one.startPoint.getX(), one.endPoint.getX())
                && equalsValues(two.startPoint.getY(), two.endPoint.getY())) {
            return new Point(one.startPoint.getX(), two.startPoint.getY());
        }
        return new Point(two.startPoint.getX(), one.startPoint.getY());
    }

    /**
     * .
     * <p>
     * the function check if the x values of the lines are equal and if they are its means us the lines are diagonal
     * to x axis</p>
     *
     * @param one    our line of the class
     * @param second the second line for check  if intersection
     * @return boolean if there x values of the lines are equal.
     */
    public boolean theyhadcommonareainx(Line one, Line second) {
        return equalsValues(one.startPoint.getX(), second.startPoint.getX())
                && equalsValues(one.startPoint.getX(), second.endPoint.getX())
                && equalsValues(one.startPoint.getX(), second.endPoint.getX());

    }

    /**
     * .
     * <p>
     * the function check if the y values of the lines are equal and if they are its means us the lines are diagonal
     * to y axis</p>
     *
     * @param one    our line of the class
     * @param second the second line for check  if intersection
     * @return boolean if there y values of the lines are equal.
     */
    public boolean theyhadcommonareainy(Line one, Line second) {
        return equalsValues(one.startPoint.getY(), second.startPoint.getY())
                && equalsValues(one.startPoint.getY(), second.endPoint.getY())
                && equalsValues(one.startPoint.getY(), second.endPoint.getY());
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
    }

    @Override
    public void timePassed() {
    }
}
