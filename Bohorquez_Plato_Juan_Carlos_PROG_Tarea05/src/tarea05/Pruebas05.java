package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: método <code>recorrerTrayecto</code>.
 * @author profe
 */
public class Pruebas05 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas05() {

    }

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        ChipBici bici1, bici2, bici3;


        //----------------------------------------------
        //  5. PRUEBA DEL MÉTODO RECORRER TRAYECTO
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("5. PRUEBA DEL MÉTODO RECORRER TRAYECTO"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------

        // Consulta inicial de los atributos de clase, antes de crear ningún objeto
        System.out.print(Utilidades.cabecera("CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
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
        
        //-----------------------------------------------------
        //       Alquileres de bicis para las pruebas 
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("ALQUILAMOS BICIS"));
        Utilidades.alquilarBici(bici1); // Alquilamos la bici 1
        Utilidades.alquilarBici(bici2); // Alquilamos la bici 2
        // La bici 3 se queda sin alquilar

        //-----------------------------------------------------
        //              Recorrido de trayectos
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("RECORREMOS TRAYECTOS"));
        Utilidades.recorrerTrayecto(bici3,  10.0); // Error: bici no alquilada
        Utilidades.recorrerTrayecto(bici1,  -2.0); // Error: distancia no válida
        Utilidades.recorrerTrayecto(bici1, 140.1); // Error: distancia no válida

        // Recorridos válidos
        Utilidades.recorrerTrayecto(bici1, 140.0);  // Trayecto de 140km
        Utilidades.recorrerTrayecto(bici2,  10.0);  // Trayecto de  10km
        Utilidades.recorrerTrayecto(bici1,  10.0);  // Trayecto de  10km
        Utilidades.recorrerTrayecto(bici1,   0.0);  // Trayecto de   0km
        
        Utilidades.recorrerTrayecto(bici1);  // Trayecto máximo (140km)
        
        //-----------------------------------------------------
        //                 Nuevos alquileres
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("DEVOLVEMOS BICI 1"));
        Utilidades.devolverBici(bici1); // Devolvemos la bici 1
        Utilidades.recorrerTrayecto(bici1);  // Error. Bici no alquilada
        System.out.print(Utilidades.cabecera("VOLVEMOS A ALQUILAR BICI 1"));
        Utilidades.alquilarBici(bici1); // Alquilamos la bici 1

        //-----------------------------------------------------
        //              Nuevos recorridos de trayectos
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("VOLVEMOS A RECORRER TRAYECTOS"));
        Utilidades.recorrerTrayecto(bici1, 50.0);

        
        //----------------------------------------------
        //   Consulta de atributos públicos de clase 
        //----------------------------------------------

        // Consulta de los atributos de clase una vez creados varios objetos
        System.out.print(Utilidades.cabecera("CONSULTA DE LOS ATRIBUTOS PRIVADOS DE CLASE:"));
        System.out.printf(Utilidades.consultaEstadoClase());
        System.out.println();


    }

    
    
    
}
