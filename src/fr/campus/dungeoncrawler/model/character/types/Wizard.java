package fr.campus.dungeoncrawler.model.character.types;
import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.equipment.defensive.potion.Potion;
import fr.campus.dungeoncrawler.model.equipment.offensive.spell.Spell;

/**
 * Represents a wizard character.
 *
 * <p>A wizard starts with 7 health points,
 * 7 attack points and a Lightning.</p>
 */
public class Wizard extends Character {
    /**
     * Creates a wizard with the specified name.
     *
     * @param name the wizard's name
     */
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
