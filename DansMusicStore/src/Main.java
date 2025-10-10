import Inventory.GuitarInventory;
import managers.AddProduct;
import managers.DeleteProduct;
import managers.SearchProduct;
import managers.ViewProduct;

import java.awt.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static database.DBConnection.connect;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        AddProduct add = new AddProduct();
        DeleteProduct delete = new DeleteProduct();
        SearchProduct search = new SearchProduct();
        ViewProduct view = new ViewProduct();

        int choice;

        do {
            System.out.println("***** Inventory *****");
            System.out.println("1. Search Product");
            System.out.println("2. View Product");
            System.out.println("3. Add Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Save and Exit");
            System.out.println("*********************");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> { }
                case 2 -> { }
                case 3 -> { }
                case 4 -> { }
                case 5 -> { }
                default -> System.out.println("System not ready");

            }

        } while (choice != 5);

        input.close();
        System.out.println("Exiting program");
        }

        public static void showViewMenu(Scanner input) {
        int viewChoice;

        do {
            System.out.println("***** View Products *****");
            System.out.println("1. View Guitars");
            System.out.println("2. View Bass");
            System.out.println("3. View Drums");
            System.out.println("4. View Pianos");
            System.out.println("5. Go back");
            System.out.println("************************");
            System.out.println("> ");

            viewChoice = input.nextInt();
            input.nextLine();

            switch (viewChoice) {
                case 1 -> {
                    System.out.println("Display Guitar Inventory");
                    new GuitarInventory().showAll();
                }
                case 2 -> { }
                case 3 -> { }
                case 5 -> { }
                case 6 -> { }
                default -> System.out.println("Invalid Option");

            }

        } while (viewChoice != 4);

        }
    }