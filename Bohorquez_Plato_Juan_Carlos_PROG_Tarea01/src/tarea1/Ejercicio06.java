package tarea1;
/**
 * Análisis de un texto.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
import java.util.Scanner;
public class Ejercicio06 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String texto;
        // Variables de salida
        boolean a;
        boolean b;
        boolean c;
        boolean d;
        // Variables auxiliares
        int longitud;
        char mayuscula;
        char minuscula;
        String puntos;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * En este caso se nos pide que analicemos un texto que debemos introducir y verificar
         * si el texto contiene más de cinco caracteres, si el texto comienza por una letra mayúscula,
         * si el texto termina con una letra minúscula, si el texto finaliza con unos puntos suspensivos ("...")
         * para que el programa nos lo solicite usaremos la siguiente linea (texto=teclado.nextLine();)
         */
        System.out.println("ANÁLISIS DE UN TEXTO\n--------------------");
        System.out.print("Introduzca un texto: ");
        texto=teclado.nextLine();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * Mediante a=(longitud=texto.length())>5; comprovamos el la longitud del texto
         * y comparamos si es mayor de cinco o no
         * Mediante mayuscula=texto.charAt(0); obtenemos el primer caracter del texto y lo
         * almacenamos en la variable mayuscula y a continuación
         * verificamos si mayuscula es mayúscula y si además es una letra, se nos devuelve un true or false 
         * Mediante minuscula=texto.charAt(texto.length()-1); almacenamos el último caracter de 
         * texto en la variable minuscula y seguidamente
         * comprobamos si minuscula es minúscula y si minuscula es una letra,se nos devuelve un true or false 
         * Mediante puntos=texto.substring(texto.length()-3, texto.length()); obtenemos una subcadena
         * de texto con los tres últimos caracteres y lo almacenamos en la variable puntos
         * comprobamos si la variable puntos es igual a tres puntos suspensivos.
         * Y se almacena el resultado true or false en la variable d.
         */
        a=(longitud=texto.length())>5;
        mayuscula=texto.charAt(0);
        b=mayuscula==Character.toUpperCase(mayuscula)&&mayuscula>='A'&&mayuscula<='Z';
        minuscula=texto.charAt(texto.length()-1);
        c=minuscula==Character.toLowerCase(minuscula)&&minuscula>='a'&&minuscula<='z';
        puntos=texto.substring(texto.length()-3, texto.length());
        d=puntos.equals("...");
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El texto contiene más de cinco caracteres: "+a);
        System.out.println("El texto comienza con una letra mayúscula: "+b);
        System.out.println("El texto termina con una letra minúscula: "+c);
        System.out.println("El texto finaliza con unos puntos suspensivos (...): "+d);
    }    
}