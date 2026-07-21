package fr.campus.dungeoncrawler;

import fr.campus.dungeoncrawler.game.Board;
import fr.campus.dungeoncrawler.game.Game;
import fr.campus.dungeoncrawler.ui.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(scanner);
        //Board board = new Board();
        Game game = new Game(menu);

        game.start();

        scanner.close();
    }
}