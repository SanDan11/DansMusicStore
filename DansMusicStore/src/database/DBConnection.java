package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static final String DB_NAME = "music_store.db";
    private static final String URL = "jdbc:sqlite:" + DB_NAME;

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);


            File dbFile = new File(DB_NAME);
            System.out.println("Connected to database: " + dbFile.getAbsolutePath());

            return conn;

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    // Optional test entry point
    public static void main(String[] args) {
        Connection conn = connect();
        if (conn != null) {
            try {
                System.out.println("Driver: " + conn.getMetaData().getDriverName());
                System.out.println("URL: " + conn.getMetaData().getURL());
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
