package fr.campus.dungeoncrawler.model.equipment;

public class OffensiveEquipment {
    // Fields
    private String type;
    private int attackLevel;
    private String name;

    // Constructor
    public OffensiveEquipment(String type, int attackLevel, String name) {
        this.type = type;
        this.attackLevel = attackLevel;
        this.name = name;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OffensiveEquipment{" +
                "type='" + type + '\'' +
                ", attackLevel=" + attackLevel +
                ", name='" + name + '\'' +
                '}';
    }
}
