package managers;

public class Products {

    protected int id;
    protected String name;
    protected int quantity;
    protected  double price;

    public Products(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | " + name + " | " + "Qty: " + quantity + " | $" + price);
    }
}
