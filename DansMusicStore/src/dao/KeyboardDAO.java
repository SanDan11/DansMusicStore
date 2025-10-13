package dao;

import database.DBConnection;
import models.Keyboard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KeyboardDAO {

    public static boolean addKeyboard(Keyboard k) {
        String sql = "INSERT INTO keyboard(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, k.getName());
            ps.setString(2, k.getBrand());
            ps.setDouble(3, k.getPrice());
            ps.setInt(4, k.getQuantity());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> getAllKeyboards() {
        List<Object[]> products = new ArrayList<>();
        String query = "SELECT id, name, brand, price, quantity FROM keyboard";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                products.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                });
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving Keyboards: " + e.getMessage());
        }

        return products;
    }

    public static boolean updateKeyboard(Keyboard k) {
        String sql = "UPDATE keyboard SET price=?, quantity=? WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, k.getPrice());
            ps.setInt(2, k.getQuantity());
            ps.setInt(3, k.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteKeyboard(int id) {
        String sql = "DELETE FROM keyboard WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
            return false;
        }
    }
}
