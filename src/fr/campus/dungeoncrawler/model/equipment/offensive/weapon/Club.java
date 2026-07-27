package fr.campus.dungeoncrawler.model.equipment.offensive.weapon;
import fr.campus.dungeoncrawler.model.character.Character;
import fr.campus.dungeoncrawler.model.character.types.Warrior;
import fr.campus.dungeoncrawler.model.character.types.Wizard;
import fr.campus.dungeoncrawler.model.equipment.offensive.OffensiveEquipment;

public class Club extends Weapon {
    public Club() {
        super( 3, "Club");
    }

    @Override
    public String toString() {
        return "Club{" +
                "type='" + getType() + '\'' +
                ", attackLevel=" + getAttackLevel() +
                '}';
    }

    /**
     * Handles the interaction between Club cell and the character
     * who lands on it.
     *
     * @param character the character interacting with Club cell
     */
    @Override
    public void interact(Character character) {
        if (character instanceof Warrior){
            OffensiveEquipment currentEquipment = character.getOffensiveEquipment();
            if (currentEquipment == null || getAttackLevel() > currentEquipment.getAttackLevel()){
                character.setOffensiveEquipment(this);
                System.out.println(character.getName() + " picked up the club.");
            } else {
                System.out.println("The current weapon is better than the club.");
            }
        } else {
            System.out.println("Only a warrior can use a club.");
        }
    }
}
