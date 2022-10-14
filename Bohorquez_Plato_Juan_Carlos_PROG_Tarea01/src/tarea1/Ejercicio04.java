package tarea1;
/**
 * Trayecto en dos etapas.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
import java.util.Scanner;
public class Ejercicio04 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        float litros;
        // Variables de salida
        float a;
        float b;
        float c;
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * Para la resolución de este problema, primero debemos hacer que el programa
         * solicite la cantidad de litros que tendrá el vehiculo que realiza el trayecto
         * y para ello debe solicitar un numero real
         */
        System.out.println("TRAYECTO EN DOS ETAPAS\n----------------------");
        System.out.print("Introduzca la cantidad inicial de litros que se introducen en el depósito del vehículo: ");
        litros=teclado.nextFloat();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución de los problemas.
         * En primer lugar debemos esteblacer cuanto se gasta en la primera parte del
         * trayecto, ya que es la mitad del combustible, haremos que la cantidad de litros
         * que tiene el vehiculo inicialmente almacenada en la variable litros sea dividido
         * entre dos y almacenado en la variable a
         * el siguiente apartado nos dice que se gasta un 25% del combustible restante
         * o lo que es lo mismo la variable a que ya de por si es un 50% de la cantidad inicial
         * dividido entre cuatro, y este valor lo almacenaremos en la variable b
         * y por último debemos saber cuanto combustible queda, para ello debemos hallar
         * el 75% del 50% inicial o lo que es lo mismo a a le restamos b y nos queda ese resultado
         * que será almacenado en la variable c
         */
        a=litros/2;
        b=a/4;
        c=a-b;
        //----------------------------------------------    
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("Litros consumidos en el primer recorrido: "+a);
        System.out.println("Litros consumidos en el segundo recorrido: "+b);
        System.out.println("Litros sobrantes en el depósito: "+c);
    }    
}
