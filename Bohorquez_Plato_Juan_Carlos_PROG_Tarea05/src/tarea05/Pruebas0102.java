package tarea05;

import java.time.LocalDate;

/**
 * Programa de pruebas para la clase <code>ChipBici</code>: atributos y constructores.
 * @author profe
 */
public class Pruebas0102 {

    // Declaramos un constructor privado para que la clase no sea instanciable
    private Pruebas0102() {

    }

    public static void main(String[] args) {
        
        //------------------------------------------------------
        //  1 y 2. PRUEBA DE ATRIBUTOS PÚBLICOS Y CONSTRUCTORES 
        //------------------------------------------------------
        System.out.print(Utilidades.cabecera("1 y 2. PRUEBA DE ATRIBUTOS PÚBLICOS Y CONSTRUCTORES"));
        System.out.printf("Fecha de realización de la prueba: %s\n", LocalDate.now().format(Utilidades.FORMATO_FECHA));
        System.out.println();

        //----------------------------------------------
        //    Consulta de atributos públicos de clase 
        //----------------------------------------------
        System.out.printf(Utilidades.consultaAtributosPublicosClase());
        System.out.println();
        
        //----------------------------------------------
        //         Pruebas de los constructores
        //----------------------------------------------

        // Pruebas que deben dar error
        // ---------------------------
        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON TRES PARÁMETROS QUE DEBEN DAR ERROR:"));
        Utilidades.constructor3Parametros (null, ChipBici.DEFAULT_VERSION, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor3Parametros (LocalDate.now().plusDays(1), ChipBici.DEFAULT_VERSION, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor3Parametros (ChipBici.MIN_FECHA_ADQUISICION.minusDays(1), ChipBici.DEFAULT_VERSION, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor3Parametros (ChipBici.MIN_FECHA_ADQUISICION, ChipBici.MIN_VERSION - 1, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor3Parametros (ChipBici.MIN_FECHA_ADQUISICION, ChipBici.DEFAULT_VERSION, ChipBici.MIN_REVISION - 1);
        Utilidades.constructor3Parametros (ChipBici.MIN_FECHA_ADQUISICION, ChipBici.MAX_VERSION + 1, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor3Parametros (ChipBici.MIN_FECHA_ADQUISICION, ChipBici.DEFAULT_VERSION, ChipBici.MAX_REVISION + 1);
        System.out.println();

        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON DOS PARÁMETROS QUE DEBEN DAR ERROR"));
        Utilidades.constructor2Parametros (ChipBici.MIN_VERSION - 1, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor2Parametros (ChipBici.DEFAULT_VERSION, ChipBici.MIN_REVISION - 1);
        Utilidades.constructor2Parametros (ChipBici.MAX_VERSION + 1, ChipBici.DEFAULT_REVISION);
        Utilidades.constructor2Parametros (ChipBici.DEFAULT_VERSION, ChipBici.MAX_REVISION + 1);
        System.out.println();

        System.out.print(Utilidades.cabecera("PRUEBAS DE MÉTODO FÁBRICA CON CANTIDAD DE BICIS NO VÁLIDA"));
        Utilidades.crearArrayChipBici(0);
        System.out.println();
        

        
        // Pruebas que deben funcionar
        // ---------------------------
        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON TRES PARÁMETROS QUE DEBEN FUNCIONAR:"));
        Utilidades.constructor3Parametros (LocalDate.of(2021,9,15), 2, 1);
        System.out.println();

        System.out.print(Utilidades.cabecera("PRUEBAS DEL CONSTRUCTOR CON DOS PARÁMETROS QUE DEBEN FUNCIONAR:"));
        Utilidades.constructor2Parametros (3, 2);
        System.out.println();

        System.out.print(Utilidades.cabecera("PRUEBA DEL CONSTRUCTOR CON UN PARÁMETRO"));
        Utilidades.constructorSinParametros();
        System.out.println();
        
        System.out.print(Utilidades.cabecera("PRUEBA DEL MÉTODO \"FÁBRICA\" CREAR ARRAY CHIPBICI"));
        Utilidades.crearArrayChipBici(3);
        System.out.println();

    }

    
}
