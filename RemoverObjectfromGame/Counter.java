package RemoverObjectfromGame;

/**
 * &author oz gutman < oz gutman@liva.biu.ac.il>.
 * &version 19.0.2 2023 03-27
 * id:3187600555
 */
public class Counter {
    private int numblocks;

    /**
     * Instantiates a new Counter of instance.
     */
    public Counter() {
        this.numblocks = 0;
    }

    /**
     * add number to current count.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.numblocks += number;
    }

    /**
     * // subtract number from current count.
     *
     * @param number the number
     */
    public void decrease(int number) {
        this.numblocks -= number;
    }

    /**
     * // get current count.
     *
     * @return the value
     */
    public int getValue() {
        return this.numblocks;
    }
}
