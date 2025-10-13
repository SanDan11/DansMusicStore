package managers;

import dao.*;
import java.util.Scanner;

public class DeleteProduct {

    public static void deleteProductMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Delete Product ===");
        System.out.println("1. Guitar");
        System.out.println("2. Drum");
        System.out.println("3. Bass");
        System.out.println("4. Keyboard");
        System.out.println("5. Amp");
        System.out.println("6. Audio");
        System.out.println("7. Accessories");
        System.out.print("Choose category: ");
        int choice = input.nextInt();

        System.out.print("Enter product ID to delete: ");
        int id = input.nextInt();

        switch (choice) {
            case 1 -> GuitarDAO.deleteGuitar(id);
            case 2 -> DrumDAO.deleteDrum(id);
            case 3 -> BassDAO.deleteBass(id);
            case 4 -> KeyboardDAO.deleteKeyboard(id);
            case 5 -> AmpDAO.deleteAmp(id);
            case 6 -> AudioDAO.deleteAudio(id);
            case 7 -> AccessoriesDAO.deleteAccessories(id);
            default -> System.out.println("Invalid option.");
        }

        System.out.println("✅ Product deleted successfully!");
    }
}
