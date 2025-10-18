package models;

public class Guitar {
    private int id;
    private String name;
    private String brand;
    private double price;
    private int quantity;
    private String location;

    public Guitar(int id, String name, String brand, double price, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }

    public Guitar(String name, String brand, double price, int quantity, String location) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getLocation() { return location; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return name + " (" + brand + ") - $" + price + " [" + quantity + "]" + " | Location" + location;
    }
}
