package org.example;
import model.Cliente;
import model.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> productos = new ArrayList<>();
        productos.add(new Product("leche", 1, 31.00));
        productos.add(new Product("leche en polvo", 2, 8.400));

        Cliente cliente1 = new Cliente(1, "Andres Cely");
        Cliente cliente2 = new Cliente(2, "Carolina Gonzales");

        Product producto = new Product("Huevos", 1, 2.500);
        Product producto2 = new Product("Pasabocas", 2, 3.200);



        // Crear una nueva instancia de Product
        Product producto1 = new Product("Producto A", 5, 10.00);

        // Verificar si el producto se quedó sin inventario
        boolean sinInventario = producto1.isOutOfStock();
        System.out.println("¿El producto se quedó sin inventario? " + sinInventario);

        // Verificar si el precio es mayor a un valor dado
        boolean precioMayor = producto1.isPriceGreaterThan(8.000);
        System.out.println("¿El precio es mayor a $8.00? " + precioMayor);

        // Verificar si el precio es menor o igual a un valor dado
        boolean precioMenorOIgual = producto1.isPriceLessThanOrEqual(10.00);
        System.out.println("¿El precio es menor o igual a $10.00? " + precioMenorOIgual);

        // Verificar si el nombre del producto contiene una palabra dada
        boolean contienePalabra = producto1.containsKeyword("Producto");
        System.out.println("¿El nombre del producto contiene la palabra 'Producto'? " + contienePalabra);







    }
}
