package tarea04;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Ejercicio 1. Cálculo de puntuaciones.
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // 1.- Declaramos un array de objetos String (anotaciones) 
        // con el contenido que se nos pide en el enunciado
        String[] anotaciones = {"a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", "-X-X", 
            "O-X-O-X-O", "o", "O-o", "X", "o-x-o", "x", "x-x", "O-x-X", "X-X-X", "x-X-X-x"};
        Pattern expRegular=Pattern.compile("([xXoO]{1})(([-][xXoO]){0,3})");
        // Variables de salida
        StringBuilder resultado=new StringBuilder ("Puntuaciones: ");
        int sumaValida=0;
        int sumaInvalida=0;
        // Variables auxiliares
        int contador;
        int contadorchar;
        char caracter;
        int sumaresultado;
        //String elemento;
        String elemento;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULO DE PUNTUACIONES\n-----------------------");
        // 2.- Mostramos por pantalla el contenido del array de anotaciones
        System.out.printf("Anotaciones obtenidas de cada mano del juego:\n%s", Arrays.toString(anotaciones));
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 3.- Recorremos cada elemento del array
        // 3.1.- Si el elemento "encaja" con el patrón (anotación válida), se calcula su puntuación
        // Para ello habrá que descomponer la anotación en cada uno de sus elementos,
        // calcular su valor y sumarlos. 
        // 3.2.- Si no "encaja" con el patrón, la anotación será inválida y su puntuación -1
        /* 3.3.- Las puntuaciones obtenidas se "acumulan" o "concatenan" separadaa por comas */
        for (contador = 0; contador < anotaciones.length; contador++) {
            if (contador !=0){
                resultado.append(", ");
            }
            sumaresultado=0;
            elemento=anotaciones[contador];
            Matcher comprobador=expRegular.matcher(elemento);
            if (comprobador.matches()){
                sumaValida++;
                for (contadorchar = 0; contadorchar < elemento.length(); contadorchar++) {
                    caracter=elemento.charAt(contadorchar);
                    if ((caracter=='x')||(caracter=='X'))
                        sumaresultado=sumaresultado+1;
                    if (contadorchar==(elemento.length()-1)){
                        resultado.append(sumaresultado);
            }
                }
            }else{
                sumaresultado=-1;
                sumaInvalida++;
                resultado.append(sumaresultado);
            }
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\n\nRESULTADO: PUNTUACIONES CALCULADAS\n----------------------------------");
        // 4.- Mostramos por pantalla el resultado final
        // 4.1.- Lista completa de puntuaciones de cada mano
        // 4.2.- Número de anotaciones válidas
        // 4.3.- Número de anotaciones no válidas
        System.out.println(resultado);
        System.out.println("Número de anotaciones válidas: "+sumaValida+".");
        System.out.println("Número de anotaciones inválidas: "+sumaInvalida+".");
    }
}