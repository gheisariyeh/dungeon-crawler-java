package fr.campus.dungeoncrawler.model.character;

import fr.campus.dungeoncrawler.model.equipment.OffensiveEquipment;

public class Character {
    // Fields
    protected String type;
    protected String name;
    protected int healthLevel;
    protected int attackLevel;
    protected OffensiveEquipment offensiveEquipment;

    // Constructors
    public Character(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Character(String type, String name, int healthLevel, int attackLevel, OffensiveEquipment offensiveEquipment) {
        this.type = type;
        this.name = name;
        this.healthLevel = healthLevel;
        this.attackLevel = attackLevel;
        this.offensiveEquipment = offensiveEquipment;
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

    @Override
    public String toString() {
        return "Character{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", healthLevel=" + healthLevel +
                ", attackLevel=" + attackLevel +
                ", equipment='" + offensiveEquipment + '\'' +
                '}';
    }

}
