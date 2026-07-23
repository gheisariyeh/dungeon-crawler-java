package fr.campus.dungeoncrawler.model.enemy;

import fr.campus.dungeoncrawler.model.cell.Cell;

/**
 * Represents an enemy located on the game board.
 */
public class Enemy extends Cell {

    private String name;
    private int lifePoints;
    private int strength;

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

    @Override
    public String toString() {
        return "Enemy: " + name
                + ", life: " + lifePoints
                + ", strength: " + strength;
    }
}