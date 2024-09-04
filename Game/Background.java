package Game;

import biuoop.DrawSurface;
import spritesGame.Sprite;

import java.util.List;

/**
 * The type Background.
 */
public class Background implements Sprite {
    private List<Sprite> list;

    /**
     * Instantiates a new Background that implement sprite and help us in level information.
     *
     * @param list the list
     */
    public Background(List<Sprite> list) {
        this.list = list;
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (Sprite sprite : this.list) {
            sprite.drawOn(d);
        }
    }

    @Override
    public void addToGame(GameLevel gameLevel) {

    }

    @Override
    public void timePassed() {

    }
}
