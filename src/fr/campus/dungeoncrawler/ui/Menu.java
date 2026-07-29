package fr.campus.dungeoncrawler.ui;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Warrior;
import fr.campus.dungeoncrawler.model.character.types.Wizard;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    /**
     * Creates a menu using the specified scanner.
     *
     * @param scanner the scanner used to read user input
     */
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println();
        System.out.println("Welcome");
        System.out.println("Please choose an option: ");
        System.out.println("1. Press 1 to create a new character");
        System.out.println("2. Press 2 to exit");
    }

    public void displaySecondMenu() {
        System.out.println();
        System.out.println("Please choose between the options: ");
        System.out.println("1. Press any key to start the game with new character");
        System.out.println("2. Press 2 to exit");
        System.out.println("3. Press 3 to change the character name");
        //System.out.println("4. Change character type");
    }

    public void displayChangeName(){
        System.out.println("Enter new name: ");
    }

    public void displayThirdMenu(){
        System.out.println("");
        System.out.println("Please choose an option: ");
        System.out.println("1. Restart the game");
        System.out.println("2. Press 2 to exit");
    }


    public void displayAttackMenu(){
        System.out.println("Please choose an Action: ");
        System.out.println("0. For Attack");
        System.out.println("1. For Run away");
    }
    /**
     * Reads the user's choice.
     *
     * @return the number entered by the user
     */
    public int readChoice() {
            return Integer.parseInt(scanner.nextLine());
    }

        /**
     *
     * @return
     */
    public int readChoiceMenu(){
        while(true){
            try {
                int choice = this.readChoice();
                if(choice==2){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please choose between the options: ");
            }
        }
    }

    public int readAttackMenu(){
        while(true){
            try {
                int choice = this.readChoice();
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please choose between the options: ");
            }
        }

    }

    public void verifyChoice(){
        while(true){
            try {
                this.readChoiceMenu();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please choose between the options: ");
            }
        }
    }

    /**
     * Creates a character from the information entered by the user.
     *
     * @return the newly created character
     */
    public Character createCharacter() {
        int type;

        while (true) {

            System.out.println("Please choose between the two options: ");
            System.out.println("1. Press 1 to create a Warrior");
            System.out.println("2. Press 2 to create a Wizard");

            type = this.readChoice();

            if (type == 1){
                System.out.println("Enter Warrior name:");
                String name = scanner.nextLine().trim();
                return new Warrior(name);
            }
            if (type == 2) {
                System.out.println("Enter Wizard name:");
                String name = scanner.nextLine().trim();
                return new Wizard(name);
            }
            System.out.println("Invalid character type.");
        }
    }

    public String newName(){
        String name = scanner.nextLine().trim();
        return name;
    }


    public void waitForEnter() {
        System.out.println("Press Enter to roll the dice.");
        scanner.nextLine();
    }

    public void displayCharacter(Character character) {
        System.out.println(character);
    }


}
