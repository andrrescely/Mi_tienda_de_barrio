package model;

public class Inventario {
    private int id;
    private Product product;
    private int cantidad;

    public Inventario(int id, Product product, int cantidad) {
        this.id = id;
        this.product = product;
        this.cantidad = cantidad;
    }


}

