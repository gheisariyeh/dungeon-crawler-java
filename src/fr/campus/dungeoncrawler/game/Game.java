package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.exception.OutOfBoardException;
import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.ui.Menu;

/**
 * Controls the main flow of the game.
 *
 * <p>This class starts the game, rolls the dice,
 * moves the character and manages the end of the game.</p>
 */
public class Game {
    // Fields
    private final Menu menu;
    private final Dice dice = new Dice();

    // Every new game starts on the first cell.
    private int characterPosition = 1;

    /**
     * Creates a game using the specified menu.
     *
     * @param menu the menu used to interact with the player
     */
    public Game(Menu menu) {
        this.menu = menu;
    }

    /**
     * Starts the application and manages character creation.
     */
    public void start() {
        Character character;
        menu.displayMainMenu();

        int choice = menu.readChoiceMenu();

        character = menu.createCharacter();
        menu.displayCharacter(character);
        menu.displaySecondMenu();
        choice = menu.readChoiceMenu();

        System.out.println("Starting...");
        startGame();
        menu.displayThirdMenu();
        choice = menu.readChoiceMenu();

        reStartGame();
    }

    /**
     * Starts the board game and continues until the character
     * reaches the final cell.
     */
    public void startGame(){
        int diceResult;
        while (characterPosition<64) {

            menu.waitForEnter();

            // Prevent the player from moving beyond the last cell.
            try{
                changePosition(dice.roll());
                System.out.println("You move to cell " + characterPosition + "/64");
            } catch (OutOfBoardException e) {
                System.out.println(e.getMessage());
                System.out.println(
                        ">>> You stay on cell " + characterPosition + "/64"
                );
            }

        }
        System.out.println("it's finished!");
    }

    /**
     * Restart the game
     */
    public void reStartGame(){
        characterPosition = 1;
        startGame();
    }

    /**
     * Changes the character position according to the dice result.
     *
     * @param diceResult the number obtained from the dice
     * @throws OutOfBoardException if the new position exceeds cell 64
     */
    public void changePosition (int diceResult) throws OutOfBoardException{
        System.out.println("Dice result: " + diceResult);
        int newPosition = characterPosition + diceResult;
        if (newPosition>64){
            throw new OutOfBoardException(">>> You've passed cell 64");
        }
        characterPosition += diceResult;
    }
}
