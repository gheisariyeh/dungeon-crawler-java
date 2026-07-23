package fr.campus.dungeoncrawler.model.cell;

import java.util.ArrayList;
import java.util.function.IntFunction;

/**
 * Represents a cell on the game board.
 */
public abstract class Cell extends ArrayList<Cell> {
    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }
}