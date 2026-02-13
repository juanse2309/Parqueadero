# Proyecto Gestión de Parqueadero (Actividad 3)

Este proyecto implementa un sistema para la gestión de un parqueadero utilizando herencia y polimorfismo.

## Estructura del Proyecto

### Paquete `modelo`
- **Vehiculo (Abstracta)**: Clase padre con atributos comunes (placa, marca, modelo, hora de entrada).
- **Automovil**: Hereda de Vehiculo, añade tipo de combustible.
- **Motocicleta**: Hereda de Vehiculo, añade cilindraje.
- **Camion**: Hereda de Vehiculo, añade capacidad de carga.

### Paquete `logica`
- **Parqueadero**: Gestiona la lista de vehículos, registra entradas y salidas, y calcula costos usando polimorfismo.

### Clase Principal
- **Main.java**: Menú de consola para registrar vehículos y probar el cálculo de costos.

## Tarifas
- **Automóvil**: $50 / hora
- **Moto**: $20 / hora
- **Camión**: $100 / hora

## Cómo Ejecutar

1.  Asegúrate de tener instalado el JDK de Java.
2.  Navega a la carpeta raíz del proyecto.
3.  Compila el código:
    ```bash
    javac -d bin -sourcepath src src/Main.java
    ```
4.  Ejecuta el programa:
    ```bash
    java -cp bin Main
    ```

## Autor
Juan Sebastian Novoa

## Pruebas de Ejecución
A continuación se presenta un ejemplo de interacción con el sistema mediante la consola:

```text
--- GESTIÓN DE PARQUEADERO ---
1. Registrar Entrada Automóvil
2. Registrar Entrada Motocicleta
3. Registrar Entrada Camión
4. Registrar Salida (Calcular Costo)
5. Listar Vehículos
6. Salir
Seleccione una opción: 1
Placa: ABC-123
Marca: Toyota
Modelo: Corolla
Tipo Combustible (Gasolina/Diesel/Etc): Gasolina
Entrada registrada: Vehículo [ABC-123] Toyota Corolla | Tipo: Automóvil | Combustible: Gasolina

--- GESTIÓN DE PARQUEADERO ---
...
Seleccione una opción: 2
Placa: XYZ-987
Marca: Yamaha
Modelo: MT-09
Cilindraje: 890
Entrada registrada: Vehículo [XYZ-987] Yamaha MT-09 | Tipo: Moto | Cilindraje: 890cc

--- GESTIÓN DE PARQUEADERO ---
...
Seleccione una opción: 4
Ingrese Placa para salida: ABC-123
--- Salida ---
Vehículo: ABC-123
Tiempo total: 2 horas
Total a pagar: $100.0
```

