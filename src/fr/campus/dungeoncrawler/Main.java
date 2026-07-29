package fr.campus.dungeoncrawler;

import fr.campus.dungeoncrawler.game.Board;
import fr.campus.dungeoncrawler.game.Dice.Dice;
import fr.campus.dungeoncrawler.game.Dice.SixSidedDice;
import fr.campus.dungeoncrawler.game.Dice.TwentySidedDice;
import fr.campus.dungeoncrawler.game.Game;
import fr.campus.dungeoncrawler.ui.Menu;

import java.util.Scanner;

/**
 * Entry point of the application.
 */
public class Main {
    /**
     * Starts the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(scanner);
        Board board = new Board();
        Dice movementDice = new SixSidedDice();
        Dice combatDice = new TwentySidedDice();

        Game game = new Game(menu, board, movementDice, combatDice);

        game.start();

        scanner.close();
    }
}