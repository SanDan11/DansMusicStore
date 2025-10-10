package managers;

public class GuitarProducts extends Products {

    private String brand;

    public GuitarProducts(int id, String name, int quantity, double price, String brand) {
        super(id, name, quantity, price);
        this.brand = brand;
    }

    public String toString () {
        return " Guitar: " + name + " | Brand: " + brand + " | Qty: " + quantity + " | $" + price;
    }
}
