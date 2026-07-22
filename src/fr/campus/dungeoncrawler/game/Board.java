package fr.campus.dungeoncrawler.game;

/**
 * Represents the game board composed of 64 cells.
 */
public class Board {
    private int[] nCell = new int[64];

    /**
     * Creates a board containing 64 cells.
     */
    public Board() {
    }

    /**
     * Returns the board cells.
     *
     * @return the array containing the board cells
     */
    public int[] getnCell() {
        return nCell;
    }


}
