package fr.campus.dungeoncrawler.model.equipment.offensive.spell;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Wizard;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

public class Lightning extends Spell {
    public Lightning() {
        super( 2, "Lightning");
    }

    @Override
    public String toString() {
        return "This cell contains a Lightning which is an offensive equipment with "+
                "attack level of " +  getAttackLevel();
    }

    /**
     * Handles the interaction between Lightning cell and the character
     * who lands on it.
     *
     * @param character the character interacting with Lightning cell
     */
    @Override
    public void interact(Character character) {
        if (character instanceof Wizard) {
            OffensiveEquipment currentEquipment = character.getOffensiveEquipment();
            if (currentEquipment == null || getAttackLevel() > currentEquipment.getAttackLevel()){
                character.setOffensiveEquipment(this);
                System.out.println(character.getName() + " picked up the lightening.");
            } else {
                System.out.println("The current spell is better than the lightening.");
                System.out.println();
            }
        } else {
            System.out.println("Only a wizard can use a lightening!");
            System.out.println();
        }
    }
}
