package tarea04;
import java.util.Arrays;
/**
 * Ejercicio 4. ¡Línea!
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio04 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array que representa las bolas que han salido hasta el momento
        int[] bolas={1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61, 66, 78, 89, 90};
        // 2.- Declaración del array bidimensional "irregular" de números enteros para representar el cartón
        int[][] carton=new int[9][];
        carton[0]=new int[4]; carton[1]=new int[2]; carton[2]=new int[2];carton[3]=new int[1];
        carton[4]=new int[2]; carton[5]=new int[3]; carton[6]=new int[1];carton[7]=new int[2];
        carton[8]=new int[2];
        carton[0][0]=1; carton[0][1]=2; carton[0][2]=5; carton[0][3]=9; carton[1][0]=11;
        carton[1][1]=15; carton[2][0]=22; carton[2][1]=29; carton[3][0]=34; carton[4][0]=47;
        carton[4][1]=49; carton[5][0]=55; carton[5][1]=59; carton[5][2]=60; carton[6][0]=61;
        carton[7][0]=71; carton[7][1]=75; carton[8][0]=88; carton[8][1]=90; 
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacenará los resultados
        String[] resultado;
        // Variables auxiliares
        int contadorFilas;
        int contadorColumnas;
        int tachado;
        int contadorBolas;
        int bola;
        int verificador;
        int contadorLineas=0;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE LÍNEAS EN UN CARTÓN DE BINGO\n----------------------------------------");
        // 4.- Mostramos por pantalla el contenido del cartón
        // 5.- Mostramos por pantalla la lista de bolas
        System.out.printf("Cartón: %s\nNúmeros que ya han salido: %s",Arrays.deepToString(carton),Arrays.toString(bolas));
        //----------------------------------------------
        //                   Procesamiento 
        //---------------------------------------------- 
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultado=new String[carton.length];
        // 7.- Recorremos cada fila del cartón
        // 7.1.- Para cada fila, recorremos todos los números que contenga
        /* 7.2.- Comprobamos si cada número ha salido o no (habrá que recorrer la lista de bolas que ya han salido)
        Si han salido todos, se marcará esa fila como "línea" en el array de resultados*/
        // 7.3.- Si no han salido todos, se marcará es fila como "no" en el array de resultados
        for (contadorFilas=0; contadorFilas < carton.length; contadorFilas++){
            verificador=0;
            for (contadorColumnas=0; contadorColumnas < carton[contadorFilas].length; contadorColumnas++){
                tachado=carton[contadorFilas][contadorColumnas];
                for (contadorBolas=0; contadorBolas < bolas.length; contadorBolas++){
                    bola=bolas[contadorBolas];
                    if (tachado == bola){
                        verificador++;
                    }
                    if (contadorColumnas == carton[contadorFilas].length-1 && contadorBolas == bolas.length-1){
                        if (verificador == carton[contadorFilas].length){
                        resultado[contadorFilas]="Línea";
                        contadorLineas++;
                        }else{
                        resultado[contadorFilas]="no";
                        }
                    }
                }
            }
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\n\nRESULTADO\n---------\nResultado de la búsqueda de líneas en el cartón de bingo:");
        // 8.- Mostramos por pantalla el array de resultados y cuántas líneas han salido
        System.out.printf("%s\nNúmero de líneas obtenidas: %d\n",Arrays.toString(resultado),contadorLineas);
    }      
}