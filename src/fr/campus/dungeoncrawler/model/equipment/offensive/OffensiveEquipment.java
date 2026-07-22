package fr.campus.dungeoncrawler.model.equipment.offensive;

/**
 * Represents offensive equipment that increases
 * the attack capacity of a character.
 */
public abstract class OffensiveEquipment {
    // Fields
    private String type;
    private int attackLevel;
    private String name;

    /**
     * Creates offensive equipment.
     *
     * @param type the equipment type
     * @param attackLevel the attack bonus
     * @param name the equipment name
     */
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
        return "attackLevel=" + attackLevel +
                ", name='" + name + '\'' +
                '}';
    }
}
