package fr.campus.dungeoncrawler.model.equipment.offensive.weapon;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Warrior;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

public class Sword extends Weapon {
    public Sword() {
        super(5, "Sword");
    }

    @Override
    public String toString() {
        return "This cell contains a Sword which is an offensive equipment with "+
                "attack level of " +  getAttackLevel();
    }

    /**
     * Handles the interaction between Sword cell and the character
     * who lands on it.
     *
     * @param character the character interacting with Sword cell
     */
    @Override
    public void interact(Character character) {
        if (character instanceof Warrior) {
            OffensiveEquipment currentEquipment = character.getOffensiveEquipment();
            if (currentEquipment == null || getAttackLevel() > currentEquipment.getAttackLevel()){
                character.setOffensiveEquipment(this);
                System.out.println(character.getName() + " picked up the sword.");
            } else {
                System.out.println("The current weapon is better than the sword.");
                System.out.println();
            }
        } else {
            System.out.println("Only a warrior can use a sword.");
            System.out.println();
        }
    }
}
