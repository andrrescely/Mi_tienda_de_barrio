package model;

public class Producto {
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;

        }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
}
