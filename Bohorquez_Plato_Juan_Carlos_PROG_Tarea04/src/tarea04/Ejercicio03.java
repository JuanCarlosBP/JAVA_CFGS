package tarea04;
import java.util.regex.Pattern;
/**
 * Ejercicio 3. Inversión de palabras.
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] entrada = {"Reconocer", "AMANECER", "Esto no es un palindromo", "Dabale arroz a la zorra el abad.", 
            "A man, a plan, a canal: Panama", "A man a plan and a canal, Panama", "No deseo ese don..."};
        Pattern expRegular=Pattern.compile("[^a-zA-Z]");
        // Variables de salida
        // 2.- Declaración de un array de String para los resultados
        String[] salida;
        // Variables auxiliares
        int contadorEntrada;
        int contadorNum=0;
        String elemento;
        int contadorPalabras;
        StringBuilder palabras;
        String[] split;
        String inverso;
        String cadena;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("INVERSIÓN DE PALABRAS\n---------------------\nLos textos que vamos a analizar son:");
        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        salida = new String[entrada.length];
        // 4.- Mostramos el contenido del array de textos por pantalla
        // colocando cada texto en una línea diferente
        for (contadorEntrada=0; contadorEntrada < entrada.length; contadorEntrada++){
            contadorNum=contadorNum+1;
            System.out.printf("-Texto %d: %s\n",contadorNum, entrada[contadorEntrada]);
        }
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos el array de textos.
        // Para cada texto:
        //   5.1.- obtenemos cada palabra del texto;
        //   5.2.- invertimos cada palaba del texto;
        //   5.3.- almacenamos cada palabra invertida separadas por espacios en una misma cadena.
        //         Esa cadena de palabras invertidas se almacenará en el array de resultados
        for (contadorEntrada=0; contadorEntrada < entrada.length; contadorEntrada++){
            cadena="";
            elemento=entrada[contadorEntrada];
            split=elemento.split(expRegular.toString());
            for (contadorPalabras=0; contadorPalabras < split.length; contadorPalabras++){
                palabras=new StringBuilder(split[contadorPalabras]);
                inverso=palabras.reverse().toString();
                if (!" ".equals(inverso)){
                    cadena=cadena+inverso;
                    if (contadorPalabras < split.length-1){
                        cadena=cadena+" ";
                    }
                }
            }
            salida[contadorEntrada]=cadena;
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        // 6.- Mostdramos los resultado por pantalla.
        // Recorremos el array de textos y para cada texto:
        //   6.1. Mostramos el texto original 
        //   6.2. Mostramos el texto con las palabras invertidas 
        contadorNum=0;
        for (contadorEntrada=0; contadorEntrada < entrada.length; contadorEntrada++){
            contadorNum=contadorNum+1;
            System.out.printf("Texto %d: \"%s\"\nPalabras invertidas: \"%s\"\n\n",contadorNum, entrada[contadorEntrada],salida[contadorEntrada]);
        }
    }  
}