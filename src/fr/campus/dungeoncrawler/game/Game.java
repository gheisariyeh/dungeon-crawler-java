package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.db.DatabaseManager;
import fr.campus.dungeoncrawler.exception.OutOfBoardException;
import fr.campus.dungeoncrawler.model.cell.Cell;
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
    private final Board board;
    private final Dice dice;
    //private final DatabaseManager databaseManager;

    // Position 0 means that the character has not entered the board yet.
    private int characterPosition = 0;
    private Character character;


    /**
     * Creates a new game with the specified menu.
     * Initializes the board, the dice and the starting position.
     *
     * @param menu the menu used to interact with the player
     */
    public Game(Menu menu) {
        this.menu = menu;
        this.board = new Board();
        this.dice = new Dice();
        //this.databaseManager = new DatabaseManager();
    }

    /**
     * Starts the application, creates the character,
     * displays the menus and launches the game.
     */
    public void start() {
        int  choice;
        menu.displayMainMenu();
        menu.verifyChoice();
        character = menu.createCharacter();
        //int characterId = databaseManager.createHero(character);
        menu.displayCharacter(character);

        menu.displaySecondMenu();
        while(true){
            try {
                choice = menu.readChoiceMenu();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please choose between the options: ");
            }
        }

        while (choice == 3){
            menu.displayChangeName();
            String newName = menu.newName();
            character.setName(newName);
            System.out.println(character);
            //databaseManager.editHeroName(characterId, character);
            menu.displaySecondMenu();
            choice = menu.readChoiceMenu();
        }

        System.out.println("Starting...");
        startGame();
        menu.displayThirdMenu();
        menu.verifyChoice();
        reStartGame();
    }

    /**
     * Starts the board game and continues until the character
     * reaches the final cell.
     */
    public void startGame(){
        while (characterPosition<64) {
            menu.waitForEnter();
            // Prevent the player from moving beyond the last cell.
            try{
                changePosition(dice.roll());
                System.out.println("You move to cell " + characterPosition + "/64");
                Cell currentCell = board.getCell(characterPosition - 1);
                System.out.println(currentCell);
                currentCell.interact(character);
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
     * Restarts the game.
     */
    public void reStartGame(){
        characterPosition = 0;
        start();
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
        if (newPosition > 64){
            throw new OutOfBoardException(">>> You've passed cell 64");
        }
        characterPosition += diceResult;
    }
}
