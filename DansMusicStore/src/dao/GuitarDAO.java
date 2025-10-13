package dao;

import database.DBConnection;
import models.Guitar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuitarDAO {

    public static boolean addGuitar(Guitar g) {
        String sql = "INSERT INTO guitar(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, g.getName());
            ps.setString(2, g.getBrand());
            ps.setDouble(3, g.getPrice());
            ps.setInt(4, g.getQuantity());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> getAllGuitars() {
        List<Object[]> products = new ArrayList<>();
        String query = "SELECT id, name, brand, price, quantity FROM guitar";

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
            System.out.println("Error retrieving guitars: " + e.getMessage());
        }

        return products;
    }

    public static boolean updateGuitar(Guitar g) {
        String sql = "UPDATE guitar SET price=?, quantity=? WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, g.getPrice());
            ps.setInt(2, g.getQuantity());
            ps.setInt(3, g.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteGuitar(int id) {
        String sql = "DELETE FROM guitar WHERE id=?";
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
