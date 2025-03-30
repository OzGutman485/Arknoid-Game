
import Game.AnimationRunner;
import Game.GameFlow;

import Levels.DirectHitLevel;
import Levels.Green3;
import Levels.LevelInformation;
import Levels.WideEasy;
import RemoverObjectfromGame.Counter;
import biuoop.GUI;


import java.util.LinkedList;
import java.util.List;

/*******************************.
 * &author oz gutman < oz gutman@liva.biu.ac.il>
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Ass6Game {
    /**
     * <p>this is the entery for the game. </p>
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnimationRunner animationRunner = new AnimationRunner();
        GUI gui = animationRunner.getGui();
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        Counter counter = new Counter();
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            int num;
            if (args[i].matches("[1-3]+")) {
                num = Integer.parseInt(args[i]);
                if (num >= 1 && num <= 3) {
                    arr[i] = num;
                }
            }
        }
        List<LevelInformation> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                DirectHitLevel directHitLevel = new DirectHitLevel();
                list.add(directHitLevel);
            }
            if (arr[i] == 2) {
                WideEasy wideEasy = new WideEasy();
                list.add(wideEasy);
            }
            if (arr[i] == 3) {
                Green3 green3 = new Green3();
                list.add(green3);
            }
        }
        if (list.size() == 0) {
            DirectHitLevel directHitLevel = new DirectHitLevel();
            list.add(directHitLevel);
            WideEasy wideEasy = new WideEasy();
            list.add(wideEasy);
            Green3 green3 = new Green3();
            list.add(green3);
        }

        GameFlow gameFlow = new GameFlow(animationRunner, keyboard, counter);
        gameFlow.runLevels(list);
        animationRunner.getGui().close();
    }
}
