package model;

import java.util.List;

public interface ProductServiceI {
    void addProduct(Producto product);
    void deleteProduct(int productId);
    Producto findById(int productId);
    List<Producto> getAllProducts();
}

