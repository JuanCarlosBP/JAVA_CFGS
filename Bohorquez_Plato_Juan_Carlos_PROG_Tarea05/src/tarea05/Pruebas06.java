package tarea05;


import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: métodos <code>actualizarFirmware</code> y <code>reset</code>.
 * @author profe
 */
public class Pruebas06 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas06() {

    }
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables auxiliares
        ChipBici bici1, bici2;
        

        //-------------------------------------------------------
        //  6. PRUEBA DE LOS MÉTODOS ACTUALIZAR FIRMWARE Y RESET
        //-------------------------------------------------------
        System.out.print(Utilidades.cabecera("6. PRUEBA DE LOS MÉTODOS ACTUALIZAR FIRMWARE Y RESET"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        // Creación de objetos ChipBici para las pruebas 
        //----------------------------------------------

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 1 DE PRUEBA:"));
        bici1= Utilidades.constructor2Parametros(3,1);
        System.out.println();

        // Creamos objeto 
        System.out.print(Utilidades.cabecera("CREACIÓN DE BICI 2 DE PRUEBA:"));
        bici2 =Utilidades.constructor2Parametros(2,3);
        System.out.println();

        
        //-----------------------------------------------------
        //       Alquileres de bicis para las pruebas 
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("ALQUILAMOS BICIS"));
        Utilidades.alquilarBici(bici1); // Alquilamos la bici 1

        //-----------------------------------------------------
        //       Pruebas de actualización de firmware
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("ACTUALIZAMOS FIRMWARE"));
        
        Utilidades.actualizarFirmware(bici1, 2, 2); // Error: bici alquilada
        
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.MIN_VERSION - 1, ChipBici.DEFAULT_REVISION); // Error: versión no válida
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.MAX_VERSION + 1, ChipBici.DEFAULT_REVISION); // Error: versión no válida
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.DEFAULT_VERSION, ChipBici.MIN_REVISION - 1); // Error: revisión no válida
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.DEFAULT_VERSION, ChipBici.MAX_REVISION + 1); // Error: revisión no válida
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion()-1, 0); // Error: versión anterior a la actual
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion(),
                bici2.getRevision()-1); // Error: versión anterior a la actual
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion(),
                bici2.getRevision()); // Error: versión igual a la actual
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion(),
                bici2.getRevision()+1); // Correcto
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion()+1, 0); // Correcto

        
        // Pruebas con el método de un solo parámetro
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.MIN_VERSION - 1); // Error: versión no válida
        Utilidades.actualizarFirmware(bici2,  
                ChipBici.MAX_VERSION + 1); // Error: versión no válida
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion()-1); // Error: versión anterior a la actual
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion()); // Error: versión igual a la actual
        Utilidades.actualizarFirmware(bici2,  
                bici2.getVersion()+1); // Correcto: versión posterior a la actual
        

        //-----------------------------------------------------
        //              Recorremos trayecto
        //-----------------------------------------------------        
        Utilidades.recorrerTrayecto(bici1, 140.0);

        //-----------------------------------------------------
        //        Pruebas de reset con bici alquilada
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("RESETEAMOS CHIPS"));
        Utilidades.reset(bici1); // Error: bici alquilada

        //-----------------------------------------------------
        //                Devolución de bici 
        //-----------------------------------------------------        
        System.out.print(Utilidades.cabecera("DEVOLVEMOS BICIS"));
        Utilidades.devolverBici(bici1); // Devolvemos la bici 1

        //-----------------------------------------------------
        //                  Pruebas de reset
        //-----------------------------------------------------        
        System.out.print(Utilidades.consultaEstadoObjeto(bici1)); // Estado del chip antes del reset
        System.out.print(Utilidades.cabecera("RESETEAMOS CHIPS"));
        Utilidades.reset(bici1); // Correcto
        System.out.print(Utilidades.consultaEstadoObjeto(bici1)); // Estado del chip después del reset

    }

    
    
    
}
