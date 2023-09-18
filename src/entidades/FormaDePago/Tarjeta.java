package entidades.FormaDePago;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tarjeta extends FormaDePago{
    @Override
    public void procesarPago(double valor){
        Scanner lectura = new Scanner(System.in);
        long tarjeta = 0;
        int pin = 0;
        boolean validez = false;
        while (!validez){
            try {
                System.out.println("Ingrese su número de tarjeta: ");
                tarjeta = lectura.nextLong();
                lectura.nextLine();
                validez = true;
            } catch (InputMismatchException e) {
                System.out.println("El número de tarjeta no es válido. Intente de nuevo.");
                lectura.nextLine();
            }
        }
        validez = false;
        while (!validez) {
            try {
                System.out.println("Ingrese su PIN: ");
                pin = lectura.nextInt();
                lectura.nextLine();
                validez = true;
            } catch (InputMismatchException e) {
                System.out.println("El PIN ingresado no es válido. Intente de nuevo.");
                lectura.nextLine();
            }
        }
        System.out.println("Pago realizado de $" + String.format("%.2f", valor));
    }
}
