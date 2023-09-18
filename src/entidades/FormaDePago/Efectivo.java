package entidades.FormaDePago;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Efectivo extends FormaDePago{
    @Override
    public void procesarPago(double valor){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el monto con el cual va a pagar: ");
        try{
            double monto = lectura.nextDouble();
            if(monto >= valor){
                System.out.println("Pago de $" + String.format("%.2f", valor)+ " en efectivo. Recibe como vuelto $" + (monto - valor));
            }else{
                System.out.println("monto ingresado insuficiente.");
            }
        }catch(InputMismatchException e){
            System.out.println("Valor no válido" + e);
        }
    }
}
