package managers;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProduct {

    public static void listAll() {
        final String sql = "SELECT id, name, brand, price, quantity FROM GUITARS ORDER BY id";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int rows = 0;
            System.out.println("--- Guitar Inventory ---");
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                double price = rs.getDouble("price");
                int qty = rs.getInt("quantity");

                if (brand == null) brand = "--";
                System.out.printf("#%d | %-20s | %-12s | $%.2f| qty: %d%n",
                        id, name, brand, price, qty);
                rows++;
            }
            if (rows == 0) {
                System.out.println("(no rows yet)");
            }
        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }

    }
    public static void main (String[]args){
            listAll();
    }

}
