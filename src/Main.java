import logica.Parqueadero;
import modelo.Automovil;
import modelo.Motocicleta;
import modelo.Camion;
import modelo.Vehiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE PARQUEADERO ---");
            System.out.println("1. Registrar Entrada Automóvil");
            System.out.println("2. Registrar Entrada Motocicleta");
            System.out.println("3. Registrar Entrada Camión");
            System.out.println("4. Registrar Salida (Calcular Costo)");
            System.out.println("5. Listar Vehículos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            if (opcion >= 1 && opcion <= 3) {
                System.out.print("Placa: ");
                String placa = scanner.nextLine();
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();

                Vehiculo nuevoVehiculo = null;

                if (opcion == 1) {
                    System.out.print("Tipo Combustible (Gasolina/Diesel/Etc): ");
                    String comb = scanner.nextLine();
                    nuevoVehiculo = new Automovil(placa, marca, modelo, comb);
                } else if (opcion == 2) {
                    System.out.print("Cilindraje: ");
                    int cc = scanner.nextInt();
                    nuevoVehiculo = new Motocicleta(placa, marca, modelo, cc);
                } else if (opcion == 3) {
                    System.out.print("Capacidad Carga (ton): ");
                    double carga = scanner.nextDouble();
                    nuevoVehiculo = new Camion(placa, marca, modelo, carga);
                }
                
                parqueadero.registrarEntrada(nuevoVehiculo);
            
            } else if (opcion == 4) {
                System.out.print("Ingrese Placa para salida: ");
                String placaSalida = scanner.nextLine();
                parqueadero.registrarSalida(placaSalida);
            } else if (opcion == 5) {
                parqueadero.listarVehiculos();
            } else if (opcion == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 6);
        
        scanner.close();
    }
}
