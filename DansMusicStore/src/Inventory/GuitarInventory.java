package Inventory;

import managers.GuitarProducts;
import java.util.ArrayList;

public class GuitarInventory {

    private ArrayList<GuitarProducts> guitars = new ArrayList<>();

    public GuitarInventory() {
        // Fender Guitars
        guitars.add(new GuitarProducts(1, "Stratocaster", 6, 699.99, "Fender"));
        guitars.add(new GuitarProducts(2, "Mustange", 9, 599.99, "Fender"));

        // Jackson Guitars

        // Ibanez Guitars

        // PRS guitars



    }

    public void addGuitar(GuitarProducts g) {
        guitars.add(g);
    }

    public void showAll() {
        System.out.println("***** Guitar Inventory *****");
        for (GuitarProducts g : guitars) {
            g.displayInfo();
        }
    }

    public ArrayList<GuitarProducts> getGuitars() {
        return guitars;
    }
}
