package tarea1;
import java.util.Scanner;
/**
 * Análisis de un número.
 * 
 * @author Juan Carlos Boborquez plato
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int entero;
        // Variables de salida
        //Estas variables de tipo booleano nos darán dos posibles resultados true or false
        boolean a;
        boolean b;
        boolean c;
        boolean d;
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE UN NÚMERO\n---------------------");
        System.out.print("Introduzca un número entero: ");
        entero=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Cálculo de los resultados lógicos
        /* Debo aclarar que he decidido usar distintas variables de tipo booleano
        *  para mantener el posicionamiento y estructura que se me exige en la práctica, pero
        *  en mi opinión lo correcto hubiera sido crear una sola variable de tipo booleano
        *  y haber realizado las comparativas pertinentes con dicha variable, mostrando su valor
        *  a medida que iva siendo modificado el valor de esta.
        */
        //---------------------------------------------------------------------
        //
        //---------------------------------------------------------------------
        /**
         *  Resolución ejercicio 3.
         *  verificamos que el valor de la variable entero sea distinto a cero
         */
        a=(entero!=0);
        /**
         *  verificamos si el valor de entero es inferior a cero, en caso afirmativo sería negativo
         */
        b=(entero<0);
        /**
         *  Comoprobamos que el valor de entero sea mayor o igual que cero y menor o igual que 10
         *  utilizamos && ya que si una de las dos condciones no se cumple no tiene sentido seguir
         *  analizando la siguiente ya que el resultado será negativo de igual forma
         */
        c=(entero>=0&&entero<=10);
        /**
         *  Comprobamos que el valor de entero  dividido entre 3 tenga un resto 0 
         *  para saber que es divisible entre tres, así mismo comprobamos que el valor de
         *  entero sea superior a 0 para verificar que sea positivo y verificamos también que
         *  sea inferior a 20, empleamos && ya que deben cumplirse todas las condiciones
         *  y en caso de no cumplirse alguna, no tiene sentido seguir comprobando el resto
         */
        d=((entero%3)==0&&entero>0&&entero<20);
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El número es distinto de cero: "+a);
        System.out.println("El número es negativo: "+b);
        System.out.println("El número está entre cero y diez (ambos incluidos): "+c);
        System.out.println("El número es múltiplo de tres, positivo y menor que veinte: "+d);
    }    
}
