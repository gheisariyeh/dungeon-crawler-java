package fr.campus.dungeoncrawler.ui;

import fr.campus.dungeoncrawler.model.character.Character;

import java.util.Scanner;

public class Menu {
    // Fields
    private final Scanner scanner;

    // Constructor
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
    public int readChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    public Character createCharacter() {
        String type;

        while (true) {

            System.out.println("Choose Warrior or Wizard:");
            type = scanner.nextLine().trim();

            if (type.equalsIgnoreCase("Warrior")
                    || type.equalsIgnoreCase("Wizard")) {
                break;
            }

            System.out.println("Invalid character type.");
        }

        System.out.println("Enter character name:");
        String name = scanner.nextLine().trim();

        return new Character(type, name);
    }

    public void waitForEnter() {
        System.out.println("Press Enter to roll the dice.");
        scanner.nextLine();
    }

    public void displayCharacter(Character character) {
        System.out.println(character);
    }


}
