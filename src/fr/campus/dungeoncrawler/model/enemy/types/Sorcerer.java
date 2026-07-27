package fr.campus.dungeoncrawler.model.enemy.types;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.enemy.Enemy;

public class Sorcerer extends Enemy {

    /**
     * Creates an enemy.
     *
     */
    public Sorcerer() {
        super("Sorcerer", 9, 2);
    }

    @Override
    public String toString() {
        return "Sorcerer{" +
                "type='" + "enemy" + '\'' +
                ", lifePoints=" + getLifePoints() +
                ", strength=" + getStrength() +
                '}';
    }

    /**
     * Handles the interaction between Sorcerer and the character
     * who lands on it.
     *
     * @param character the character interacting with Sorcerer
     */
    @Override
    public void interact(Character character) {
        System.out.println("Sorcerer");
    }
}
