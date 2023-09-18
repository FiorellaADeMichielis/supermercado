package entidades;

public class ProductoEnStock extends Producto{
    public ProductoEnStock(String nombre, double precio, int stock){
        super(nombre, precio, stock);
    }
    @Override
    public double calcularTotal(int cantidad){
        return getPrecio() * cantidad;
    }


}
