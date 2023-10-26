package org.example;
//import model.Cliente;
//import model.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Categoria;
import model.Producto;
import model.Inventario;
import java.util.List;
import java.util.Scanner;


public class Main {

    private final Scanner scanner;
    private final Inventario inventario;

    public Main() {
        scanner = new Scanner(System.in);
        inventario = new Inventario();
    }

    private void addProduct() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese la categoría del producto (ALIMENTOS, LIMPIEZA, HIGIENE_PERSONAL, ELECTRODOMESTICOS, OTROS):");
        String categoriaStr = scanner.nextLine();
        Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());

        Producto producto = new Producto(nombre, precio);
        inventario.agregarProducto(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    private void removeProduct() {
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String nombre = scanner.nextLine();

        if (inventario.existeProducto(nombre)) {
            inventario.eliminarProducto(nombre);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    private void updateProduct() {
        System.out.println("Ingrese el nombre del producto a actualizar:");
        String nombre = scanner.nextLine();

        if (inventario.existeProducto(nombre)) {
            System.out.println("Ingrese el nuevo nombre del producto:");
            String nuevoNombre = scanner.nextLine();

            System.out.println("Ingrese el nuevo precio del producto:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();

            inventario.actualizarProducto(nombre, nuevoNombre, nuevoPrecio);
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    private void viewAllProducts() {
        List<Producto> productos = inventario.getProductos();

        System.out.println("Lista de productos:");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }

    public void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            handleUserChoice(choice);
        } while (choice != 5);
    }

    public void displayMenu() {
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador de Inventario          |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 5)  ");
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> viewAllProducts();
            case 5 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }
    }

    public static void main(String[] args) {
        Main manager = new Main();
        manager.runMenu();
    }





    /*public static void main(String[] args) {

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

     */
}
