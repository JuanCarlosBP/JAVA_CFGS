package tarea1;
/**
 * Provincias de Andalucía.
 * 
 * @author Juan Carlos Bohórquez Plato
 */
public class Ejercicio01 {   
    // Definición del enum
    /**
     * seguimos la siguiente estructura para declarar un nuevo tipo enum:
     * public enum Nombre {elemento1, elemento2, ...};
     */
    public enum Provincias {ALMERIA, CADIZ, CORDOBA, GRANADA, HUELVA, JAEN, MALAGA, SEVILLA};
    // Programa principal
    public static void main(String[] args) { 
    /**
     * A continuación debemos declararar las nuevas variales del nuevo tipo(enum)
     * que hemos creado, para poder usarlas a posteriori siguiendo la estructura 
     * que muestro a continuación: 
     * (Nombre del enum) (nombre variable que queramos asignar)=(Nombre del enum).(valor del enum);
     */
        Provincias uno=Provincias.ALMERIA;
        Provincias dos=Provincias.CADIZ;
        Provincias tres=Provincias.CORDOBA;
        Provincias cuatro=Provincias.GRANADA;
        Provincias cinco=Provincias.HUELVA;
        Provincias seis=Provincias.JAEN;
        Provincias siete=Provincias.MALAGA;
        Provincias ocho=Provincias.SEVILLA;    
        System.out.println("PROVINCIAS DE ANDALUCÍA");
        System.out.println("-----------------------");
        // Vamos mostrando cada uno de los posibles valores del enum
        // (no hace falta estructurar el programa en entrada/procesamiento/salida)
        System.out.println("Provincia 1: "+uno+"\nProvincia 2: "+dos+"\nProvincia 3: "+tres+"\nProvincia 4: "+
            cuatro+"\nProvincia 5: "+cinco+"\nProvincia 6: "+seis+"\nProvincia 7: "+siete+"\nProvincia 8: "+ocho);
    }
}
