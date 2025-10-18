package database;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {

        String guitarTable = "CREATE TABLE IF NOT EXISTS guitar (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String drumTable = "CREATE TABLE IF NOT EXISTS drum (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String bassTable = "CREATE TABLE IF NOT EXISTS bass (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String keyboardTable = "CREATE TABLE IF NOT EXISTS keyboard (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String accessoriesTable = "CREATE TABLE IF NOT EXISTS accessories (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String ampTable = "CREATE TABLE IF NOT EXISTS amp (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";

        String audioTable = "CREATE TABLE IF NOT EXISTS audio (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "brand TEXT, " +
                "price REAL, " +
                "quantity INTEGER, " +
                "location TEXT" +
                ");";


        try(Connection conn = DBConnection.connect();
            Statement stmt = conn.createStatement()) {

            stmt.execute("PRAGMA journal_mode=WAL");

            stmt.execute(guitarTable);
            System.out.println("Guitar table ready.");

            stmt.execute(drumTable);
            System.out.println("Drum table ready.");

            stmt.execute(bassTable);
            System.out.println("Bass table ready.");

            stmt.execute(keyboardTable);
            System.out.println("Keyboard table ready.");

            stmt.execute(accessoriesTable);
            System.out.println("Accessories table ready.");

            stmt.execute(ampTable);
            System.out.println("Amp table ready.");

            stmt.execute(audioTable);
            System.out.println("Audio table ready.");

        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }

    }
    public static void main(String[] args) {
        createTables();
    }
}
