package tarea1;
import java.util.Scanner;
/**
 * Máquina expendedora de productos.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio05 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int precio;
        int pago;
        // Variables de salida
        int r1;
        int r2;
        int moneda20;
        int moneda10;
        int moneda5;
        int moneda2;
        int moneda1;
        // Variables auxiliares
        int resto;
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /**
         * En el siguiente apartado se nos pide que se calcule el cambio (en céntimos)
         * que deberá devolvernos una maquina expendedora junto con la cantidad 
         * de monedas de cada tipo que se deben devolver y la cantidad total de monedas devueltas
         * así mismo las monedas disponibles son de 20, 10, 5, 2 y 1 centimos
         * para ello debemos, en primer lugar, hacer que el programa solicite dos numeros
         * enteros un con el precio del producto en centimos almacenado en la variable
         * precio y otro con la cantidad de dinero introducido en la maquina en centimos
         * y almacenada en la variable pago
         */
        System.out.println("MÁQUINA EXPENDEDORA DE PRODUCTOS\n--------------------------------");
        System.out.print("Precio del producto (en céntimos): ");
        precio=teclado.nextInt();
        System.out.print("Dinero introducido (en céntimos): ");
        pago=teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /**
         * Resolución.
         * Para hallar el dinero que debe devolvernos basta con restar la variable pago 
         * a la variable precio, este valor será almacenado en la variable r1
         * a continuación para poder operar con el valor de la variable r1 sin alterar esta,
         * estableceremos una variable auxiliar resto que tenga el mismo valor inicial que r1.
         * Ahora debemo averiguar cuantas monedas de cada tipo deve devolver la máquina,
         * para ello debemos empezar a cribar de la de mayor valor a la de menor valor,
         * el orden sería el siguiente: 20cts,10cts, 5cts, 2cts, 1cts Empezamos por la 
         * de 20 cts para ello comprobamos que 20 sea mayor que resto para verificar 
         * que almenos podamos usar 1, en caso negativo le damos a la cantidad de ese 
         * tipo de monedas 0 y pasariamos a intentarlo con la siguiente moneda inferior,
         * en caso afirmativo le dariamos a ese tipo de monedas el valor de la división entera
         * del resto entre el valor de la moneda y le asignariamos a la variable resto el resto
         * de dicha división, acto seguido repetiriamos proceso con la inferior...
         * Para saber el total de monedas simplemente sumamos las variaables de todos los tipos 
         * de monedas y se almacena en r2.
         */
        r1=pago-precio;
        resto=r1;
        moneda20=(resto/20>=1?resto/20:0);
        resto=resto-moneda20*20;
        moneda10=(resto/10>=1?resto/10:0);
        resto=resto-moneda10*10;
        moneda5=(resto/5>=1?resto/5:0);
        resto=resto-moneda5*5;
        moneda2=(resto/2>=1?resto/2:0);
        resto=resto-moneda2*2;
        moneda1=resto;
        r2=moneda20+moneda10+moneda5+moneda2+moneda1;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nRESULTADO\n---------");
        System.out.println("El cambio es: "+r1+"céntimos.");
        System.out.println("Monedas de 20 céntimos: "+moneda20);
        System.out.println("Monedas de 10 céntimos: "+moneda10);
        System.out.println("Monedas de 5 céntimos: "+moneda5);
        System.out.println("Monedas de 2 céntimos: "+moneda2);
        System.out.println("Monedas de 1 céntimo: "+moneda1);
        System.out.println("Total de monedas: "+r2);
    }
}
