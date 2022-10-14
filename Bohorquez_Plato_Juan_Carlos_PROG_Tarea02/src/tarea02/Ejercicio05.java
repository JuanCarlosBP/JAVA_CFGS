package tarea02;
import java.util.Scanner;
/**
 * Ejercicio 5: construcción de cajas.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio05 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int filas;
        int columnas;
        int relleno;
        // Variables de salida
        String rectangulo="";
        String estilo ="";
        // Variables auxiliares
        int contColumnas;
        int contFilas;
        // Clase Scanner para petición de datos
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * En primer lugar el rpograma nos solicita introducir un número de filas entre 2 y 10 inclusives
         * y un número de columnas entre 2 y 10 inclusives y en caso de no cumplir los requisitos el programa 
         * volvera a solicitarlo hasta introducir un dato válido, y esto lo conseguirá mediante dos bucles do-while
         * Una vez introducido los datos validos el programa también nos solicitará introducir
         * un entero para responder a ¿caja rellena? que se almacenará en relleno
         */
        System.out.println("CONSTRUCCIÓN DE CAJAS\n---------------------");
        do {
            System.out.print("Introduzca número de filas (2-10): ");
            filas=teclado.nextInt();   
        } while (filas<2 || filas>10);
        do {
        System.out.print("Introduzca número de columnas (2-10): ");
        columnas=teclado.nextInt();    
        } while (columnas<2 || columnas>10);
        System.out.print("¿Caja rellena? (0: vacía, cualquier otro número rellena) ");
        relleno=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * Una vez introducido todos los datos en el sistema correctamente, mediante una estructura
         * repetitiva for compuesto por el contador contColumnas mientras sea menor 
         * que el valor de columnas y sirviendose de estructuras condicionales if/ else, irá implementando 
         * los saltos de linea necesarios en el acumulador rectangulo, implementar información sobre si 
         * el rectangulo que se nos solicita estará relleno o vacío ademas este, tendra anidada 
         * otra estructura repetitiva for compuesta por el contador contFilas mientras sea menor 
         * que el valor de filas, que se encargará de ir recorriendo cada uno de los espacios 
         * de la fila en la que se encuentre y agregando en el acumulador rectangulo el 
         * caracter que corresponda en cada posición, sirviendose para ello del uso de 
         * condicionales if/ else if/ else que iran discriminando que caracter es el que
         * corresponde concretamente a una posición concreta.
         * Una vez finalizado se mostrará por pantalla el resultado.
         */
        for (contColumnas=0; contColumnas < columnas; contColumnas++){
            if (contColumnas != 0){
                rectangulo=rectangulo+"\n";
            }
            if (relleno ==0){
                estilo=" vacía:";
            } else{
                estilo=" rellena:";
            }
            for(contFilas=0; contFilas < filas; contFilas++){
                if ((contColumnas==0 || contColumnas==(columnas-1))&&(contFilas==0 || contFilas==(filas-1))){
                    rectangulo=rectangulo+"+";
                } else if ((contColumnas==0 || contColumnas==(columnas-1))&&(contFilas!=0 && contFilas!=(filas-1))){
                    rectangulo=rectangulo+"-";
                } else if ((contColumnas!=0 && contColumnas!=(columnas-1))&&(contFilas==0 || contFilas==(filas-1))){
                    rectangulo=rectangulo+"|";
                } else if (relleno == 0){
                    rectangulo=rectangulo+" ";
                } else {
                    rectangulo=rectangulo+contColumnas;
                }
            }
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------\nCaja de tamaño "+filas+"x"+columnas+estilo);
        System.out.println(rectangulo);
    }
}