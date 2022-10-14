package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: método <code>toString</code>.
 * @author profe
 */
public class Pruebas07 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas07() {

    }
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables auxiliares
        ChipBici bici1, bici2, bici3;

        //----------------------------------------------
        //        7. PRUEBA DEL MÉTODO TOSTRING 
        //----------------------------------------------
        System.out.print(Utilidades.cabecera("7. PRUEBA DEL MÉTODO TOSTRING"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        
        //----------------------------------------------
        // Creación de objetos ChipBici para las pruebas 
        //----------------------------------------------

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 1 DE PRUEBA:"));
        bici1= Utilidades.constructor3Parametros (LocalDate.of(2021,9,15), 2, 1);
        System.out.print( Utilidades.consultaToString(bici1) );
        System.out.println();

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 2 DE PRUEBA:"));
        bici2 =Utilidades.constructor2Parametros (3, 2);
        System.out.print( Utilidades.consultaToString(bici2) );
        System.out.println();

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 3 DE PRUEBA:"));
        bici3= Utilidades.constructorSinParametros();
        System.out.print( Utilidades.consultaToString(bici3) );
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

        // Recorridos válidos
        Utilidades.recorrerTrayecto(bici1, 140.0);  // Trayecto de 140km
        Utilidades.recorrerTrayecto(bici2,  10.0);  // Trayecto de  10km
        Utilidades.recorrerTrayecto(bici1,  10.0);  // Trayecto de  10km
        Utilidades.recorrerTrayecto(bici1,   0.0);  // Trayecto de   0km
        System.out.print( Utilidades.consultaToString(bici1) );
        System.out.print( Utilidades.consultaToString(bici2) );
        
        //-----------------------------------------------------
        //                 Nuevos alquileres
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("DEVOLVEMOS BICI 1"));
        Utilidades.devolverBici(bici1); // Devolvemos la bici 1
        System.out.print( Utilidades.consultaToString(bici1) );

        System.out.print(Utilidades.cabecera("VOLVEMOS A ALQUILAR BICI 1"));
        Utilidades.alquilarBici(bici1); // Alquilamos la bici 1
        System.out.print( Utilidades.consultaToString(bici1) );

        //-----------------------------------------------------
        //              Nuevos recorridos de trayectos
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("VOLVEMOS A RECORRER TRAYECTOS"));
        Utilidades.recorrerTrayecto(bici1, 50.0);
        System.out.print( Utilidades.consultaToString(bici1) );

        //-----------------------------------------------------
        //               Devolución de bici
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("DEVOLVEMOS BICI 1"));
        Utilidades.devolverBici(bici1); // Devolvemos la bici 1
        System.out.print( Utilidades.consultaToString(bici1) );

        //-----------------------------------------------------
        //                  Pruebas de reset
        //-----------------------------------------------------        
        System.out.print(Utilidades.consultaEstadoObjeto(bici1)); // Estado del chip antes del reset
        System.out.print(Utilidades.cabecera("RESETEAMOS CHIPS"));
        Utilidades.reset(bici1); // Correcto
        System.out.print(Utilidades.consultaEstadoObjeto(bici1)); // Estado del chip después del reset
        System.out.print( Utilidades.consultaToString(bici1) );

    }
    
}
