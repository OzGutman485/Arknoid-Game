package geometrytools;

import Game.GameLevel;
import biuoop.DrawSurface;
import spritesGame.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Rectangle implements Sprite {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * Instantiates a new object a Rectangle- that we defined according his left point, and his weidth and this lentgh.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     * @param color     the color
     */
//constructor
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * <p> this method is finding the intersection point of line in rectangle, we find the lines of the
     * rectangle ,and we check every line if the line we get is intersection with the lines of
     * rectangle and by this we can find a list for the intersection of the line in rectangle, every intersection
     * point we find we check if he in the list or no, for not be two intersection point of the line in rectangle.
     * </p>
     *
     * @param line the line
     * @return the java . util . list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();
        //we find the vertex of the tringle
        Point downleft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
        Point upperRight = new Point(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY());
        Point downRight = new Point(this.upperLeft.getX() + this.getWidth(),
                this.upperLeft.getY() + this.getHeight());
        // we create the lines the define the tringle
        Line diagnoaltoaxisXLeft = new Line(this.upperLeft, downleft, Color.black);
        Line diagnoaltoaxisXRight = new Line(upperRight, downRight, Color.black);
        Line diagnoaltoaxisYUp = new Line(this.upperLeft, upperRight, Color.black);
        Line dianoaltoaxisYDown = new Line(downleft, downRight, Color.black);
        //we find the intersection with lines of tringle and add him to list, we check the point not in list if he not
        // added him to the list..
        if (line.isIntersecting(diagnoaltoaxisXLeft)) {
            list.add(line.intersectionWith(diagnoaltoaxisXLeft));
        }
        if (line.isIntersecting(diagnoaltoaxisXRight) && inlistinter(line.intersectionWith(diagnoaltoaxisXRight),
                list)) {
            list.add(line.intersectionWith(diagnoaltoaxisXRight));
        }
        if (line.isIntersecting(diagnoaltoaxisYUp) && inlistinter(line.intersectionWith(diagnoaltoaxisYUp), list)) {
            list.add(line.intersectionWith(diagnoaltoaxisYUp));
        }
        if (line.isIntersecting(dianoaltoaxisYDown) && inlistinter(line.intersectionWith(dianoaltoaxisYDown), list)) {
            list.add(line.intersectionWith(dianoaltoaxisYDown));
        }
        // return list.
        return list;
    }

    /**
     * <p>this method are check if the point of intersection we find in the list or not, if he is
     * we send true,else return false.</p>
     *
     * @param point the point
     * @param list  the list
     * @return the boolean
     */
    public boolean inlistinter(Point point, List<Point> list) {
        for (Point p : list) {
            if (p != null && p.equals(point)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left point of the rectangle.
     *
     * @return the upper left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * this function allowes us to draw the rectangle in the drawsurface we get to the screen by his left point and
     * his height and width.
     *
     * @param drawSurface the draw surface
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(this.color);
        drawSurface.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getX(),
                (int) this.getWidth(), (int) this.getHeight());
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
    }

    @Override
    public void timePassed() {
    }
}

