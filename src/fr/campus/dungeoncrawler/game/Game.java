package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.ui.Menu;

public class Game {
    // Fields
    private final Menu menu;
    private final Dice dice = new Dice();

    // Every new game starts on the first cell.
    private int characterPosition = 1;

    // Constructor
    public Game(Menu menu) {
        this.menu = menu;

    }

    public void start() {
        Character character;
        menu.displayMainMenu();

        int choice = menu.readChoice();

        if (choice == 1) {
            character = menu.createCharacter();
            menu.displayCharacter(character);
            menu.displaySecondMenu();
            choice = menu.readChoice();
            if (choice == 1){
                System.out.println("Starting...");
                startGame();
                menu.displayThirdMenu();
                choice = menu.readChoice();
                if (choice == 1) {
                    reStartGame();
                    }
                }
        } else if (choice == 2) {
            System.out.println("Goodbye!");
        }
    }

    public void startGame(){
        int diceResult;
        while (characterPosition<64) {

            menu.waitForEnter();
            diceResult = dice.roll();

            System.out.println("Dice result: " + diceResult);

            characterPosition += diceResult;

            // Prevent the player from moving beyond the last cell.
            if (characterPosition > 64) {
                characterPosition = 64;
            }
            System.out.println("You move to cell " + characterPosition + "/64");
        }
        System.out.println("it's finished!");
    }

    public void reStartGame(){
        characterPosition = 1;
        startGame();
    }
}
