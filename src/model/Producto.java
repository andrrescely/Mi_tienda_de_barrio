package model;

public class Producto {
    private int id; // Agrega un campo para el ID
    private String nombre;
    private double precio;
    private Categoria categoria;

   /* public Producto(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria; // Aquí asignamos la categoría proporcionada
    }*/
   public Producto(String nombre, double precio, Categoria categoria) {
       this.id = id;
       this.nombre = nombre;
       this.precio = precio;
       this.categoria = categoria;
   }
    public int getId() {
        return id; // Implementa el método getId() para obtener el ID
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
