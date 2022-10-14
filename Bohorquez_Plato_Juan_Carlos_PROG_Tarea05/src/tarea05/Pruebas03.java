package tarea05;

/**
 * Programa prueba para la clase ChipBici
 */
import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: métodos <code>getter</code>.
 * @author profe
 */
public class Pruebas03 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas03() {

    }

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        ChipBici bici1, bici2, bici3;
        ChipBici[] arrayBicis;

        //----------------------------------------------
        //  3. PRUEBA DE ATRIBUTOS PRIVADOS Y GETTERS
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("3. PRUEBA DE ATRIBUTOS PRIVADOS Y GETTERS"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------
        // Consulta inicial de los atributos de clase, antes de crear ningún objeto
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
        
        //----------------------------------------------
        // Creación de objetos ChipBici para las pruebas 
        //----------------------------------------------

        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 1 DE PRUEBA:"));
        bici1= Utilidades.constructor3Parametros (LocalDate.of(2021,9,15), 2, 1);
        System.out.print(Utilidades.consultaEstadoObjeto(bici1));
        System.out.println();

        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 2 DE PRUEBA:"));
        bici2 =Utilidades.constructor2Parametros (3, 2);
        System.out.print(Utilidades.consultaEstadoObjeto(bici2));
        System.out.println();

        // Creamos objeto y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 3 DE PRUEBA:"));
        bici3= Utilidades.constructorSinParametros();
        System.out.print(Utilidades.consultaEstadoObjeto(bici3));
        System.out.println();
        
        // Creamos array de objetos y mostramos sus atributos mediante getters
        System.out.print(Utilidades.cabecera("CREACIÓN DE ARRAY DE 3 BICIS"));
        arrayBicis= Utilidades.crearArrayChipBici(3);
        for (ChipBici bici: arrayBicis) {
            System.out.print(Utilidades.consultaEstadoObjeto(bici));
        }
        System.out.println();
        
        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------
        // Consulta de los atributos de clase una vez creados varios objetos
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();
    }
    
}
