package dao;

import database.DBConnection;
import models.Bass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BassDAO {

    public static boolean addBass(Bass b) {
        String sql = "INSERT INTO bass(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.getName());
            ps.setString(2, b.getBrand());
            ps.setDouble(3, b.getPrice());
            ps.setInt(4, b.getQuantity());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> getAllBasses() {
        List<Object[]> products = new ArrayList<>();
        String query = "SELECT id, name, brand, price, quantity FROM bass";

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
            System.out.println("Error retrieving basses: " + e.getMessage());
        }

        return products;
    }

    public static boolean updateBass(Bass b) {
        String sql = "UPDATE bass SET price=?, quantity=? WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, b.getPrice());
            ps.setInt(2, b.getQuantity());
            ps.setInt(3, b.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteBass(int id) {
        String sql = "DELETE FROM bass WHERE id=?";
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
