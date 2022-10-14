package domotica.dispositivos;
/**
 * Interfaz Activable. 
 * Las clases que implementen esta interfaz representarán objetos que podrán activarse y desactivarse.
 * @author Juan Carlos Bohórquez Plato
 */
public interface Activable {
    /**
     * Obtiene el estado del elemento. Si está activado será true. Si no lo está será false.
     * @return estado actuall elemento
     */
    boolean getEstado();
    /**
     * Activa el elemento.
     * @throws IllegalStateException si el elemento ya estaba activado
     */
    public void on()throws IllegalStateException;
    /**
     * Desactiva el elemento.
     * @throws IllegalStateException si el elemento ya estaba desactivado
     */
    public void off()throws IllegalStateException;
}
