package model;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
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
