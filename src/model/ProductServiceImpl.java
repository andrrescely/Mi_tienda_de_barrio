package model;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductServiceI {
    private final Inventario inventario;

    public ProductServiceImpl(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public void addProduct(Producto product) {
        inventario.agregarProducto(product);
    }

    @Override
    public void deleteProduct(int productId) {
        inventario.eliminarProducto(productId);
    }

    @Override
    public Producto findById(int productId) {
        return inventario.obtenerProductoPorId(productId);
    }


    @Override
    public List<Producto> getAllProducts() {
        return inventario.getProductos();
    }


}


