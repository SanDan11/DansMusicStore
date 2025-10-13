package dao;

import database.DBConnection;
import models.Audio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AudioDAO {

    public static boolean addAudio(Audio a) {
        String sql = "INSERT INTO audio(name, brand, price, quantity) VALUES (?, ?, ?, ?)";
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

    public static List<Audio> getAllAudio() {
        List<Audio> list = new ArrayList<>();
        String sql = "SELECT * FROM audio";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Audio(
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

    public static boolean updateAudio(Audio a) {
        String sql = "UPDATE audio SET price=?, quantity=? WHERE id=?";
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

    public static boolean deleteAudio(int id) {
        String sql = "DELETE FROM audio WHERE id=?";
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
