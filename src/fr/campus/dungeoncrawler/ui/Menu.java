package fr.campus.dungeoncrawler.ui;

import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.Warrior;
import fr.campus.dungeoncrawler.model.character.Wizard;

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
        System.out.println("Welcome");
        System.out.println("please choose option number 1 or 2");
        System.out.println("1. New character");
        System.out.println("2. Quit");
        System.out.println(">");
    }

    public void displaySecondMenu() {
        System.out.println("");
        System.out.println("please choose option number 1 or 2");
        System.out.println("1. Start with new character");
        System.out.println("2. Quit");
        System.out.println(">");
    }

    public void displayThirdMenu(){
        System.out.println("");
        System.out.println("please choose option number 1 or 2");
        System.out.println("1. Do you want to restart the game?");
        System.out.println("2. Quit");
        System.out.println(">");
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
        int choice = this.readChoice();
        if(choice==2){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        return choice;
    }

    /**
     * Creates a character from the information entered by the user.
     *
     * @return the newly created character
     */
    public Character createCharacter() {
        String type;

        while (true) {

            System.out.println("Choose Warrior or Wizard:");
            type = scanner.nextLine().trim();

            if (type.equalsIgnoreCase("Warrior")){
                System.out.println("Enter character name:");
                String name = scanner.nextLine().trim();
                return new Warrior(name);
            }
            if (type.equalsIgnoreCase("Wizard")) {
                System.out.println("Enter character name:");
                String name = scanner.nextLine().trim();
                return new Wizard(name);
            }

            System.out.println("Invalid character type.");
        }




    }

    public void waitForEnter() {
        System.out.println("Press Enter to roll the dice.");
        scanner.nextLine();
    }

    public void displayCharacter(Character character) {
        System.out.println(character);
    }


}
