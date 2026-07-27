package fr.campus.dungeoncrawler.model.equipment.offensive.weapon;
import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

/**
 * Represents a weapon used by a warrior.
 */
public class Weapon extends OffensiveEquipment {
    public Weapon(int attackLevel, String name) {
        super("weapon", attackLevel, name);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type='" + getType() + '\'' +
                ", attackLevel=" + getAttackLevel() +
                ", name='" + getName() + '\'' +
                '}';
    }

    public void interact(Character character) {
        //Implemented in the childs
    }
}
