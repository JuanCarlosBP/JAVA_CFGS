package tarea02;
import java.util.Scanner;
/**
 * Ejercicio 4: puntuación de un texto.
 *
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio04 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String palabra;
        int multiplicador;
        // Variables de salida
        int valor = 0;
        // Variables auxiliares
        char caracter;
        int contador;
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * En primer lugar el rpograma nos solicita introducir una palabra con almenos
         * 5 caracteres y un entero que hará de multiplicador entre 1 y 3 inclusives, en 
         * caso de no cumplir los requisitos el programa volvera a solicitarlo hasta introducir
         * un dato válido, y esto lo conseguirá mediante dos bucles do-while
         */
        System.out.println("VALOR DE UN TEXTO\n------------------");
        do {
            System.out.print("Introduzca un texto con almenos 5 caracteres: ");
            palabra=teclado.nextLine();   
        } while (palabra.length()<5);
        do {
        System.out.print("Introduzca el valor del multiplicador (entre 1-3): ");
        multiplicador=teclado.nextInt();    
        } while (multiplicador!=1 & multiplicador!=2 & multiplicador!=3);
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * Una vez los datos introducidos en el sistema correctamente procedemos a 
         * analizar la palabra y darle la puntuación que le corresponde, para ello 
         * mediante una estructura repetitiva for iremos iremos obteniendo cada uno de 
         * los caracteres de la palabra introducida y mediante una estructura selectiva 
         * múltiple switch iremos asignandole el valor que le corresponda en cada caso.
         * Estas cantidades se irán sumando en el acumulador valor, y una vez concluido
         * dicho proceso el total de valor será multiplicado por el multiplicador introducido
         * y almacenado de nuevo en valor.
         * Finalmente se mostrará el resultado por pantalla.
         */
        for (contador=0; contador <palabra.length(); contador++) {
            caracter=palabra.charAt(contador);
            switch (caracter) {
                case 'a': case 'e': case 'i': case 'o': case 'u': 
                case 'A': case 'E': case 'I': case 'O': case 'U': valor=valor+1; break;
                case 'x': case 'y': case 'z': valor=valor+2; break;
                case 'X': valor=valor+5; break;
                default: valor=valor-1; break;
            }
        }
        valor=multiplicador*valor;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El valor del texto es: "+valor);
    }
}
