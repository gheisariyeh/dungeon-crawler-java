package fr.campus.dungeoncrawler.model.equipment.defensive.potion;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Warrior;
import fr.campus.dungeoncrawler.model.character.types.Wizard;

public class LargePotion extends Potion{
    /**
     * Creates a potion with the specified defense level and name.
     */
    public LargePotion() {
        super(5, "Large Potion");
    }

    @Override
    public String toString() {
        return "LargePotion{" +
                "type='" + getType() + '\'' +
                ", defenseLevel=" + getDefenseLevel() +
                '}';
    }


    /**
     * Handles the interaction between LargePotion cell and the character
     * who lands on it.
     *
     * @param character the character interacting with LargePotion cell
     */
    @Override
    public void interact(Character character) {
        int currentHealth = character.getHealthLevel();
        int maxHealth;

        if (character instanceof Warrior) {
            maxHealth = 10;
        } else if (character instanceof Wizard) {
            maxHealth = 7;
        } else {
            return;
        }

        int newHealth = Math.min(currentHealth + getDefenseLevel(), maxHealth);

        character.setHealthLevel(newHealth);

        System.out.println(
                character.getName()
                        + " used a large potion. Health: "
                        + currentHealth
                        + " -> "
                        + newHealth
        );
    }
}
