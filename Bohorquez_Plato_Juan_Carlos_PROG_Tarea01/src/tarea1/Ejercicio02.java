package tarea1;
/**
 * Clase Scanner.
 * Java proporciona una clase denominada Scanner que nos permite leer
 * desde ficheros de texto, teclados u otros elementos.
 * "import java.util.Scanner" es la sintaxis usada para que podamos 
 * importarla y poder trabajar con ella.
 */
import java.util.Scanner;
/**
 * Cálculos aritméticos.
 * Escribe un programa en Java que solicite dos números reales y lleve a cabo los 
 * siguientes cálculos:
 *  1. el triple del primer número,
 *  2. la décima parte del segundo número,
 *  3. el cuadrado del doble del producto de ambos números,
 *  4. la mitad del cuadrado de la suma de ambos números.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        //declaramos variables de tipo float para poder albergar numeros reales
        float primero;
        float segundo;
        // Variables de salida
        float r1;
        float r2;
        float r3;
        float r4;
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        /**
         * Con la siguiente linea (Scanner teclado= new Scanner (System.in);)declaramos 
         * la variable de entrada tipo Scanner que solicitará la entrada de datos al sistema
         */
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULOS ARITMÉTICOS\n--------------------\nIntroduzca dos números reales:");
        System.out.print("Primer número: ");
        /**
         * mediante la siguiente linea (primero=teclado.nextFloat();) hago que la información solicitada por el programa
         * a traves del teclado se guarde en la variable primero, y a posteriori la segunda (segundo=teclado.nextFloat();)
         * entrada se guarde en segundo
         */
        primero=teclado.nextFloat();
        System.out.print("Segundo número: ");
        segundo=teclado.nextFloat();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Primer cálculo: triple del primer número
        /**
         * multiplicamos el valor de primero por 3
         */
        r1=primero*3;
        // Segundo cálculo: décima parte del segundo número
        /**
         * dividimos el valor de segundo entre 10
         */
        r2=segundo/10;
        // Tercer cálculo: cuadrado del doble del producto de ambos números
        /**
         * realizamos el producto de primero por el segundo por dos, dos veces y los multiplicamos entre sí
         */
        r3=((primero*segundo)*2)*((primero*segundo)*2);
        // Cuarto cálculo: mitad del cuadrado de la suma de ambos números
        /**
         * realizamos la suma del primero por el segundo dos veces, lo multiplicamos entre sí y los dividimos entre 2
         */
        r4=((primero+segundo)*(primero+segundo))/2;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\n\nRESULTADO\n---------");
        System.out.println("Triple del primer número: "+r1);
        System.out.println("Décima parte del segundo número: "+r2);
        System.out.println("Cuadrado del doble del producto de ambos número: "+r3);
        System.out.println("Mitad del cuadrado de la suma de ambos número: "+r4);
    }    
}