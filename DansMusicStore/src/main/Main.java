package main;


import database.DatabaseSetup;
import managers.AddProduct;
import managers.ViewProduct;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Music Store Inventory");
        System.out.println("1. Setup Database");
        System.out.println("2. Add Product");
        System.out.println("3. View Products");
        System.out.println("4. Search Products");
        System.out.println("5. Update Products");
        System.out.println("0: Exit ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> DatabaseSetup.main(null);
            case 2 -> AddProduct.main(null);
            case 3 -> ViewProduct.main(null);
            case 4 -> managers.SearchProduct.main(null);
            case 5 -> managers.UpdateProduct.main(null);
            default -> System.out.println("Invalid choice");
        }
    }
}