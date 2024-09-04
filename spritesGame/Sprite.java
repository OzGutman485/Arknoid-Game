
package spritesGame;

import Game.GameLevel;
import biuoop.DrawSurface;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public interface Sprite {
    /**
     * <p> we create the interface of sprite in game, sprite is a object with common method for all
     * and every sprite do this is his special way.</p>
     *
     * @param d the drawsurface that draw object in game.
     */

    void drawOn(DrawSurface d);

    /**
     * <p> every object  in sprite we demand for him to join to list of object that we hold for contiune the game.</p>
     *
     * @param gameLevel the game
     */
    void addToGame(GameLevel gameLevel);

    /**
     * we call every object and say him the time passed and he need to do his behivoer accroding the time passed.
     */
    void timePassed();
}
