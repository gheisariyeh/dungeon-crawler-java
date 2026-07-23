package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.model.cell.Cell;
import fr.campus.dungeoncrawler.model.cell.EmptyCell;
import fr.campus.dungeoncrawler.model.enemy.Enemy;
import fr.campus.dungeoncrawler.model.equipment.defensive.Potion;
import fr.campus.dungeoncrawler.model.equipment.offensive.Weapon;

import java.util.ArrayList;

/**
 * Represents the game board composed of 64 cells.
 */
public class Board {

    private final ArrayList<Cell> cells;

    /**
     * Creates and initializes the simplified game board.
     */
    public Board() {
        cells = new ArrayList<>(4);
        initializeBoard();
    }

    /**
     * Adds the cells to the board in their playing order.
     */
    private void initializeBoard() {
        cells.add(new EmptyCell());
        cells.add(new Enemy("Goblin", 6, 1));
        cells.add(new Weapon(3, "Sword"));
        cells.add(new Potion(2, "Healing Potion"));
    }

    /**
     * Returns the cell located at the specified index.
     *
     * @param cellIndex the zero-based index of the requested cell
     * @return the index of the specified cell
     */
    public Cell getCell(int cellIndex) {
        return cells.get(cellIndex);
    }
    @Override
    public String toString() {
        return "Board{" +
                "cells=" + cells +
                '}';
    }
}
