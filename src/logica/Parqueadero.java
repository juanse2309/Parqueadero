package logica;

import modelo.Vehiculo;
import modelo.Automovil;
import modelo.Motocicleta;
import modelo.Camion;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parqueadero {
    private List<Vehiculo> vehiculos;
    
    // Tarifas por hora (arbitrarias para el ejemplo)
    private static final double TARIFA_AUTO = 50.0;
    private static final double TARIFA_MOTO = 20.0;
    private static final double TARIFA_CAMION = 100.0;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Entrada registrada: " + vehiculo);
    }

    public void registrarSalida(String placa) {
        Optional<Vehiculo> vehiculoOpt = buscarVehiculo(placa);
        
        if (vehiculoOpt.isPresent()) {
            Vehiculo v = vehiculoOpt.get();
            double costo = calcularCosto(v);
            vehiculos.remove(v);
            System.out.println("--- Salida ---");
            System.out.println("Vehículo: " + v.getPlaca());
            System.out.println("Tiempo total: " + calcularHoras(v) + " horas");
            System.out.println("Total a pagar: $" + costo);
        } else {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
    }

    // Método polimórfico (o que usa polimorfismo mediante instanceof) para calcular costo
    public double calcularCosto(Vehiculo v) {
        long horas = calcularHoras(v);
        // Cobro mínimo de 1 hora
        if (horas == 0) horas = 1;

        if (v instanceof Automovil) {
            return horas * TARIFA_AUTO;
        } else if (v instanceof Motocicleta) {
            return horas * TARIFA_MOTO;
        } else if (v instanceof Camion) {
            return horas * TARIFA_CAMION;
        }
        return 0;
    }

    private long calcularHoras(Vehiculo v) {
        Duration duracion = Duration.between(v.getHoraEntrada(), LocalDateTime.now());
        return duracion.toHours();
    }

    private Optional<Vehiculo> buscarVehiculo(String placa) {
        return vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }
    
    public void listarVehiculos() {
        System.out.println("\n--- Vehículos en Parqueadero ---");
        if (vehiculos.isEmpty()) {
            System.out.println("Parqueadero vacío.");
        } else {
            for (Vehiculo v : vehiculos) {
                System.out.println(v);
            }
        }
    }
}
