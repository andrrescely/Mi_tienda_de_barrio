package model;

public class Product {

    private String name;
    private int inventory;
    private double price;

    // Constructor
    public Product(String name, int inventory, double price) {
        this.name = name;
        this.inventory = inventory;
        this.price = price;
    }

    // Método para determinar si el producto se quedó sin inventario
    public boolean isOutOfStock() {
        return inventory == 0;
    }

    // Método para determinar si el precio del producto es mayor a un valor dado
    public boolean isPriceGreaterThan(double value) {
        return price > value;
    }

    // Método para determinar si el precio del producto es menor o igual a un valor dado
    public boolean isPriceLessThanOrEqual(double value) {
        return price <= value;
    }

    // Método para determinar si el nombre del producto contiene una palabra dada
    public boolean containsKeyword(String keyword) {
        return name.contains(keyword);
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

