package tarea04;
import java.util.Arrays;
/**
 * Ejercicio 2. Reconocimiento de palíndromos.
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] entrada = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", 
            "A man, a plan, a canal: Panama", "A man a plan and a canal, Panama", "No deseo ese don..."};
        // Variables de salida
        // 2.- Declaración de un array de boolean para los resultados
        boolean[] booleano;
        // Variables auxiliares
        int contadorEntrada;
        int contadorNum=0;
        String elemento;
        String exclusion=",";
        String exclusion1=".";
        String exclusion2=";";
        String exclusion3=":";
        String exclusion4=" ";
        String sustituto="";
        StringBuilder inverso;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("RECONOCIMIENTO DE PALÍNDROMOS\n-----------------------------\nLos textos que vamos a analizar son:");
        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        booleano= new boolean[entrada.length];
        // 4.- Mostramos el array de textos por pantalla
        for (contadorEntrada=0; contadorEntrada < entrada.length; contadorEntrada++){
            contadorNum=contadorNum+1;
            System.out.printf("-Texto %d: %s\n",contadorNum, entrada[contadorEntrada]);
        }
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos de nuevo el array de textos
        // 5.1.- Para cada texto comprobamos si es palíndromo
        // Habrá que "limpiar" los textos de espacios y signos de puntuación
        // 5.2.- Si se trata de un palíndromo, se almacena el valor true en el
        // array de salida. Si no, se almacena false
        for (contadorEntrada=0; contadorEntrada < entrada.length; contadorEntrada++){
            elemento=(((((entrada[contadorEntrada].replace(exclusion, sustituto)).replace(exclusion1, sustituto)
                    ).replace(exclusion2, sustituto)).replace(exclusion3, sustituto)).replace(exclusion4, sustituto));
            inverso=new StringBuilder (elemento);
            booleano[contadorEntrada]=elemento.equalsIgnoreCase(inverso.reverse().toString());
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADOS OBTENIDOS\n--------------------");
        // 6.- Mostramos por pantalla el array de resultados
        System.out.printf("Palíndromos encontrados: %s\n", Arrays.toString(booleano));
    }
}