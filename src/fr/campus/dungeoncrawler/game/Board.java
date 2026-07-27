package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.model.cell.Cell;
import fr.campus.dungeoncrawler.model.cell.EmptyCell;
import fr.campus.dungeoncrawler.model.enemy.Enemy;
import fr.campus.dungeoncrawler.model.enemy.types.Dragon;
import fr.campus.dungeoncrawler.model.enemy.types.Goblin;
import fr.campus.dungeoncrawler.model.enemy.types.Sorcerer;
import fr.campus.dungeoncrawler.model.equipment.defensive.potion.LargePotion;
import fr.campus.dungeoncrawler.model.equipment.defensive.potion.Potion;
import fr.campus.dungeoncrawler.model.equipment.defensive.potion.StandardPotion;
import fr.campus.dungeoncrawler.model.equipment.defensive.shield.Shield;
import fr.campus.dungeoncrawler.model.equipment.defensive.shield.SimpleShield;
import fr.campus.dungeoncrawler.model.equipment.offensive.spell.Fireball;
import fr.campus.dungeoncrawler.model.equipment.offensive.spell.Lightning;
import fr.campus.dungeoncrawler.model.equipment.offensive.weapon.Club;
import fr.campus.dungeoncrawler.model.equipment.offensive.weapon.Sword;
import fr.campus.dungeoncrawler.model.equipment.offensive.weapon.Weapon;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents the game board composed of 64 cells.
 */
public class Board {
    private static final int BOARD_SIZE = 64;
    private final ArrayList<Cell> cells;

    /**
     * Creates and initializes the game board.
     */
    public Board() {
        cells = new ArrayList<>();
        initializeBoard();
    }

    /**
     * initialize the cells of the Board and shuffle them
     */
    private void initializeBoard() {
        cells.clear();

        for (int i = 0; i < BOARD_SIZE; i++) {
            cells.add(new EmptyCell());
        }

        // Dragons
        int[] dragonPositions = {45, 52, 56, 62};

        for (int position : dragonPositions) {
            cells.set(position - 1, new Dragon());
        }

        // Sorcerers
        int[] sorcererPositions = {
                10, 20, 25, 32, 35,
                36, 37, 40, 44, 47
        };

        for (int position : sorcererPositions) {
            cells.set(position - 1, new Sorcerer());
        }

        // Goblins
        int[] goblinPositions = {
                3, 6, 9, 12, 15,
                18, 21, 24, 27, 30
        };

        for (int position : goblinPositions) {
            cells.set(position - 1, new Goblin());
        }

        // Clubs
        int[] clubPositions = {2, 5, 11, 22, 38};

        for (int position : clubPositions) {
            cells.set(position - 1, new Club());
        }

        // Swords
        int[] swordPositions = {19, 26, 42, 53};

        for (int position : swordPositions) {
            cells.set(position - 1, new Sword());
        }

        // Lightning spells
        int[] lightningPositions = {1, 4, 8, 17, 23};

        for (int position : lightningPositions) {
            cells.set(position - 1, new Lightning());
        }

        // Fireball spells
        int[] fireballPositions = {48, 49};

        for (int position : fireballPositions) {
            cells.set(position - 1, new Fireball());
        }

        // Standard potions
        int[] standardPotionPositions = {
                7, 13, 31, 33, 39, 43
        };

        for (int position : standardPotionPositions) {
            cells.set(position - 1, new StandardPotion());
        }

        // Large potions
        int[] largePotionPositions = {28, 41};

        for (int position : largePotionPositions) {
            cells.set(position - 1, new LargePotion());
        }
        // shuffle the cells for having a random board of cells
        Collections.shuffle(cells);
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
