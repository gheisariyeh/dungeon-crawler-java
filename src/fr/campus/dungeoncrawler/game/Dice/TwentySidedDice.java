package fr.campus.dungeoncrawler.game.Dice;

import java.util.Random;

public class TwentySidedDice implements Dice{

    private final Random random = new Random();

    /**
     * Rolls the dice and generates a value between 1 and 20 for combat.
     *
     * @return a number between 1 and 20
     */
    @Override
    public int roll() {
        return random.nextInt(20) + 1;
    }
}
