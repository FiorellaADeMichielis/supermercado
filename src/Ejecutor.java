import entidades.*;
import entidades.FormaDePago.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ejecutor {
    public static void main(String[] args) {
        Stock enStock = new Stock();
        menu(enStock);
        }
    public static void menu(Stock enStock) {
        Scanner lectura = new Scanner(System.in);
        int respuesta;
        do {
            try {
                System.out.println("\t\t\tBienvenido\n----------------------------------------\n 1. Ingresar productos al stock.\n 2. Realizar un pedido\n 3. Salir");
                respuesta = lectura.nextInt();
                lectura.nextLine();
                switch (respuesta) {
                    case 1:
                        agregarAlStock(enStock);
                        break;
                    case 2:
                        realizarPedido(enStock);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                lectura.nextLine();
                respuesta = 0;
            }
        } while (respuesta != 3);
    }
    public static void agregarAlStock(Stock enStock){
        Scanner lectura = new Scanner(System.in);
        boolean respuesta = true;

        System.out.println("Ingrese los datos en el siguiente orden: nombre - precio - stock");
        while(respuesta){
            String nombre = lectura.nextLine();
            double precio = 0.0;
            int stock = 0;
            try {
                precio = lectura.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un precio válido. Los precios deben incluir su parte decimal");
                continue;
            }
            try {
                stock = lectura.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese una cantidad de stock válida (número entero).");
                continue;
            }

            enStock.agregarAlStock(new ProductoEnStock(nombre, precio, stock));
            System.out.println("En caso de querer ingresar un nuevo producto, ingrese 1. Caso contrario, ingrese cualquier otro numero.");
            try{
                int opcion = lectura.nextInt();
                lectura.nextLine();
                respuesta = (opcion == 1);
            }catch(InputMismatchException e){
                System.out.println("Error: no se ha ingresado un numero.");
            }
        }
        menu(enStock);
    }
    public static void realizarPedido(Stock enStock){
        Scanner lectura = new Scanner(System.in);
        Pedido cliente = new Pedido();
        int cantidad = 0;
        boolean respuesta = true;
        while (respuesta) {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = lectura.nextLine();
            ProductoEnStock productoBuscado = enStock.buscarProducto(nombre);

            if (productoBuscado != null) {
                try{
                    System.out.print("Ingrese la cantidad que desea agregar al carrito: ");
                    cantidad = lectura.nextInt();
                    lectura.nextLine();
                }catch(InputMismatchException e) {
                    System.out.println("Cantidad no válida.");
                    lectura.nextLine();
                    }
                ItemPedido item = new ItemPedido(productoBuscado, cantidad);
                cliente.AgregarAlCarrito(item);
                System.out.println("Producto agregado al carrito\nSi desea agregar otro producto, ingrese 1. De lo contrario, ingrese cualquier otro número.");
                try {
                    int opcion = lectura.nextInt();
                    lectura.nextLine();
                    respuesta = (opcion == 1);
                }catch(InputMismatchException e) {
                    System.out.println("Error: no se ha ingresado un número.");
                    respuesta = false;
                }
            } else {
                System.out.println("El producto no se encuentra en stock.");
                respuesta = false;
            }
        }
        procesoPago(cliente);
    }
    public static void procesoPago(Pedido cliente){
        Scanner lectura = new Scanner(System.in);
        FormaDePago forma = null;
        while(true) {
            try {
                System.out.println("Por favor escoja un método de pago:\n 1. Efectivo\n 2. Cheque\n 3.Tarjeta");
                int opcion = lectura.nextInt();
                lectura.nextLine();
                switch (opcion) {
                    case 1:
                        forma = new Efectivo();
                        cliente.finalizarPedido(forma);
                        return;
                    case 2:
                        forma = new Cheque();
                        cliente.finalizarPedido(forma);
                        return;
                    case 3:
                        forma = new Tarjeta();
                        cliente.finalizarPedido(forma);
                        return;
                    default:
                        System.out.println("Opción no válida, por favor seleccione un método válido.");
                        opcion = lectura.nextInt();
                        lectura.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                lectura.nextLine();
            }
        }
    }
}
