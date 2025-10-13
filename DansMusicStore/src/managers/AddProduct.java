package managers;

import dao.*;
import models.*;

import java.util.Locale;
import java.util.Scanner;

public class AddProduct {

    public static void addProductMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Add New Product ===");
        System.out.println("1. Guitar");
        System.out.println("2. Drum");
        System.out.println("3. Bass");
        System.out.println("4. Keyboard");
        System.out.println("5. Amp");
        System.out.println("6. Audio");
        System.out.println("7. Accessories");
        System.out.print("Choose category: ");
        int choice = input.nextInt();
        input.nextLine();

        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter brand: ");
        String brand = input.nextLine();
        System.out.print("Enter price: ");
        double price = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        switch (choice) {
            case 1 -> GuitarDAO.addGuitar(new Guitar(name, brand, price, quantity));
            case 2 -> DrumDAO.addDrum(new Drum(name, brand, price, quantity));
            case 3 -> BassDAO.addBass(new Bass(name, brand, price, quantity));
            case 4 -> KeyboardDAO.addKeyboard(new Keyboard(name, brand, price, quantity));
            case 5 -> AmpDAO.addAmp(new Amp(name, brand, price, quantity));
            case 6 -> AudioDAO.addAudio(new Audio(name, brand, price, quantity));
            case 7 -> AccessoriesDAO.addAccessories(new Accessories(name, brand, price, quantity));
            default -> System.out.println("Invalid option.");
        }

        System.out.println("Product added successfully!");
    }

    public static void addProduct(String name, String brand, double price, int quantity, String category) {

        switch (category.toLowerCase()) {
            case "guitar" -> GuitarDAO.addGuitar(new Guitar (name, brand, price, quantity));
            case "drums" -> DrumDAO.addDrum(new Drum(name, brand, price, quantity));
            case "bass" -> BassDAO.addBass(new Bass(name, brand, price, quantity));
            case "keyboard" -> KeyboardDAO.addKeyboard(new Keyboard(name, brand, price, quantity));
            case "amp" -> AmpDAO.addAmp(new Amp(name, brand, price, quantity));
            case "accessories" -> AccessoriesDAO.addAccessories(new Accessories(name, brand, price, quantity));
            default -> throw new IllegalArgumentException("Invalid category: " + category);
        }
        System.out.println("Product added successfully to table: " + category);
    }

}
