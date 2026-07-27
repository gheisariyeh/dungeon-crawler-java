package fr.campus.dungeoncrawler.model.equipment.defensive.shield;

import fr.campus.dungeoncrawler.model.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeoncrawler.model.character.Character;


public class SimpleShield extends DefensiveEquipment {
    /**
     * Creates offensive equipment.
     *
     * @param type         the equipment type
     * @param defenseLevel the defense level
     * @param name         the equipment name
     */
    public SimpleShield(String type, int defenseLevel, String name) {
        super("Shield", 2, "SimpleShield");
    }

    /**
     * Creates a shield with the specified defense level and name.
     */

    @Override
    public String toString() {
        return "SimpleShield{" +
                "type='" + getType() + '\'' +
                ", defenseLevel=" + getDefenseLevel() +
                ", name='" + getName() + '\'' +
                '}';
    }

    @Override
    public void interact(Character character) {
        //to be implemented
    }
}
