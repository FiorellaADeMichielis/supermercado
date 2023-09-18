package entidades;
import entidades.FormaDePago.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> carrito = new ArrayList<>();
    private FormaDePago pago;

    public void AgregarAlCarrito(ItemPedido item) {
        carrito.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : carrito) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void finalizarPedido(FormaDePago forma) {
        pago = forma;
        pago.procesarPago(calcularTotal());
    }
}