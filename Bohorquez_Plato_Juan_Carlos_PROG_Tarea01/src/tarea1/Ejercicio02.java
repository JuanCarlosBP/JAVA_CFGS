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
 * C�lculos aritm�ticos.
 * Escribe un programa en Java que solicite dos n�meros reales y lleve a cabo los 
 * siguientes c�lculos:
 *  1. el triple del primer n�mero,
 *  2. la d�cima parte del segundo n�mero,
 *  3. el cuadrado del doble del producto de ambos n�meros,
 *  4. la mitad del cuadrado de la suma de ambos n�meros.
 * 
 * @author Juan Carlos Boh�rquez Plato
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaraci�n de variables 
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
        // Clase Scanner para petici�n de datos de entrada
        /**
         * Con la siguiente linea (Scanner teclado= new Scanner (System.in);)declaramos 
         * la variable de entrada tipo Scanner que solicitar� la entrada de datos al sistema
         */
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("C�LCULOS ARITM�TICOS\n--------------------\nIntroduzca dos n�meros reales:");
        System.out.print("Primer n�mero: ");
        /**
         * mediante la siguiente linea (primero=teclado.nextFloat();) hago que la informaci�n solicitada por el programa
         * a traves del teclado se guarde en la variable primero, y a posteriori la segunda (segundo=teclado.nextFloat();)
         * entrada se guarde en segundo
         */
        primero=teclado.nextFloat();
        System.out.print("Segundo n�mero: ");
        segundo=teclado.nextFloat();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Primer c�lculo: triple del primer n�mero
        /**
         * multiplicamos el valor de primero por 3
         */
        r1=primero*3;
        // Segundo c�lculo: d�cima parte del segundo n�mero
        /**
         * dividimos el valor de segundo entre 10
         */
        r2=segundo/10;
        // Tercer c�lculo: cuadrado del doble del producto de ambos n�meros
        /**
         * realizamos el producto de primero por el segundo por dos, dos veces y los multiplicamos entre s�
         */
        r3=((primero*segundo)*2)*((primero*segundo)*2);
        // Cuarto c�lculo: mitad del cuadrado de la suma de ambos n�meros
        /**
         * realizamos la suma del primero por el segundo dos veces, lo multiplicamos entre s� y los dividimos entre 2
         */
        r4=((primero+segundo)*(primero+segundo))/2;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\n\nRESULTADO\n---------");
        System.out.println("Triple del primer n�mero: "+r1);
        System.out.println("D�cima parte del segundo n�mero: "+r2);
        System.out.println("Cuadrado del doble del producto de ambos n�mero: "+r3);
        System.out.println("Mitad del cuadrado de la suma de ambos n�mero: "+r4);
    }    
}