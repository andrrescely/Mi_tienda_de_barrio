package org.example;
//import model.Cliente;
import java.util.List;
import java.util.Scanner;
import model.Categoria;
import model.ExcelReader;
import model.Producto;
import model.Inventario;

import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.util.*;

public class Main {

    private final Scanner scanner;
    private final Inventario inventario;

    public Main(Inventario inventario) {
        scanner = new Scanner(System.in);
        this.inventario = inventario;
    }

    private void viewAllProducts() {
        Map<Categoria, List<Producto>> productosPorCategoria = inventario.organizarPorCategoria();

        System.out.println("Lista de productos organizados por categoría:");
        for (Map.Entry<Categoria, List<Producto>> entry : productosPorCategoria.entrySet()) {
            Categoria categoria = entry.getKey();
            List<Producto> productosDeCategoria = entry.getValue();

            System.out.println("Categoría: " + categoria);
            System.out.println();
            for (Producto producto : productosDeCategoria) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Descripcion: " + producto.getDescripcion());
                System.out.println("Categoria: " + producto.getCategoria());
                System.out.println("etiqueta: " + producto.getEtiqueta());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println("ID: " + producto.getId());
                System.out.println();
            }
        }
    }


    private void addProduct() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese la etiqueta del producto:");
        String etiqueta = scanner.nextLine();

        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese la categoría del producto (ASEO_HOGAR,\n" +
                "    BEBIDAS,\n" +
                "    CARNES_FRIAS_CONGELADOS,\n" +
                "    CIGARRILLOS,\n" +
                "    CUIDADO_BEBE,\n" +
                "    CUIDADO_PERSONAL,\n" +
                "    CUIDADO_ROPA,\n" +
                "    DESPENSA,\n" +
                "    DROGERIA,\n" +
                "    DULCES_POSTRES,\n" +
                "    ELECTRODOMESTICOS,\n" +
                "    HELADOS,\n" +
                "    HOGAR_DECORACION,\n" +
                "    ILUMINACION_ELECTRICOS,\n" +
                "    LACTEO_HUEVOS_REFRIGERADOS,\n" +
                "    LIMPIEZA_COCINA,\n" +
                "    MASCOTAS,\n" +
                "    PANADERIA_PASTELERIA,\n" +
                "    PASABOCAS,\n" +
                "    VINOS_LICORES,):");
        String categoriaStr = scanner.nextLine();
        Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());

        System.out.println("Ingrese el ID del producto:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(nombre, descripcion, categoria, etiqueta, precio, cantidad);

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
        ExcelReader excelReader = new ExcelReader();
        List<Producto> productos = excelReader.leerProductosDesdeExcel("C:\\Users\\Admin\\Documents\\Bk Andres\\excel\\Mi tienda de Barrio - Caso de Estudio Ada School (2).xlsx");

        Inventario inventario = new Inventario();
        for (Producto producto : productos) {
            inventario.agregarProducto(producto);

        }

        Main manager = new Main(inventario);
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
