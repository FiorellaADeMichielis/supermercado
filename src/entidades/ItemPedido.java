package entidades;

public class ItemPedido {
    private ProductoEnStock producto;
    private int cantidad;

    public ItemPedido(ProductoEnStock producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoEnStock getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularTotal() {
        return producto.calcularTotal(cantidad);
    }
}