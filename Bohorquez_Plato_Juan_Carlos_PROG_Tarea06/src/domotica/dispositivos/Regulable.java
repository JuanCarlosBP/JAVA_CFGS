package domotica.dispositivos;
/**
 * Interfaz Regulable. Las clases que implementen esta interfaz representarán objetos que permitirán regular su intensidad.
 * @author Juan Carlos Bohórquez Plato
 */
public interface Regulable {
    /**
     * Obtiene el valor regulable del elemento (intensidad).
     * @return intensidad actual
     */
    int getIntensidad();
    /**
     * Incrementa el valor regulable del elemento (intensidad).
     * @return valor alcanzado tras la operación
     */
    int up();
    /**
     * Decrementa el valor regulable del elemento (intensidad).
     * @return valor alcanzado tras la operación
     */
    int down();
}
