package model;
import model.Producto;


import java.util.ArrayList;
import java.util.List;

public class Ventas {
    private List<Producto> carrito;

    public Ventas() {
        carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        carrito.add(producto);
    }

    public void mostrarCarrito() {
        System.out.println("Carrito de Compras:");
        for (Producto producto : carrito) {
            System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : carrito) {
            total += producto.getPrecio();
        }
        return total;
    }
}
