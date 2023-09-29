package entidades;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<ProductoEnStock> stock = new ArrayList<>();

    public void agregarAlStock(ProductoEnStock producto) {
        stock.add(producto);
    }

    public List<ProductoEnStock> getStock() {
        return stock;
    }

    public ProductoEnStock buscarProducto(String nombre) {
        for (ProductoEnStock producto : getStock()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
