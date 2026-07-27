package fr.campus.dungeoncrawler.model.cell;
import fr.campus.dungeoncrawler.model.character.Character;

/**
 * Represents an empty cell on the game board.
 */
public class EmptyCell implements Cell {

    @Override
    public String toString() {
        return "Empty cell";
    }

    @Override
    public void interact(Character character) {
        // An empty cell intentionally has no effect.
    }
}