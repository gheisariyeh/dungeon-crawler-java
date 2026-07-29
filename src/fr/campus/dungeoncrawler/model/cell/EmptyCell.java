package fr.campus.dungeoncrawler.model.cell;
import fr.campus.dungeoncrawler.model.character.Character;

/**
 * Represents an empty cell on the game board.
 */
public class EmptyCell implements Cell {

    public EmptyCell() {
    }

    @Override
    public String toString() {
        return "This is an empty cell";
    }

    @Override
    public void interact(Character character) {
        // An empty cell has no effect.
    }
}