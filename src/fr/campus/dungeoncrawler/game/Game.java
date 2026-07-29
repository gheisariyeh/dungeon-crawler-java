package fr.campus.dungeoncrawler.game;

import fr.campus.dungeoncrawler.exception.OutOfBoardException;
import fr.campus.dungeoncrawler.game.Dice.Dice;
import fr.campus.dungeoncrawler.model.cell.Cell;
import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.enemy.Enemy;
import fr.campus.dungeoncrawler.model.equipment.defensive.DefensiveEquipment;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;
import fr.campus.dungeoncrawler.ui.Menu;

/**
 * Controls the main flow of the Dungeon Crawler game.
 *
 * <p>This class is responsible for:</p>
 *
 * <ul>
 *     <li>creating and managing the character,</li>
 *     <li>moving the character across the board,</li>
 *     <li>managing interactions with cells,</li>
 *     <li>managing turn-based fights,</li>
 *     <li>checking the end-of-game conditions.</li>
 * </ul>
 */
public class Game {
    // Fields
    private final Menu menu;
    private final Board board;

    // Six-sided dice used for movement and escape.
    private final Dice movementDice;

    // Twenty-sided dice used during fights.
    private final Dice combatDice;

    //private final DatabaseManager databaseManager;

    // Position 0 means that the character has not entered the board yet.
    private int characterPosition = 0;
    private Character character;


    /**
     * Creates a new game with all its required dependencies.
     *
     * @param menu the menu used to display information
     *             and read the player's choices
     * @param board the board containing all game cells
     * @param movementDice the dice used to move forward
     *                     or backward on the board
     * @param combatDice the twenty-sided dice used
     *                   to determine critical attacks
     */
    public Game(Menu menu, Board board, Dice movementDice, Dice combatDice) {
        this.menu = menu;
        this.board = board;
        this.movementDice = movementDice;
        this.combatDice = combatDice;
        //this.databaseManager = new DatabaseManager();
    }

    /**
     * Starts the application.
     *
     * <p>This method displays the main menus, creates the character,
     * allows the player to change its name and starts the board game.</p>
     */
    public void start() {
        int  choice;
        menu.displayMainMenu();
        menu.verifyChoice();
        character = menu.createCharacter();
        //int characterId = databaseManager.createHero(character);
        menu.displayCharacter(character);

        menu.displaySecondMenu();
        choice = menu.readChoiceMenu();

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
     * reaches the final cell or loses all health points.
     *
     * <p>During each turn, the character rolls the movement dice,
     * moves to a new cell and interacts with the content of that cell.</p>
     */
    public void startGame() {
        int choice;
        while (characterPosition < 64 && character.getHealthLevel() > 0) {
            menu.waitForEnter();
            // Prevent the player from moving beyond the last cell.
            try {
                /*
                 * Move the character using the six-sided dice.
                 * An exception is thrown if the movement exceeds cell 64.
                 */
                changePosition(movementDice.roll());
                System.out.println("You move to cell " + characterPosition + "/64");
                int currentCellIndex = characterPosition - 1;
                Cell currentCell = board.getCell(currentCellIndex);
                System.out.println(currentCell);

                /*
                 * Start a fight when the current cell
                 * contains an enemy.
                 */
                if (currentCell instanceof Enemy enemy) {
                    menu.displayAttackMenu();
                    choice = menu.readAttackMenu();
                    int combatDiceValue;

                    /*
                     * Continue the fight while the player chooses
                     * to attack and both participants are alive.
                     */
                    while (choice == 0 && character.getHealthLevel() > 0 && enemy.getLifePoints() > 0) {

                        /*
                         * Character's turn.
                         * The character always attacks first.
                         */
                        if (character.getHealthLevel() > 0 && enemy.getLifePoints() > 0) {
                            combatDiceValue = combatDice.roll();
                            System.out.println("combat Dice Value for character is = " + combatDiceValue);

                            /*
                             * A result of 20 is a critical success.
                             * Two points are added to the normal attack.
                             */
                            if (combatDiceValue == 20) {
                                int newAttackLevel = character.getAttackLevel() + character.getOffensiveEquipment().getAttackLevel() + 2;
                                enemy.setLifePoints(enemy.getLifePoints() - newAttackLevel);
                                System.out.println("hero is attacking to " + enemy.getName() + " with attack level of " + newAttackLevel);
                                if (enemy.getLifePoints() <= 0) {
                                    enemy.setLifePoints(0);
                                    System.out.println(enemy.getName() + " is dead!");
                                }

                            /*
                             * A result of 1 is a critical failure.
                             * The attack deals no damage.
                             */
                            } else if (combatDiceValue == 1) {
                                System.out.println(enemy.getName() + " doesn't lost any Health Point");

                                /*
                                 * Any result between 2 and 19
                                 * produces a normal attack.
                                 */
                            } else {
                                int currentAttackLevel = character.getAttackLevel() + character.getOffensiveEquipment().getAttackLevel();

                                enemy.setLifePoints(enemy.getLifePoints() - currentAttackLevel);
                                System.out.println("hero is attacking to " + enemy.getName() + " with attack level of " + currentAttackLevel);
                                if (enemy.getLifePoints() <= 0) {
                                    enemy.setLifePoints(0);
                                    System.out.println(enemy.getName() + " is dead!");
                                }
                            }
                        }

                        /*
                         * Enemy's turn.
                         * The enemy attacks only if it survived
                         * the character's attack.
                         */
                        if (character.getHealthLevel() > 0 && enemy.getLifePoints() > 0) {
                            combatDiceValue = combatDice.roll();
                            System.out.println("combat Dice Value for enemy is = " + combatDiceValue);

                            /*
                             * Critical success for the enemy:
                             * two points are added to its strength.
                             */
                            if (combatDiceValue == 20) {
                                int currentHealthLevel = character.getHealthLevel();
                                int newStrength = enemy.getStrength() + 2;
                                character.setHealthLevel(currentHealthLevel - newStrength);
                                System.out.println(enemy.getName() + " is not dead and he is attacking with strength of " + newStrength);
                                System.out.println("Character's health level is decreasing from " + currentHealthLevel + " to " + character.getHealthLevel());
                                System.out.println();

                            /*
                             * Critical failure for the enemy:
                             * the character receives no damage.
                             */
                            } else if (combatDiceValue == 1) {
                                System.out.println(character.getName() + " doesn't lost any Health Point");

                            /*
                             * Normal enemy attack.
                             */
                            } else {
                                currentCell.interact(character);

                            }

                            /*
                             * Ask the player whether to attack again
                             * or run away.
                             */
                            menu.displayAttackMenu();
                            choice = menu.readAttackMenu();
                        }
                    }

                    /*
                     * When the player runs away, the character moves
                     * backward using the six-sided movement dice.
                     */
                    if (choice == 1 && character.getHealthLevel() > 0 && enemy.getLifePoints() > 0) {
                        changeReversePosition(movementDice.roll());
                        System.out.println("You moved back to cell " + characterPosition + "/64");
                    }

                /*
                 * Manage offensive equipment such as weapons
                 * and spells.
                 */
                }else if (currentCell instanceof OffensiveEquipment offensiveEquipment) {
                    offensiveEquipment.interact(character);
                    /*
                     * If the character now references the equipment
                     * contained in the cell, the equipment was picked up.
                     * The original board cell can therefore become empty.
                     */
                    if (character.getOffensiveEquipment() == offensiveEquipment) {
                        board.makeEmpty(currentCellIndex);
                    }

                /*
                 * Manage empty cells, defensive equipment
                 * and other possible cell types.
                 */
                } else {
                    currentCell.interact(character);
                }

                /*
                 * Remove a fully consumed defensive item
                 * from the board.
                 */
                if (currentCell instanceof DefensiveEquipment defensiveEquipment && defensiveEquipment.getDefenseLevel() == 0) {
                    board.makeEmpty(currentCellIndex);
                }

                /*
                 * Remove a defeated enemy from the board.
                 */
                if (currentCell instanceof Enemy enemy && enemy.getLifePoints() <= 0) {
                    board.makeEmpty(currentCellIndex);
                }

                /*
                 * Stop the game when the character has
                 * no remaining health points.
                 */
                if (character.getHealthLevel() <= 0) {
                    System.out.println("Character is dead because the health level is finished!");
                    break;
                }
            }
            catch(OutOfBoardException e){
                    System.out.println(e.getMessage());
                    System.out.println(
                            ">>> You stay on cell " + characterPosition + "/64"
                    );
                }
            }

            /*
             * If the loop ends while the character is alive,
             * the final cell has been reached.
             */
            if (character.getHealthLevel() > 0) {
                System.out.println("It's finished!");
                System.out.println("The hero is a winner!");
            }
    }



    /**
     * Restarts the game from the beginning.
     *
     * <p>The character position is reset to zero before displaying
     * the main menu and creating a new character.</p>
     */
    public void reStartGame(){
        characterPosition = 0;
        start();
    }

    /**
     * Moves the character forward according to the movement dice result.
     *
     * @param diceResult the number of cells to move forward
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

    /**
     * Moves the character backward after running away from a fight.
     *
     * <p>The position cannot be lower than zero. Position zero means
     * that the character is located before the first board cell.</p>
     *
     * @param diceResult the number of cells to move backward
     */
    public void changeReversePosition (int diceResult){
        System.out.println("Dice result: " + diceResult);
        characterPosition = Math.max(0, characterPosition - diceResult);
    }
}
