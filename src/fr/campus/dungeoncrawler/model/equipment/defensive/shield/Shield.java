package fr.campus.dungeoncrawler.model.equipment.defensive.shield;

import fr.campus.dungeoncrawler.model.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeoncrawler.model.character.Character;


/**
 * Represents a shield used as defensive equipment.
 */
public class Shield extends DefensiveEquipment {

    /**
     * Creates a shield with the specified defense level and name.
     *
     * @param defenseLevel the defense bonus provided by the shield
     * @param name the name of the shield
     */
    public Shield(int defenseLevel, String name) {
        super("Shield", defenseLevel, "Shield");
    }

    @Override
    public String toString() {
        return "Shield{" +
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