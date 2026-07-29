package fr.campus.dungeoncrawler.game.Dice;

import java.util.Random;

/**
 * Represents a six-sided dice used in the game.
 */
public class SixSidedDice implements Dice {
    private final Random random = new Random();

    /**
     * Rolls the dice and generates a value between 1 and 6.
     *
     * @return a number between 1 and 6 for movement
     */
    public int roll(){
        return random.nextInt(6) + 1;

    }
}
