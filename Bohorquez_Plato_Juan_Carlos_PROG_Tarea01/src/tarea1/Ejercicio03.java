package tarea1;
import java.util.Scanner;
/**
 * An�lisis de un n�mero.
 * 
 * @author Juan Carlos Boborquez plato
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int entero;
        // Variables de salida
        //Estas variables de tipo booleano nos dar�n dos posibles resultados true or false
        boolean a;
        boolean b;
        boolean c;
        boolean d;
        // Variables auxiliares
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("AN�LISIS DE UN N�MERO\n---------------------");
        System.out.print("Introduzca un n�mero entero: ");
        entero=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // C�lculo de los resultados l�gicos
        /* Debo aclarar que he decidido usar distintas variables de tipo booleano
        *  para mantener el posicionamiento y estructura que se me exige en la pr�ctica, pero
        *  en mi opini�n lo correcto hubiera sido crear una sola variable de tipo booleano
        *  y haber realizado las comparativas pertinentes con dicha variable, mostrando su valor
        *  a medida que iva siendo modificado el valor de esta.
        */
        //---------------------------------------------------------------------
        //
        //---------------------------------------------------------------------
        /**
         *  Resoluci�n ejercicio 3.
         *  verificamos que el valor de la variable entero sea distinto a cero
         */
        a=(entero!=0);
        /**
         *  verificamos si el valor de entero es inferior a cero, en caso afirmativo ser�a negativo
         */
        b=(entero<0);
        /**
         *  Comoprobamos que el valor de entero sea mayor o igual que cero y menor o igual que 10
         *  utilizamos && ya que si una de las dos condciones no se cumple no tiene sentido seguir
         *  analizando la siguiente ya que el resultado ser� negativo de igual forma
         */
        c=(entero>=0&&entero<=10);
        /**
         *  Comprobamos que el valor de entero  dividido entre 3 tenga un resto 0 
         *  para saber que es divisible entre tres, as� mismo comprobamos que el valor de
         *  entero sea superior a 0 para verificar que sea positivo y verificamos tambi�n que
         *  sea inferior a 20, empleamos && ya que deben cumplirse todas las condiciones
         *  y en caso de no cumplirse alguna, no tiene sentido seguir comprobando el resto
         */
        d=((entero%3)==0&&entero>0&&entero<20);
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El n�mero es distinto de cero: "+a);
        System.out.println("El n�mero es negativo: "+b);
        System.out.println("El n�mero est� entre cero y diez (ambos incluidos): "+c);
        System.out.println("El n�mero es m�ltiplo de tres, positivo y menor que veinte: "+d);
    }    
}
