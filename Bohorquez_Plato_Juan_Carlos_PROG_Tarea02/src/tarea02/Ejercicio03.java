package tarea02;
import java.util.Scanner;
/**
 * Ejercicio 3: Valor de un naipe en el juego del tute.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int carta;
        // Variables de salida
        int valor;
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * En primer lugar el programa nos solicita que introduzcamos el numero de
         * la carta de la cual queremos analizar su valor
         */
        System.out.println("VALOR DE UN NAIPE EN EL TUTE\n----------------------------");
        System.out.print("Introduzca número (1-7, 10-12): ");
        carta=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * A posterior mediante una estructura selectiva múltiple switch, estableceremos 
         * todos los posibles valores para todas las posibles cartas, es esta manera
         * una vez introducido al programa la carta deseada, tomará el valor correspondiente.
         * A posterior se mostrará por pantalla el resultado.
         */
        switch(carta){
            case 2: case 4: case 5: case 6: case 7:valor=0; break;
            case 10:valor=2;break; case 11:valor=3;break; case 12:valor=4;break;
            case 3:valor=10;break; case 1:valor=11;break;
            default:valor=-1;break;
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El valor del naipe con ese número es: "+valor);
    }
}
