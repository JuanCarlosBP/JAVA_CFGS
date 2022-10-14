package tarea03;
/**
 * Incluir el resto de los imports que se necesiten.
 * Necesarios para poder trabajar con los objetos de la clase LocalTime, recoger excepciones del tipio InputMismatch
 * Utilizar la clase Scanner y emplear ChonoUnit para poder establecer que ciertos resultados se expresen en minutos.
 */
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Ejercicio 3: Horario de clases.
 *
 * @author Juan Carlos Bohórquez Plato.
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Referencia a objetos de la clase Dado
        LocalTime h_Introducida, h_PrimeraHora;
        // Variables de salida
        int minDiferencia;
        String salida = "Clase correspondiente: ";
        // Variables auxiliares
        boolean errorCapturado;
        int hora = 0;
        int minutos = 0;
        // Objeto Scanner para lectura desde teclado
        //Scanner teclado = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES\n-----------------\nIntroducción del horario que desea comprobar:");
        // 1. Creación de un objeto de la clase LocalTime con la primera hors de clase (08:00)
        /**
         * En primer lugar se han declaran todas las variables, una vez hecho Instanciaremos 
         * Un objeto de la Clase LocalTime y asignaremos h_PrimeraHora como variable 
         * de referencia para que apunte a este objeto
         */
        h_PrimeraHora = LocalTime.of(8, 0);
        // 2. Lectura por teclado y comprobación de hora y minuto
        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        /**
         * A continuación vamos a instanciar un nuevo objeto de la clase LocalTime
         * Este objeto tendrá como variable de referencia que le apunte, h_Introducida,
         * así mismo para instanciar este objeto se tomarán como parametros los valores de las variables
         * hora y minutos, que serán solicitadas como entradas por teclado y que deben cumplir unos requisitos,
         * para cerciorarnos de que los cumplan se utilizarán respectivamente unas estructuras do-while en la que 
         * se solicitara la entrada por teclado de estos y se usara otra estructura a su vez try/catch para gestionar, 
         * en caso de que la haya, una excepción InputMismatch a la hora de introducir 
         * los valores de dichas variables, ademas esto se repetirá mientras no se cumpla las condiciones 
         * para los valores establecidos o exista un error, a su vez para verificar si existe 
         * un error hemos establecido una variable de tipo booleano que valdrá false en caso de no haber error
         * y true en caso de si haberlo
         */
        do {
      	    try {
       	        errorCapturado = false;
       	        System.out.print ("Introduzca hora (00-23): ");
       	        hora = teclado.nextInt();
       	    } catch (InputMismatchException e) {
       	        teclado.next();
       	        errorCapturado = true;
                System.out.println("Error de lectura: no es un número entero válido.");
       	    }
       	} while ((errorCapturado == true)||(hora<0)||(hora>23));
        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        do {
      	    try {
       	        errorCapturado = false;
       	        System.out.print ("Introduzca minuto (00-59): ");
       	        minutos = teclado.nextInt();
       	    } catch (InputMismatchException e) {
       	        teclado.next();
       	        errorCapturado = true;
                System.out.println("Error de lectura: no es un número entero válido.");
       	    }
       	} while ((errorCapturado == true)||(minutos<0)||(minutos>59));
        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        h_Introducida = LocalTime.of(hora, minutos);
        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        /**
         * Por último realizaremos una serie de operaciones y comprobaciones empleando unicamente
         * metodos de LocalTime comparando los dos objetos de la clase LocalTime creados previamente;
         * Y para filtrar en el momento de la franja horaria en que nos encontramos, emplearé unas estructuras
         * if/else if y else, así mismo en los casos en que deba contabilizar una cantidad de tiempo de diferencia
         * entre el objeto 1 y el 2, esta cantidad usará como unidad los minutos, y esto lo estableceré mediante el
         * uso de ChronoUnit.Minutes y el resultado final se mostrara por pantalla
         */
        if (h_Introducida.isBefore(h_PrimeraHora)){
            minDiferencia= (int) h_Introducida.until(h_PrimeraHora, ChronoUnit.MINUTES);
            salida= salida+"Aún no ha comenzado la jornada. Faltan "+minDiferencia+" minutos para comenzar.";
        } else {
            if (h_PrimeraHora.plusHours(2).isAfter(h_Introducida)){
                salida=salida+"Programación.";
            }else if (h_PrimeraHora.plusHours(4).isAfter(h_Introducida)){
                salida=salida+"Sistemas informáticos.";
            } else if (h_PrimeraHora.plusHours(6).isAfter(h_Introducida)){
                salida=salida+"Entornos de Desarrollo.";   
            } else {
                minDiferencia= (int) h_PrimeraHora.plusHours(6).until(h_Introducida, ChronoUnit.MINUTES);
                salida= salida+"La jornada ya ha finalizado. Han pasado "+minDiferencia+" minutos desde el fin.";
            }
        }
        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        System.out.println("Hora introducida: "+h_Introducida+"\n"+salida);
    }
}
