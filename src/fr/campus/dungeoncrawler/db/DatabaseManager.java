package fr.campus.dungeoncrawler.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import fr.campus.dungeoncrawler.model.character.Character;
import java.sql.PreparedStatement;

/**
 * Create connection with database
 * <p>This class implements the functions for reading from database
 * writing into database and doing the updates</p>
 */
public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/dungeon_crawler";
    private static final String USER = "root";
    private static final String PASSWORD = "your password";

    /**
     * @return SQLConnection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    /**
     * returns all the data of the characters' table in the database
     */
    public void getHeroes() {
        String sql = "SELECT * FROM characters";
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int lifePoints = resultSet.getInt("life_points");
                int strength = resultSet.getInt("strength");
                String offensiveEquipment =
                        resultSet.getString("offensive_equipment");
                String defensiveEquipment =
                        resultSet.getString("defensive_equipment");

                System.out.println(
                        id + " | " +
                                type + " | " +
                                name + " | Life: " +
                                lifePoints + " | Strength: " +
                                strength + " | Offensive equipment: " +
                                offensiveEquipment + " | Defensive equipment: " +
                                defensiveEquipment
                );
            }

        } catch (SQLException e) {
            System.out.println("Unable to retrieve heroes.");
            System.out.println(e.getMessage());
        }
    }


    /**
     * Insert a raw of a character in characters table in the database
     * @param character
     */
    public int createHero(Character character) {
        String sql = """
                INSERT INTO characters
                (type, name, life_points, strength, offensive_equipment, defensive_equipment)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, character.getType());
            statement.setString(2, character.getName());
            statement.setInt(3, character.getHealthLevel());
            statement.setInt(4, character.getAttackLevel());
            statement.setString(5, character.getOffensiveEquipment().getName());
            statement.setString(6, character.getDefensiveEquipment().getName());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 1) {
                try (ResultSet generatedKey = statement.getGeneratedKeys()) {
                    if (generatedKey.next()) {
                        int generatedId = generatedKey.getInt(1);
                        System.out.println("Hero successfully created in data base");
                        return generatedId;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Unable to create hero.");
            System.out.println(e.getMessage());
        }
        return -1;
    }

    /**
     * update the name of current character in characters' table by using the id of the character
     * @param characterId
     * @param character
     */
    public void editHeroName(int characterId, Character character) {
        String sql = """
                UPDATE characters
                SET type = ?, name = ?, life_points = ?, strength = ?, offensive_equipment = ?, defensive_equipment = ?
                Where id = ?
                """;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, character.getType());
            statement.setString(2, character.getName());
            statement.setInt(3, character.getHealthLevel());
            statement.setInt(4, character.getAttackLevel());
            statement.setString(5, character.getOffensiveEquipment().getName());
            statement.setString(6, character.getDefensiveEquipment().getName());
            statement.setInt(7, characterId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("The hero's name has been updated successfully");
            } else {
                System.out.println("Not found");
            }
        } catch (SQLException e) {
            System.out.println("Unable to update hero.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Change the quantity of Health level (life points) of current character in characters' table in the database
     * @param characterId
     * @param character
     * @param lifePoints
     */
    public void changeLifePoints(int characterId, Character character, int lifePoints){
        String sql = """
                UPDATE characters
                SET type = ?, name = ?, life_points = ?, strength = ?, offensive_equipment = ?, defensive_equipment = ?
                Where id = ?
                """;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, character.getType());
            statement.setString(2, character.getName());
            statement.setInt(3, character.getHealthLevel() + lifePoints);
            statement.setInt(4, character.getAttackLevel());
            statement.setString(5, character.getOffensiveEquipment().getName());
            statement.setString(6, character.getDefensiveEquipment().getName());
            statement.setInt(7, characterId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 1) {
                System.out.println("Life points of the hero has been updated successfully");
            } else {
                System.out.println("Not found");
            }
        } catch (SQLException e) {
            System.out.println("Unable to update hero's life points.");
            System.out.println(e.getMessage());
        }
    }
}
