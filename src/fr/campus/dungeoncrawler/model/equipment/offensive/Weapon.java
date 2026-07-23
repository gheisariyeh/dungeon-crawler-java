package fr.campus.dungeoncrawler.model.equipment.offensive;

/**
 * Represents a weapon used by a warrior.
 */
public class Weapon extends OffensiveEquipment{
    public Weapon(int attackLevel, String name) {
        super("weapon", attackLevel, name);
    }
}
