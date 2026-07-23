package fr.campus.dungeoncrawler.model.character;
import fr.campus.dungeoncrawler.model.equipment.defensive.Shield;
import fr.campus.dungeoncrawler.model.equipment.offensive.Weapon;

/**
 * Represents a warrior character.
 *
 * <p>A warrior starts with 10 health points,
 * 5 attack points and a club.</p>
 */
public class Warrior extends Character{
    /**
     * Creates a warrior with the specified name.
     *
     * @param name the warrior's name
     */
    public Warrior(String name) {
        super(
                "Warrior",
                name,
                10,
                5,
                new Weapon(3, "Club"),
                new Shield(3, "Wooden Shield")
        );
    }
}
