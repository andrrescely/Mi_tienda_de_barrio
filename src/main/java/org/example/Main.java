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

        // Mostrar menú de categorías y obtener selección del usuario
        System.out.println("Seleccione una categoría:");
        for (int i = 0; i < Categoria.values().length; i++) {
            System.out.println((i + 1) + ". " + Categoria.values()[i]);
        }
        int opcionCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcionCategoria >= 1 && opcionCategoria <= Categoria.values().length) {
            Categoria categoria = Categoria.values()[opcionCategoria - 1];

            System.out.println("Ingrese el ID del producto:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            Producto producto = new Producto(nombre, descripcion, categoria, etiqueta, precio, cantidad);
            producto.setId(id);

            inventario.agregarProducto(producto);
            System.out.println("Producto agregado exitosamente.");
        } else {
            System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }
    }


    private void removeProduct() {
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String nombre = scanner.nextLine();
        nombre = nombre.toLowerCase();

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
        nombre = nombre.toLowerCase();

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
    private void viewProductsByCategory() {
        displayMenuCategorias();
        int opcionCategoria = obtenerOpcionCategoria();

        if (opcionCategoria >= 1 && opcionCategoria <= Categoria.values().length - 1) {
            Categoria categoriaSeleccionada = Categoria.values()[opcionCategoria - 1];

            List<Producto> productosCategoria = inventario.getProductosPorCategoria(categoriaSeleccionada);

            if (!productosCategoria.isEmpty()) {
                System.out.println("Productos de la categoría " + categoriaSeleccionada + ":");
                for (Producto producto : productosCategoria) {
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Descripcion: " + producto.getDescripcion());
                    System.out.println("Categoria: " + producto.getCategoria());
                    System.out.println("etiqueta: " + producto.getEtiqueta());
                    System.out.println("Precio: " + producto.getPrecio());
                    System.out.println("Cantidad: " + producto.getCantidad());
                    System.out.println("ID: " + producto.getId());
                    System.out.println();
                }
            } else {
                System.out.println("No se encontraron productos en la categoría especificada.");
            }
        } else {
            System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }
    }


    //......................................................................
    private void searchProductByName() {
        System.out.println("Ingrese el nombre del producto a buscar:");
        String nombre = scanner.nextLine().toLowerCase();

        List<Producto> productosEncontrados = inventario.buscarProductosPorNombre(nombre);

        if (!productosEncontrados.isEmpty()) {
            System.out.println("Productos encontrados:");
            for (Producto producto : productosEncontrados) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Descripcion: " + producto.getDescripcion());
                System.out.println("Categoria: " + producto.getCategoria());
                System.out.println("etiqueta: " + producto.getEtiqueta());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println("ID: " + producto.getId());
                System.out.println();
            }
        } else {
            System.out.println("No se encontraron productos con el nombre especificado.");
        }
    }



    //......................................................................





    public void runMenu() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            handleUserChoice(choice);
        } while (choice != 6);
    }

    public void displayMenu() {
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador de Inventario          |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Ver productos por categoría           |");
        System.out.println("6. Buscar producto por nombre            |");
        System.out.println("7. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 6)  ");
    }




    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                viewAllProducts();
                break;
            case 5:
                viewProductsByCategory();
                break;
            case 6:
                searchProductByName();
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida. Por favor intenta de nuevo.");
        }
    }

    public void displayMenuCategorias() {
        System.out.println("±----------------------------------------±");
        System.out.println("|          Menú de Categorías            |");
        System.out.println("±----------------------------------------±");

        int indice = 1;
        for (Categoria categoria : Categoria.values()) {
            if (categoria != Categoria.OTRA_CATEGORIA) {
                System.out.println(indice + ". " + categoria);
                indice++;
            }
        }

        System.out.print("   Ingresa el número de la categoría (1 - " + (Categoria.values().length - 1) + "): ");
    }

    public int obtenerOpcionCategoria() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            try {
                int opcion = Integer.parseInt(input);
                return opcion;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
            }
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
