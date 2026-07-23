package fr.campus.dungeoncrawler.model.character;
import fr.campus.dungeoncrawler.model.equipment.defensive.Potion;
import fr.campus.dungeoncrawler.model.equipment.offensive.Spell;

/**
 * Represents a wizard character.
 *
 * <p>A wizard starts with 7 health points,
 * 7 attack points and a Lightning.</p>
 */
public class Wizard extends Character{
    public Wizard(String name) {
        super(
                "Wizard",
                name,
                7,
                7,
                new Spell( 2, "Lightning"),
                new Potion(3, "Healing Potion")
        );
    }
}
