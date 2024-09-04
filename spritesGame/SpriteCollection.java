package spritesGame;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class SpriteCollection {
    private List<Sprite> list;

    /**
     * <p>we defined the list of the object of our game its will help us to do method more collect of
     * the objects like move him or draw him in the game.</p>
     */
    public SpriteCollection() {
        this.list = new ArrayList<>();
    }

    /**
     * we demand every sprite in list of sprite to join to list of sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * Notify all time passed and every sprite will do the method that special to him.
     */
// call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        for (Sprite s : this.list) {
            s.timePassed();
        }
    }

    /**
     * we draw the sprite of the game.
     *
     * @param d the d
     */
// call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.list) {
            s.drawOn(d);
        }
    }

    /**
     * Gets sprite list.
     *
     * @return the sprite list
     */
    public List<Sprite> getSpriteList() {
        return this.list;
    }

    /**
     *  this function helps us for change the Sets list.
     *
     * @param list the list
     */
    public void setList(List<Sprite> list) {
        this.list = list;
    }
}
