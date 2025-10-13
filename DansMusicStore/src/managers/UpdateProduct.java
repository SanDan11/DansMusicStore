package managers;

import dao.*;
import models.*;
import java.util.Scanner;

public class UpdateProduct {

    public static void updateProductMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Update Product ===");
        System.out.println("1. Guitar");
        System.out.println("2. Drum");
        System.out.println("3. Bass");
        System.out.println("4. Keyboard");
        System.out.println("5. Amp");
        System.out.println("6. Audio");
        System.out.println("7. Accessories");
        System.out.print("Choose category: ");
        int choice = input.nextInt();

        System.out.print("Enter product ID to update: ");
        int id = input.nextInt();
        System.out.print("Enter new price: ");
        double price = input.nextDouble();
        System.out.print("Enter new quantity: ");
        int qty = input.nextInt();

        switch (choice) {
            case 1 -> GuitarDAO.updateGuitar(new Guitar(id, "", "", price, qty));
            case 2 -> DrumDAO.updateDrum(new Drum(id, "", "", price, qty));
            case 3 -> BassDAO.updateBass(new Bass(id, "", "", price, qty));
            case 4 -> KeyboardDAO.updateKeyboard(new Keyboard(id, "", "", price, qty));
            case 5 -> AmpDAO.updateAmp(new Amp(id, "", "", price, qty));
            case 6 -> AudioDAO.updateAudio(new Audio(id, "", "", price, qty));
            case 7 -> AccessoriesDAO.updateAccessories(new Accessories(id, "", "", price, qty));
            default -> System.out.println("Invalid option.");
        }

        System.out.println("✅ Product updated successfully!");
    }
}
