package fr.campus.dungeoncrawler.game;

import java.util.Random;

/**
 * Represents a six-sided dice used in the game.
 */
public class Dice {
    private final Random random = new Random();

    /**
     * Rolls the dice and generates a value between 1 and 6.
     *
     * @return 1 for testing in Iteration 4
     */
    public int roll(){
        return 1;
        //return random.nextInt(6) + 1;

    }
}
