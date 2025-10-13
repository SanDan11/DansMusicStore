package dao;

import database.DBConnection;
import models.Drum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrumDAO {

    public static boolean addDrum(Drum d) {
        String sql = "INSERT INTO drum(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getBrand());
            ps.setDouble(3, d.getPrice());
            ps.setInt(4, d.getQuantity());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> getAllDrums() {
        List<Object[]> products = new ArrayList<>();
        String query = "SELECT id, name, brand, price, quantity FROM drum";

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
            System.out.println("Error retrieving drum: " + e.getMessage());
        }

        return products;
    }
    public static boolean updateDrum(Drum d) {
        String sql = "UPDATE drum SET price=?, quantity=? WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, d.getPrice());
            ps.setInt(2, d.getQuantity());
            ps.setInt(3, d.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteDrum(int id) {
        String sql = "DELETE FROM drum WHERE id=?";
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
