package model;

public class Producto {
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private String etiqueta;
    private double precio;
    private int cantidad;
    private int id;


    public Producto(String nombre, String descripcion, Categoria categoria, String etiqueta, double precio, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiqueta = etiqueta;
        this.precio = precio;
       this.cantidad = cantidad;
    }


    public int getId() {
        return id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public int getCantidad(){
       return cantidad;
    }

    public void setNombre(String nombre) {

       this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {

       this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(Categoria categoria) {

       this.categoria = categoria;
    }
}
