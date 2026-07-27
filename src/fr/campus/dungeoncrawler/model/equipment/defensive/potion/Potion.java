package fr.campus.dungeoncrawler.model.equipment.defensive.potion;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.equipment.defensive.DefensiveEquipment;

/**
 * Represents a healing potion used as defensive equipment.
 */
public class Potion extends DefensiveEquipment {

    /**
     * Creates a potion with the specified defense level and name.
     *
     * @param defenseLevel the defense bonus provided by the potion
     * @param name the name of the potion
     */
    public Potion(int defenseLevel, String name) {
        super("Potion", defenseLevel, name);
    }

    @Override
    public String toString() {
        return "Potion{" +
                "type='" + getType() + '\'' +
                ", defenseLevel=" + getDefenseLevel() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public void interact(Character character) {
        //Implemented in the childs
    }

}
