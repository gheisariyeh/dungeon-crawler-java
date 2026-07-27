package fr.campus.dungeoncrawler.model.cell;
import fr.campus.dungeoncrawler.model.character.Character;


/**
 * Represents an element that can be placed on the game board.
 */
public interface Cell {

    /**
     * Applies the effect of this cell to the character.
     *
     * @param character the character landing on the cell
     */
    void interact(Character character);
}