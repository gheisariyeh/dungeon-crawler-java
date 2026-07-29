package fr.campus.dungeoncrawler.model.equipment.defensive.potion;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Warrior;
import fr.campus.dungeoncrawler.model.character.types.Wizard;

public class StandardPotion extends Potion{
    /**
     * Creates a potion with the specified defense level and name.
     */
    public StandardPotion() {
        super(2, "StandardPotion");
    }

    @Override
    public String toString() {
        return "This cell contains a Standard Potion which is a defensive equipment with "+
                "defense Level of " + getDefenseLevel();
    }

    /**
     * Handles the interaction between StandardPotion cell and the character
     * who lands on it.
     *
     * @param character the character interacting with StandardPotion cell
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
        setDefenseLevel((currentHealth + getDefenseLevel()) - maxHealth);

        character.setHealthLevel(newHealth);

        System.out.println(character.getName() + " used a standard potion. Health: " + currentHealth + " -> " + newHealth);
        System.out.println("The rest of the Standard Potion of this cell is " + getDefenseLevel());
        System.out.println();

        }
}
