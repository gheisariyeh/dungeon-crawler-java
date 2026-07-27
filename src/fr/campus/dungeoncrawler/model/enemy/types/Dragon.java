package fr.campus.dungeoncrawler.model.enemy.types;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.enemy.Enemy;

public class Dragon extends Enemy {
    /**
     * Creates an enemy.
     */
    public Dragon() {
        super("Dragon", 15, 4);
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "type='" + "enemy" + '\'' +
                ", lifePoints=" + getLifePoints() +
                ", strength=" + getStrength() +
                '}';
    }

    /**
     * Handles the interaction between Dragon and the character
     * who lands on it.
     *
     * @param character the character interacting with Dragon
     */
    @Override
    public void interact(Character character) {
        System.out.println("Dragon");
    }

}
