package tarea03;
/**
 * Incluir el resto de los imports que se necesiten.
 * Necesarios para poder trabajar con los objetos de las clases pertinentes que voy a 
 * emplear a continuación tales como CuentaBancaria.
 */
import java.time.LocalDate;
import java.time.Month;
import libtarea3.CuentaBancaria;
/**
 * Ejercicio 1: Uso de cuentas bancarias.
 * @author Juan Carlos Bohórquez Plato.
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria
        CuentaBancaria cuentaPrivada, cuentaConjunta, cuentaFamiliar;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USANDO CUENTAS BANCARIAS\n------------------------");
        System.out.printf ("Fecha actual: %s\n", LocalDate.now(), "\n\n");
        // 2.- Instanciación de tres objetos CuentaBancaria
        System.out.println("Creación de cuentas (constructores)\n-----------------------------------");
        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)
        System.out.println("Intentando crear cuenta privada con una fecha no válida.");
        /**
         * Errores esperados.
         * A través de try/catch recogemos y manejamos los errores de los dos primeros
         * intentos fallidos de instanciación de CuentaBancaria, evitando así que la 
         * ejecución se vea interrumpida por dicho error.
         */
        try {
            cuentaPrivada=new CuentaBancaria​(30.2, LocalDate.of(2027, 9, 1));
            System.out.println("Cuenta privada creada: "+cuentaPrivada);
        }catch(IllegalArgumentException e) {
                System.out.println("Error: Parámetros de creación de la cuenta inválidos. Fecha de creación no válida: 01/09/2027");
        }
        // 2.2.- Intento de crear una cuenta con saldo no válido (hay gestionar la posible excepción)
        System.out.println("\nIntentando crear cuenta privada con un saldo no válido.");
        try {
            cuentaPrivada=new CuentaBancaria​(-200.00);
            System.out.println("Cuenta privada creada: "+cuentaPrivada);
        }catch(IllegalArgumentException e) {
                System.out.println("Error: Parámetros de creación de la cuenta inválidos. Saldo inicial: -200,00");
        }
        /**
         * A continuación instanciamos CuentaBancaria 3 veces empleando para ello 3
         * variables referencias a los objetos de CuentaBancaria previamente declaradas, así mismo
         * dado que en este caso no esperamos ningún error no usaremos try/catch,además así
         * conseguimos eliminar 3 warning por los valores null, que hubieran 
         * aparecido en el programa sobre las tres variables referencia, al no haberse instanciado
         * explicitamente antes de usarlos en lineas posteriores
         */
        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        System.out.println("\nCreando cuenta privada válida con un constructor con tres parámetros...");
            cuentaPrivada=new CuentaBancaria​(1000.00, LocalDate.of(2021, Month.JULY, 1), -200.00);
            System.out.println("Cuenta privada creada: "+cuentaPrivada);
        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros
        System.out.println("\nCreando cuenta conjunta válida usando un constructor con dos parámetros...");
            cuentaConjunta=new CuentaBancaria​(200.00, LocalDate.of(2021, Month.JULY, 1));
            System.out.println("Cuenta conjunta creada: "+cuentaConjunta);
        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros
        System.out.println("\nCreando cuenta familiar válida usando un constructor sin parámetros...");
            cuentaFamiliar=new CuentaBancaria​();
            System.out.println("Cuenta familiar creada: "+cuentaFamiliar);
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        System.out.println("\nPrueba de los getters de la cuenta privada:\n-------------------------------------------");
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        // 3.- Obtención de información de la cuenta privada
        /**
         * Realizamos una serie de comprobaciones mediante metodos de CuentaBancaria
         * sobre la variable cuentaPrivada que apunta a un espacio de memoria reservado para un objeto de CuentaBancaria
         */
        System.out.println("Id: "+cuentaPrivada.getId());
        System.out.println("Fecha de creación: "+cuentaPrivada.getFechaCreacion());
        System.out.println("Límite de descubierto: "+cuentaPrivada.getLimiteDescubierto());
        System.out.println("Está embargada: "+cuentaPrivada.isEmbargada());
        System.out.println("Está en descubierto: "+cuentaPrivada.isDescubierta());
        System.out.println("Número de días que lleva la cuenta abierta: "+cuentaPrivada.getDiasCuenta());
        // 4.- Realización de operaciones sobre las cuentas
        /**
         * Realizmaos una serie de operaciones sobre los objetos de CuentaBancaria
         * que hemos instanciado previamente mediante las variables referencias que
         * hemos establecido previamente
         */
        System.out.println("\nRealización de operaciones sobre las cuentas\n--------------------------------------------");
        System.out.println("Ingresamos 100 euros en la cuenta familiar...");
        cuentaFamiliar.ingresar(100.00);
        System.out.println("Extraemos 100 euros de la cuenta conjunta...");
        cuentaConjunta.extraer(100.00);
        System.out.println("Transferimos 1100 euros de la cuenta privada a la familiar..");
        cuentaPrivada.transferir(1100.00, cuentaFamiliar);
        // 5.- Estado final de las cuentas
        /**
         * Finalmente realizamos la comprobación del estado de las cuentas por medio 
         * de un de un método toString(); de CuentaBancaria
         */
        System.out.println("\nEstado final de las cuentas: \n---------------------------:");
        System.out.println("Estado final de la cuenta privada: "+cuentaPrivada.toString());
        System.out.println("Estado final de la cuenta conjunta: "+cuentaConjunta.toString());
        System.out.println("Estado final de la cuenta familiar: "+cuentaFamiliar.toString());
    }
}