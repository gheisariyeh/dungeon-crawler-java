package fr.campus.dungeoncrawler.model.enemy.types;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.enemy.Enemy;

public class Goblin extends Enemy {
    /**
     * Creates an enemy.
     */
    public Goblin() {
        super("Goblin", 6, 1);
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "type='" + "enemy" + '\'' +
                ", lifePoints=" + getLifePoints() +
                ", strength=" + getStrength() +
                '}';
    }

    /**
     * Handles the interaction between Goblin and the character
     * who lands on it.
     *
     * @param character the character interacting with Goblin
     */
    @Override
    public void interact(Character character) {
        System.out.println("Goblin");
    }
}
