# Glossaire Java

## `class`

Une classe est un modèle qui définit la structure et le comportement des objets. Elle contient des attributs (données) et des méthodes (fonctions).

Exemple : `class Warrior { ... }`

## `object`

Un objet est une instance concrète d'une classe. On crée un objet avec le mot-clé `new`.

Exemple : `Warrior warrior = new Warrior("Aragorn");`

## `attribute` ou `field`

Un attribut (ou champ) est une variable qui stocke des données dans une classe.

Exemple : `private String name;`

## `method`

Une méthode est une fonction définie dans une classe qui réalise une action.

Exemple : `public String getName() { return this.name; }`

## `constructor`

Un constructeur est une méthode spéciale qui permet de créer et d'initialiser un objet. Elle a le même nom que la classe.

Exemple : `public Warrior(String name) { ... }`

## `this`

Le mot-clé `this` fait référence à l'objet courant dans une classe. Il permet d'accéder aux attributs et méthodes de l'instance.

Exemple : `this.name = name;`

## `public`

Modificateur d'accès qui rend un attribut ou une méthode accessible depuis n'importe quelle autre classe.

Exemple : `public class Character { ... }`

## `private`

Modificateur d'accès qui limite la visibilité d'un attribut ou d'une méthode à la classe dans laquelle il est déclaré.

Exemple : `private String type;`

## `final`

Le mot-clé `final` indique qu'une variable ne peut pas être modifiée après son initialisation, ou qu'une classe ne peut pas être héritée.

Exemple : `private final Random random = new Random();`

## `static`

Le mot-clé `static` indique qu'un attribut ou une méthode appartient à la classe elle-même plutôt qu'à une instance. Il est souvent utilisé avec `final` pour des constantes.

Exemple : `private static final int BOARD_SIZE = 64;`

## `getter`

Méthode qui permet de récupérer la valeur d'un attribut privé.

Exemple : `public String getName() { return this.name; }`

## `setter`

Méthode qui permet de modifier la valeur d'un attribut privé.

Exemple : `public void setName(String name) { this.name = name; }`

## `encapsulation`

Principe qui consiste à masquer les détails internes d'une classe en rendant ses attributs privés et en fournissant des méthodes publiques (getters/setters) pour y accéder.

## `inheritance`

Mécanisme qui permet à une classe (classe enfant) d'hériter des attributs et méthodes d'une autre classe (classe parente).

Exemple : `Warrior` hérite de `Character`.

## `extends`

Le mot-clé `extends` permet à une classe d'hériter d'une autre classe.

Exemple : `public class Warrior extends Character { ... }`

## `super`

Le mot-clé `super` permet d'appeler le constructeur ou une méthode de la classe parente.

Exemple : `super("Warrior", name, 10, 5, offensiveEquipment, defensiveEquipment);`

## `abstract class`

Une classe abstraite ne peut pas être instanciée directement. Elle sert de modèle pour d'autres classes. Elle peut contenir des méthodes concrètes et abstraites.

Exemple : `public abstract class Character { ... }`

## `abstract method`

Méthode déclarée sans implémentation dans une classe abstraite ou une interface. Les classes qui héritent ou implémentent doivent fournir l'implémentation.

Exemple : Dans l'interface `Cell`, `void interact(Character character);` est une méthode abstraite.

## `interface`

Une interface définit un contrat que les classes doivent implémenter. Elle contient des méthodes sans corps (abstraites).

Exemple : `public interface Cell { void interact(Character character); }`

## `implements`

Le mot-clé `implements` permet à une classe d'implémenter une interface.

Exemple : `public class EmptyCell implements Cell { ... }`

## `@Override`

Annotation qui indique qu'une méthode redéfinit une méthode de la classe parente ou d'une interface.

Exemple : `@Override public void interact(Character character) { ... }`

## `polymorphism`

Principe qui permet à des objets de différentes classes d'être traités de manière uniforme à travers une interface ou une classe parente commune.

Exemple : `Cell cell = new Dragon(); cell.interact(character);`

## `instanceof`

Opérateur qui vérifie si un objet est une instance d'une classe ou d'une interface.

Exemple : `if (character instanceof Warrior) { ... }`

## `exception`

Mécanisme qui permet de gérer les erreurs et situations exceptionnelles dans le code.

## `try`

Bloc qui contient le code susceptible de lever une exception.

Exemple : `try { choice = menu.readChoiceMenu(); }`

## `catch`

Bloc qui capture et traite une exception levée dans un bloc `try`.

Exemple : `catch (NumberFormatException e) { System.out.println("Please choose between the options"); }`

## `throw`

Mot-clé qui permet de lever une exception.

Exemple : `throw new OutOfBoardException(">>> You've passed cell 64");`

## `throws`

Mot-clé qui indique qu'une méthode peut lever une exception.

Exemple : `public void changePosition(int diceResult) throws OutOfBoardException { ... }`

## `custom exception`

Exception définie par le développeur pour des besoins spécifiques de l'application.

Exemple : `public class OutOfBoardException extends Exception { ... }`

## `ArrayList`

Classe qui implique une liste dynamique d'objets. Elle fait partie du package `java.util`.

Exemple : `private final ArrayList<Cell> cells;`

## `package`

Un package est un conteneur qui regroupe des classes liées. Il évite les conflits de noms et organise le code.

Exemple : `package fr.campus.dungeoncrawler.model.character;`

## `import`

Le mot-clé `import` permet d'utiliser des classes d'un autre package sans spécifier leur nom complet.

Exemple : `import fr.campus.dungeoncrawler.model.character.Character;`

## `Javadoc`

Outil de documentation qui génère une documentation HTML à partir des commentaires spéciaux dans le code.

Un commentaire Javadoc commence par `/**` et se termine par `*/`.

## `@param`

Balise Javadoc qui explique un paramètre d'une méthode ou d'un constructeur.

Exemple : `@param character the character landing on the cell`

## `@return`

Balise Javadoc qui explique la valeur retournée par une méthode.

Exemple : `@return the name of the character`

## `@throws`

Balise Javadoc qui explique quelle exception peut être levée par une méthode.

Exemple : `@throws OutOfBoardException if the new position exceeds cell 64`
