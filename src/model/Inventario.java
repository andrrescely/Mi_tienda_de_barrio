package model;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }




    public void agregarProductoPorId(int id) {
        Producto producto = obtenerProductoPorId(id);
        if (producto != null) {
            agregarProducto(producto);
        }
    }

    public Producto obtenerProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto con el ID especificado
    }

    public Map<Categoria, List<Producto>> organizarPorCategoria() {
        Map<Categoria, List<Producto>> productosPorCategoria = new HashMap<>();

        for (Producto producto : productos) {
            Categoria categoria = producto.getCategoria();
            productosPorCategoria.computeIfAbsent(categoria, k -> new ArrayList<>()).add(producto);
        }

        return productosPorCategoria;
    }



    public boolean existeProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarProducto(String nombre) {
        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
        }
    }

    public void eliminarProducto(int id) {
        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
        }
    }


    public void actualizarProducto(String nombre, String nuevoNombre, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
