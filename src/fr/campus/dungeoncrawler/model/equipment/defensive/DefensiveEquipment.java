package fr.campus.dungeoncrawler.model.equipment.defensive;

import fr.campus.dungeoncrawler.model.cell.Cell;
import fr.campus.dungeoncrawler.model.character.Character;

/**
 * Represents defensive equipment that increases
 * the defense capacity of a character.
 */
public abstract class DefensiveEquipment implements Cell {
    // Fields
    private String type;
    private int defenseLevel;
    private String name;

    /**
     * Creates offensive equipment.
     *
     * @param type the equipment type
     * @param defenseLevel the defense level
     * @param name the equipment name
     */
    public DefensiveEquipment(String type, int defenseLevel, String name) {
        this.type = type;
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DefensiveEquipment{" +
                "type='" + type + '\'' +
                ", defenseLevel=" + defenseLevel +
                ", name='" + name + '\'' +
                '}';
    }
}
