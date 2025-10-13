package managers;

import dao.*;
import models.*;
import java.util.List;
import java.util.Scanner;

public class ViewProduct {

    public static void viewProductsMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== View Products ===");
        System.out.println("1. Guitar");
        System.out.println("2. Drum");
        System.out.println("3. Bass");
        System.out.println("4. Keyboard");
        System.out.println("5. Amp");
        System.out.println("6. Audio");
        System.out.println("7. Accessories");
        System.out.print("Choose category: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> showList(GuitarDAO.getAllGuitars());
            case 2 -> showList(DrumDAO.getAllDrums());
            case 3 -> showList(BassDAO.getAllBass());
            case 4 -> showList(KeyboardDAO.getAllKeyboards());
            case 5 -> showList(AmpDAO.getAllAmps());
            case 6 -> showList(AudioDAO.getAllAudio());
            case 7 -> showList(AccessoriesDAO.getAllAccessories());
            default -> System.out.println("Invalid option.");
        }
    }

    private static <T> void showList(List<T> items) {
        if (items.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (T item : items) {
                System.out.println(item.toString());
            }
        }
    }
}
