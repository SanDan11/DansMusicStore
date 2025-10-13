package managers;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStatus {

        public static void showDatabaseStatus() {
            System.out.println("\n=== DATABASE STATUS ===");

            printTableCount("guitar");
            printTableCount("drum");
            printTableCount("bass");
            printTableCount("keyboard");
            printTableCount("amp");
            printTableCount("audio");
            printTableCount("accessories");
        }

        private static void printTableCount(String tableName) {
            String sql = "SELECT COUNT(*) AS count FROM " + tableName;
            try(Connection conn = DBConnection.connect();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    System.out.println(tableName.toUpperCase() + ": " + rs.getInt("count") + " records");
                }
            } catch (SQLException e) {
                System.out.println(tableName.toUpperCase() + ": Error (" + e.getMessage()+ ")");
            }
        }
}
