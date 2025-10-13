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

    public static List<Guitar> getAllGuitars() {
        List<Guitar> list = new ArrayList<>();
        String sql = "SELECT * FROM guitar";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Guitar(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
        return list;
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
