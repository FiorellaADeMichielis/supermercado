package entidades.FormaDePago;

public class Cheque extends FormaDePago{
    @Override
    public void procesarPago(double valor) {
        System.out.println("Pago realizado con un cheque de $" + String.format("%.2f", valor));
    }
}
