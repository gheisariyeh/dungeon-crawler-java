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


    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }



    @Override
    public String toString() {
        if (this.getLifePoints()>0)
            return "This cell contains a " + getName() +  " which is an enemy with "+
                    "lifePoints = " + getLifePoints() +
                    " and strength = " + getStrength();
        else
            return "This is an empty cell.";
    }

    /**
     * Handles the interaction between the enemies and the character
     * who lands on it.
     *
     * @param character the character interacting with the enemy
     */
    @Override
    public void interact(Character character) {
        int currentHealthLevel = character.getHealthLevel();
        character.setHealthLevel(currentHealthLevel - this.getStrength());
        System.out.println(getName() + " is not dead and he is attacking with strength of " + this.getStrength());
        System.out.println("Character's health level is decreasing from " + currentHealthLevel + " to " + character.getHealthLevel());
        System.out.println();
    }
}