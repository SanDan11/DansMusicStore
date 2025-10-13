package main;

import managers.*;
import database.DatabaseSetup;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Make sure tables exist
        DatabaseSetup.createTables();

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🎸 Music Store Inventory");
            System.out.println("========================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> AddProduct.addProductMenu();
                case 2 -> ViewProduct.viewProductsMenu();
                case 3 -> UpdateProduct.updateProductMenu();
                case 4 -> DeleteProduct.deleteProductMenu();
                case 5 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }

        input.close();
    }
}
