package database;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS guitars ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL,"
                + "brand TEXT, "
                + "price REAL,"
                + "quantity INTEGER"
                + ");";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Guitars table ready. ");
        } catch (SQLException e) {
            System.out.println(" Error creating table: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        createTables();
    }
}
