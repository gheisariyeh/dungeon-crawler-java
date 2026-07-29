package fr.campus.dungeoncrawler.model.equipment.offensive.spell;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Wizard;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;


public class Fireball extends Spell {
    public Fireball() {
        super(7,"Fireball");
    }


    @Override
    public String toString() {
        return "This cell contains a Fireball which is an offensive equipment with "+
                "attack level of " +  getAttackLevel();
    }

    /**
     * Handles the interaction between Fireball cell and the character
     * who lands on it.
     *
     * @param character the character interacting with Fireball cell
     */
    @Override
    public void interact(Character character) {
        if (character instanceof Wizard) {
            OffensiveEquipment currentEquipment = character.getOffensiveEquipment();
            if (currentEquipment == null || getAttackLevel() > currentEquipment.getAttackLevel()){
                character.setOffensiveEquipment(this);
                System.out.println(character.getName() + " picked up the fireball.");
            } else {
                System.out.println("The current spell is better than the fireball.");
                System.out.println();
            }
        } else {
            System.out.println("Only a wizard can use a fireball.");
            System.out.println();
        }

    }
}
