package fr.campus.dungeoncrawler.model.enemy;

import fr.campus.dungeoncrawler.model.cell.Cell;
import fr.campus.dungeoncrawler.model.character.Character;

/**
 * Represents an enemy located on the game board.
 */
public class Enemy implements Cell {

    private final String name;
    private int lifePoints;
    private final int strength;

    /**
     * Creates an enemy.
     *
     * @param name the enemy's name
     * @param lifePoints the enemy's life points
     * @param strength the enemy's attack strength
     */
    public Enemy(String name, int lifePoints, int strength) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Enemy: " + name
                + ", life: " + lifePoints
                + ", strength: " + strength;
    }

    @Override
    public void interact(Character character) {
        //to be implemented
    }
}