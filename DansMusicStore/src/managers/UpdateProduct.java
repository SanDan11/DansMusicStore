package managers;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class UpdateProduct {

    public static void updateGuitar(int id, double newPrice, int newQuantity) {

        final String sql = "UPDATE guitars set price = ?, quantity = ? WHERE id = ?";

        try(Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, newPrice);
            ps.setInt(2, newQuantity);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Update guitar ID " + id + " successfully.");
            } else {
                System.out.println("No record found with that ID" + id);
            }
        } catch (SQLException e)  {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("🎸 Update Guitar Info");
        System.out.print("Enter ID to update: ");
        int id = input.nextInt();

        System.out.print("Enter new price: ");
        double price = input.nextDouble();

        System.out.print("Enter new quantity: ");
        int quantity = input.nextInt();

        updateGuitar(id, price, quantity);
    }

}
