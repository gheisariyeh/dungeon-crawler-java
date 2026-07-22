package fr.campus.dungeoncrawler.model.equipment.defensive;

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
        super("Shield", defenseLevel, name);
    }
}