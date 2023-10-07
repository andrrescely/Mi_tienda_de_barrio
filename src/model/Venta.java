package model;
import java.util.Date;
import java.util.List;

public class Venta {
    private int id;
    private Date fecha;
    private List<Product> product;

    public Venta(int id, Date fecha, List<Product> product) {
        this.id = id;
        this.fecha = fecha;
        this.product = product;
    }


}
