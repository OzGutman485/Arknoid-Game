package spritesGame;

import Game.GameLevel;
import biuoop.DrawSurface;
import RemoverObjectfromGame.Counter;

import java.awt.Color;

/**
 * &author oz gutman < oz gutman@liva.biu.ac.il>.
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class ScoreIndicator implements Sprite {
    private Counter scoredisplay;
    private String nameLevel;

    /**
     * Instantiates a new Score indicator of the points in game.
     *
     * @param scoredisplay the scoredisplay
     * @param nameLevel    the name level
     */
    public ScoreIndicator(Counter scoredisplay, String nameLevel) {
        this.scoredisplay = scoredisplay;
        this.nameLevel = nameLevel;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        d.drawText(150, 15, "Score:" + this.scoredisplay.getValue(), 15);
        d.drawText(500, 15, "Level Name:" + this.nameLevel, 15);
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void timePassed() {
    }

}
