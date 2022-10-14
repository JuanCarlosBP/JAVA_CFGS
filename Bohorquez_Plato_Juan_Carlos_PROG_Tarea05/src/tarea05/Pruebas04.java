package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: métodos <code>alquilar</code> y <code>devolver</code>.
 * @author profe
 */
public class Pruebas04 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas04() {

    }

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        ChipBici bici1, bici2, bici3;

        //----------------------------------------------
        // 4. PRUEBA DE LOS MÉTODOS ALQUILAR Y DEVOLVER
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("4. PRUEBA DE LOS MÉTODOS ALQUILAR Y DEVOLVER"));
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

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 1 DE PRUEBA:"));
        bici1= Utilidades.constructor3Parametros (LocalDate.of(2021,9,15), 2, 1);
        System.out.println();

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 2 DE PRUEBA:"));
        bici2 =Utilidades.constructor2Parametros (3, 2);
        System.out.println();

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 3 DE PRUEBA:"));
        bici3= Utilidades.constructorSinParametros();
        System.out.println();
        
        //------------------------------------------------.----
        // Alquileres y devoluciones de bicis para las pruebas 
        //-----------------------------------------------------
        
        System.out.print(Utilidades.cabecera("PRUEBAS DE AQLUILER DE BICI"));

        Utilidades.devolverBici(bici1); // Intentamos devolver la bici 1 sin ser alquilada para provocar una excepción
        Utilidades.alquilarBici(bici1); // Alquilamos la bici 1
        Utilidades.alquilarBici(bici1); // Intentamos alquilar la bici 1 una segunda vez para provocar una excepción
        
        Utilidades.alquilarBici(bici2); // Alquilamos la bici 2
        Utilidades.alquilarBici(bici3); // Alquilamos la bici 3
        
        Utilidades.devolverBici(bici1); // Devolvemos la bici 1
        Utilidades.devolverBici(bici1); // Intentamos devolver la bici 1 una segunda vez para provocar una excepción

        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------
        // Consulta de los atributos de clase una vez creados y manipulados varios objetos
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();


    }

    
    
    
}
