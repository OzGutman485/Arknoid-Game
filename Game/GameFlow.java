package Game;

import java.util.List;

import RemoverObjectfromGame.Counter;
import biuoop.KeyboardSensor;
import Levels.LevelInformation;

/**
 * The type Game flow.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar      the ar
     * @param ks      the ks
     * @param counter the counter
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter counter) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        score = counter;
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Boolean win = false;
        int size = levels.size();
        for (int i = 0; i < size; i++) {
            LevelInformation levelInfo = levels.get(i);
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, this.score);
            level.initialize();
            while (level.getblocksnumber() != 0 && level.getnumballs() != 0) {
                level.run();
            }
            if (i == size - 1 && level.getblocksnumber() == 0) {
                win = true;
            }
            this.score = level.getScore();
            if (level.getnumballs() == 0) {
                break;
            }
        }
        Endscreen endscreen = new Endscreen(this.keyboardSensor, this.score.getValue(), win);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space", endscreen));
    }
}
