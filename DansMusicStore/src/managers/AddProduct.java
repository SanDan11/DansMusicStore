package managers;

import database.DBConnection;

import java.sql.*;

public class AddProduct {

    public static boolean addGuitar(String name, String brand, double price, int quantity) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name is required");
            return false;
        }
        if (price < 0) {
            System.out.println("price cannont be negative");
            return false;
        }
        if (quantity < 0) {
            System.out.println("quantity cannot be negative");
            return false;
        }

        final String sql = "INSERT INTO guitars(name, brand, price, quantity) VALUES (?, ?, ?, ?)";

        try(Connection conn = DBConnection.connect();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name.trim());
            if (brand == null || brand.trim().isEmpty()) {
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, brand.trim());
            }
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            int rows = ps.executeUpdate();
            if (rows == 1) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        long id = keys.getLong(1);
                        System.out.println("Added guitar id=" + id + " (" + name.trim() + ")");
                    } else {
                        System.out.println("Added guitar (id not returned");
                    }
                }
                return true;
            } else {
                System.out.println("Insert affected " + rows + " rows (expected 1)");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
            return false;
        }
    }

    public  static void main(String[] args) {
        addGuitar("Stratocaster", "Fender", 999.99, 5);
    }
}
