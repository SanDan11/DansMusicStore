package managers;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class SearchProduct {
    public static void searchGuitars(String keyword) {

        final String sql = "SELECT id, name, brand, price, quantity "
                + "FROM guitars WHERE name LIKE ? OR brand LIKE ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String pattern = "%" + keyword + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);

            try (ResultSet rs = ps.executeQuery()) {
                int found = 0;
                System.out.println("--- Search results for \"" + keyword + "\"---");
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String brand = rs.getString("price");
                    double price = rs.getDouble("price");
                    int qty = rs.getInt("quantity");

                    System.out.printf("#%d | %-20s | %-12s | $%.2f | qty: %d%n",
                            id, name, brand, price, qty);
                    found++;
                }
                if (found == 0) {
                    System.out.println("(no matching records)");
                }
            }
        } catch (SQLException e) {
            System.out.println("Search failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Search for a guitar");
        System.out.print("Enter keyword: ");
        String keyword = input.nextLine();
        searchGuitars(keyword);
    }
}
