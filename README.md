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
