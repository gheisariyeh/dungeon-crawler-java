package fr.campus.dungeoncrawler.model.equipment.offensive.spell;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

/**
 * Represents a spell used by a wizard.
 */
public class  Spell extends OffensiveEquipment {
    public Spell(int attackLevel, String name) {
        super("Spell", attackLevel, name);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "type='" + getType() + '\'' +
                ", attackLevel=" + getAttackLevel() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public void interact(Character character) {
        //Implemented in the childs
    }
}
