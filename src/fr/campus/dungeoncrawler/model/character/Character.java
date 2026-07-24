package fr.campus.dungeoncrawler.model.character;

import fr.campus.dungeoncrawler.model.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

/**
 * Represents a general character in the game.
 *
 * <p>A character has a name, a health level, an attack level
 * and offensive, defensive equipments.</p>
 */
public abstract class Character {
    // Fields
    protected String type;
    protected String name;
    protected int healthLevel;
    protected int attackLevel;
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    /**
     * Creates a character with the specified characteristics.
     *
     * @param type the character type
     * @param name the character name
     * @param healthLevel the initial health level
     * @param attackLevel the initial attack level
     * @param offensiveEquipment the default offensive equipment
     * @param defensiveEquipment the default defensive equipment
     */
    public Character(String type, String name, int healthLevel, int attackLevel, OffensiveEquipment offensiveEquipment, DefensiveEquipment defensiveEquipment) {
        this.type = type;
        this.name = name;
        this.healthLevel = healthLevel;
        this.attackLevel = attackLevel;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    @Override
    public String toString() {
        return "Character{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", healthLevel=" + healthLevel +
                ", attackLevel=" + attackLevel +
                ", offensiveEquipment=" + offensiveEquipment.getName() +
                ", defensiveEquipment=" + defensiveEquipment.getName() +
                '}';
    }
}
