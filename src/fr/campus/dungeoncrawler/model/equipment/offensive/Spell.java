package fr.campus.dungeoncrawler.model.equipment.offensive;

/**
 * Represents a spell used by a wizard.
 */
public class Spell extends OffensiveEquipment {
    public Spell(int attackLevel, String name) {
        super("Spell", attackLevel, name);
    }
}
