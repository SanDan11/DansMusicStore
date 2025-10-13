package dao;

import database.DBConnection;
import models.Accessories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessoriesDAO {

    public static boolean addAccessories(Accessories a) {
        String sql = "INSERT INTO accessories(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getName());
            ps.setString(2, a.getBrand());
            ps.setDouble(3, a.getPrice());
            ps.setInt(4, a.getQuantity());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> getAllAccessories() {
        List<Object[]> products = new ArrayList<>();
        String query = "SELECT id, name, brand, price, quantity FROM accessories";

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
            System.out.println("Error retrieving accessories: " + e.getMessage());
        }

        return products;
    }

    public static boolean updateAccessories(Accessories a) {
        String sql = "UPDATE accessories SET price=?, quantity=? WHERE id=?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, a.getPrice());
            ps.setInt(2, a.getQuantity());
            ps.setInt(3, a.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteAccessories(int id) {
        String sql = "DELETE FROM accessories WHERE id=?";
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
