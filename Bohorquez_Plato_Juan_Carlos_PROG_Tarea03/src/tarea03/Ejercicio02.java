package tarea03;
/**
 * Incluir el resto de los imports que se necesiten.
 * Necesarios para poder trabajar con los objetos de la clase Dado así como metodos estáticos propios de la clase.
 */
import libtarea3.Dado;
import static libtarea3.Dado.getNumeroDadosCreados;
import static libtarea3.Dado.getNumeroLanzamientosGlobal;
import static libtarea3.Dado.getNumeroVecesCaraGlobal;
/**
 * Ejercicio 2: Lanzando los dados.
 * @author Juan Carlos Bohórquez Plato.
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Referencia a objetos de la clase Dado
        Dado dado;
        // Variables de salida
        // (no hace falta ninguna)
        // Variables auxiliares
        int contadorIntentos;
        int contadorLanzamientos;
        byte caras;
        System.out.println("LANZANDO LOS DADOS\n------------------\n");
        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 1. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES\n---------------------------------------\n");
        // 1.1. Número total de dados creados
        /**
         * Conultas iniciales.
         * Una vez declarada las variables pertinentes procedemos en primer lugar a 
         * realizar unas consultas iniciales mediante metodos estáticos de la clase 
         * Dado, para los cuales hemos hecho previamente los import pertinentes.
         */
        System.out.println("Número de total de dados creados hasta el momento: "+getNumeroDadosCreados()+".");
        // 1.2. Número total de lanzamientos
        System.out.println("Número de total de lanzamientos llevados a cabo hasta el momento: "+getNumeroLanzamientosGlobal()+".");
        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)
        System.out.println("Número de veces que se ha obtenido 1: "+getNumeroVecesCaraGlobal(1));
        System.out.println("Número de veces que se ha obtenido 2: "+getNumeroVecesCaraGlobal(2));
        System.out.println("Número de veces que se ha obtenido 3: "+getNumeroVecesCaraGlobal(3));
        System.out.println("Número de veces que se ha obtenido 4: "+getNumeroVecesCaraGlobal(4));
        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        System.out.println("\n2.- CREACIÓN Y LANZAMIENTO DE DADOS\n-----------------------------------\n");
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
        /**
         * Para la creación de dados empleamos una estructura for, que intentara instanciar
         * un objeto Dado (empleando la variable dado como variable referencia de este)
         * con un numero de caras aleatorio, teniendo en cuenta
         * que esto se consigue mediante caras = (byte)(Math.random()*(8+1));, y así mismo 
         * solo unos determinados números de cara darán como resultado la creación del objeto
         * otros darán error, estos errores serán recogidos y tratados mediante try/catch
         * y en caso de crearse correctamente el dado se lanzará tantas veces como número de caras
         * tenga, esto lo conseguimos mediante otra estructura for anidada en la primera, la cual
         * se encargará de lanzar el dado tantas veces como caras tenga el dado,y así mismo mostras
         * todos los lanzamientos mediante una consulta de historico de lanzamientos y
         * el total de la suma de los resultados obtenidos em los lanzamientos
         */
        for (contadorIntentos=1;contadorIntentos<=10;contadorIntentos++) {
            caras = (byte)(Math.random()*(8+1));
            System.out.print("Intento "+contadorIntentos+": Intentando crear dado aleatorio de "+caras+ " caras.");
            try {
                dado = new Dado(caras);
                System.out.println("Correcto. Creado dado de "+caras+" caras.");
                for (contadorLanzamientos=0;contadorLanzamientos<caras;contadorLanzamientos++) {
                    dado.lanzar();
                }
                System.out.println("Lo lanzamos"+dado.getNumeroCaras()+" veces: "+dado.getSerieHistoricaLanzamientos()
                        +"\nSuma total de los lanzamientos del dado: "+dado.getSumaPuntuacionHistorica());
            }catch(IllegalArgumentException e) {
                System.out.println("Error. Numero de caras no válido: "+caras);
            }
        }
        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println("\n3.-ANÁLISIS DE RESULTADOS FINALES\n---------------------------------\n");
        // 3.1. Número total de dados creados
        /**
         * Finalmente realizaremos las mismas consultas que realizamos al principio 
         * mediante los mismos métodos, pero esta vez deben dar resultados distintos a los previamente obtenidos
         */
        System.out.println("Número de total de dados creados hasta el momento: "+getNumeroDadosCreados()+".");
        // 3.2. Número total de lanzamientos
        System.out.println("Número de total de lanzamientos llevados a cabo hasta el momento: "+getNumeroLanzamientosGlobal()+".");
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)
        System.out.println("Número de veces que se ha obtenido 1 entre todos los lanzamientos de todos los dados: "+getNumeroVecesCaraGlobal(1));
        System.out.println("Número de veces que se ha obtenido 2 entre todos los lanzamientos de todos los dados: "+getNumeroVecesCaraGlobal(2));
        System.out.println("Número de veces que se ha obtenido 3 entre todos los lanzamientos de todos los dados: "+getNumeroVecesCaraGlobal(3));
        System.out.println("Número de veces que se ha obtenido 4 entre todos los lanzamientos de todos los dados: "+getNumeroVecesCaraGlobal(4));
    }
}
