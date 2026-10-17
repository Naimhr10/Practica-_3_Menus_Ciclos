/*Fundamentos de la Programacion
 * Naim Hernandez Revilla Naim
 * Ing. Sistemas Computacionales
 * Instituto Tecnoologico de Pachuca
 * Practica 1
 * Gasolinera
 * */
import java.util.Scanner;

public class Gasolinera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double litros, precio, importe, descuento, total;
        double totalLitros = 0;
        double importeAntes = 0;
        double totalCobrado = 0;
        double promedio;
        int cargas = 0;
        int cargasDescuento = 0;
        int continuar = 1;

        while (continuar == 1) {
            System.out.print("Litros cargados: ");
            litros = scanner.nextDouble();

            System.out.print("Precio por litro: ");
            precio = scanner.nextDouble();

            if (litros > 0 && precio > 0) {
                importe = litros * precio;
                descuento = 0;

                if (litros >= 40) {
                    descuento = importe * 0.05;
                    cargasDescuento = cargasDescuento + 1;
                }

                total = importe - descuento;

                cargas ++;
                totalLitros = totalLitros + litros;
                importeAntes = importeAntes + importe;
                totalCobrado = totalCobrado + total;

                System.out.println("Su importe es: $" + importe);
                System.out.println("Su descuento es de: $" + descuento);
                System.out.println("El total a pagar: $" + total);
            } else {
                System.out.println("Los litros y el precio ingreado deben ser mayores que cero...");
            }

            System.out.print("Quisiera registrar otra carga? \n(\n 1=Si, \n 0=No): ");
            continuar = scanner.nextInt();
        }

        System.out.println("Cargas registradas: " + cargas);
        System.out.println("Cargas con descuento: " + cargasDescuento);
        System.out.println("Litros vendidos: " + totalLitros);
        System.out.println("Importe antes de descuentos: $" + importeAntes);
        System.out.println("Total cobrado: $" + totalCobrado);

        if (cargas > 0) {
            promedio = totalCobrado / cargas;
            System.out.println("Importe promedio por carga: $" + promedio);
        } else {
            System.out.println("No se registraron cargas validas.");
        }

    }
}