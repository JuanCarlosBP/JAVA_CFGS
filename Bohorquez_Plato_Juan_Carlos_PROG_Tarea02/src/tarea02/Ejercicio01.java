package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1: uso del depurador.
 *
 * Recuerda que lo único que debes modificar es la línea en la que se escribe 
 * tu nombre por pantalla.
 *
 * @author Profe
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final byte MIN_FILAS = 1;
        final byte MAX_FILAS = 10;

        // Variables de entrada
        int numFilas;

        // Variables de salida
        String cadenaResultado = "";

        // Variables auxiliares
        boolean entradaValida = false;
        byte numero = 1;

        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ESCALERA INCREMENTAL: PRUEBA DEL ALUMNO JUAN CARLOS BOHÓRQUEZ PLATO");     // Cambiar por "PRUEBA DEL ALUMNO NOMBRE APELLIDO1 APELLIDO2"
        System.out.println("------------------------------------------------------------------");
        do {
            System.out.print("Introduzca número de filas (" + 
                    MIN_FILAS + "-" + MAX_FILAS + "): ");
            numFilas = teclado.nextByte();
            if (numFilas >= MIN_FILAS && numFilas <= MAX_FILAS) {
                entradaValida = true;
            }
        } while (!entradaValida);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int fila = 1; fila <= numFilas; fila++) {
            cadenaResultado += fila + ": ";
            for (int columna = 1; columna <= fila; columna++) {
                cadenaResultado += numero + " ";
                numero++;
            }
            cadenaResultado += "\n";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println(cadenaResultado);
    }

}
