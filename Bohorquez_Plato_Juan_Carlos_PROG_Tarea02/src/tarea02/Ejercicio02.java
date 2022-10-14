package tarea02;
/**
 * Clase Scanner.
 * Java proporciona una clase denominada Scanner que nos permite leer
 * desde ficheros de texto, teclados u otros elementos.
 * "import java.util.Scanner" es la sintaxis usada para que podamos 
 * importarla y poder trabajar con ella.
 */
import java.util.Scanner;
/**
 *
 * Ejercicio 2: Análisis del año.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constante
        String diferencia2 = " años.";
        // Variables de entrada
        int anno;
        // Variables de salida
        String siglo;
        String resultadoDiferencia;
        // Variables auxiliares
        String diferencia;
        int calculoDiferencia;
        // Clase Scanner para petición de datos de entrada
        /**
         * Con la siguiente linea (Scanner teclado = new Scanner(System.in);)declaramos 
         * la variable de entrada tipo Scanner que solicitará la entrada de datos al sistema
         */
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DEL AÑO\n----------------");
        System.out.print("Introduzca un año entre (1801-2100): ");
        /**
         * Mediante la siguiente linea (anno=teclado.nextInt();) hago que la información solicitada por el programa
         * a traves del teclado se guarde en la variable anno, en este caso será un entero
         */
        anno=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * En primer lugar mediante un condicional if/else establecemos que si el dato de entrada al sistema está
         * fuera del rango el cual nesetitamos para la ejecución del programas nos informe con un mensaje de error
         * y finalice el programa, en caso de estar dentro del rango requerido mediante if/else if/else anidados a la 
         * sentencia condicional principal verifique al siglo al que pertenece verificando en el rango de años que se 
         * encuentra el año introducido y la diferencia en años con el año actual.
         * Una vez obtenido los datos se mostrarán por patalla.
         */
        if ((anno<1801) || (anno>2100)){
            System.out.println("\nRESULTADO\n---------\nEl año introducido no es válido.");
        }else {
            if (anno<=1900){
                siglo="El año pertenece al siglo XIX.";
            }else if (anno<=2000){
                siglo="El año pertenece al siglo XX.";
            }else{
                siglo="El año pertenece al siglo XXI.";
            }
            if (anno<2021){
                diferencia="El año introducido es anterior al actual. Han pasado ";
                calculoDiferencia=(2021-anno);
                resultadoDiferencia=diferencia+calculoDiferencia+diferencia2;
            }else if (anno==2021){
                diferencia="El año introducido coincide con el actual.";
                resultadoDiferencia=diferencia;
            }else {
                diferencia="El año introducido es posterior al actual. Faltan ";
                calculoDiferencia=(anno-2021);
                resultadoDiferencia=diferencia+calculoDiferencia+diferencia2;
            }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println(resultadoDiferencia);
        System.out.println(siglo);
        }
    }
}
