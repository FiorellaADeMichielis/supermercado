package entidades;

abstract public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public Producto(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void disminuirStock(int cantidad) throws Exception {
        if (cantidad > stock) {
            throw new  Exception("No hay suficiente en stock");
        }
        stock -= cantidad;
    }
    public abstract double calcularTotal(int cantidad);
}
