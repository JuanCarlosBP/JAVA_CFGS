package pruebas;


import domotica.CasaDomotica;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;

/**
 * Programa de pruebas la clase CasaDomotica: Constructor y los getter
 */
    public class Prueba02 {

    public static void main(String[] args) {

        
        //-----------------------------------------------------------
        //  PRUEBA DE CASA DOMÓTICA: CONSTRUCTOR Y MÉTODOS GETTER
        //-----------------------------------------------------------
        System.out.println("--------------------------------------------------------");
        System.out.println("2. PRUEBA DE CASA DOMÓTICA: CONSTRUCTOR Y MÉTODOS GETTER");
        System.out.println("--------------------------------------------------------");
       
        // Instanciamos la casa domótica
        System.out.printf ("Instanciamos una casa domótica de prueba: \n");
        CasaDomotica casa= new CasaDomotica (
                "Elvis Presley",
                "Casa de un rockero",
                new Bombilla  ("b1.1", 1),
                new Cerradura ("c1.1", 1),
                new Bombilla  ("b1.2", 1),
                new Bombilla  ("c3.1", 3),
                new Bombilla  ("b3.1", 3),
                new Bombilla  ("b4.1", 4),
                new Cerradura ("c4.1", 4)
        );
        System.out.printf ("Casa domótica creada.\n");
        System.out.printf ("Número de dispositivos totales: %d\n", casa.getNumDispositivos());
        System.out.printf ("Número de bombillas: %d\n", casa.getNumBombillas());
        System.out.printf ("Número de cerraduras: %d\n", casa.getNumCerraduras());
        
        
    }
    
}