/*Fundamentos de la Programacion
 * Naim Hernandez Revilla Naim
 * Ing. Sistemas Computacionales
 * Instituto Tecnoologico de Pachuca
 * Practica 1
 * Centro medico
 * */
import java.util.Scanner;

public class Centro_Medico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ADULTO_MAYOR = 15; // porcentaje de descuento
        double costo;
        double total = 0;
        double promedio;
        int total_pacientes;
        int edad;
        int opcion;
        int contador_menor = 0;
        int contador_adolescente = 0;
        int contador_adulto = 0;
        int contador_adulto_mayor = 0;
        String menor_edad = "Menor de edad";
        String adolescente = "Adolescente";
        String mayor_edad = "Mayor de edad";
        String adulto_mayor = "Adulto mayor";
        int descuento;

        do {
            System.out.println("Bienvenido");
            System.out.println("Ingresa el número de opción:");
            System.out.println("1. Consulta  2. Consultar dinero recaudado  3. Consultar tipos de paciente  4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa tu edad: ");
                    edad = scanner.nextInt();
                    System.out.println("Ingresa el costo de consulta: ");
                    costo = scanner.nextDouble();

                    descuento = 0; // se reinicia en cada consulta

                    if (edad < 12) {
                        System.out.println(menor_edad);
                        total += costo;
                        contador_menor++;
                    } else if (edad < 18) {
                        System.out.println(adolescente);
                        total += costo;
                        contador_adolescente++;
                    } else if (edad < 60) {
                        System.out.println(mayor_edad);
                        total += costo;
                        contador_adulto++;
                    } else {
                        System.out.println(adulto_mayor);
                        costo = costo - (costo * ADULTO_MAYOR / 100);
                        total += costo;
                        descuento = ADULTO_MAYOR;
                        contador_adulto_mayor++;
                    }
                    System.out.println("Total de descuento: %" + descuento);
                    System.out.println("Total a pagar: $" + costo);

                    break;

                case 2:
                    System.out.println("2. Consultar dinero recaudado");
                    System.out.println("Total de dinero recaudado: $" + total);

                    total_pacientes = contador_menor + contador_adolescente
                            + contador_adulto + contador_adulto_mayor;

                    if (total_pacientes > 0) {
                        promedio = total / total_pacientes;
                        System.out.println("Promedio pagado por paciente: $" + promedio);
                    } else {
                        System.out.println("Promedio pagado por paciente: $0.0 (aún no hay pacientes)");
                    }
                    break;

                case 3:
                    System.out.println("3. Consultar tipo de paciente");
                    System.out.println("Menor de edad: " + contador_menor);
                    System.out.println("Adolescente: " + contador_adolescente);
                    System.out.println("Mayor de edad: " + contador_adulto);
                    System.out.println("Adulto mayor: " + contador_adulto_mayor);
                    break;

                case 4:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);
    }
}