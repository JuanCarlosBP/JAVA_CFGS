package domotica.dispositivos;
/**
 * Clase que representa un mecanismo de cerradura domótica. Podrá estar abierta o cerrada.
 * @author Juan Carlos Bohórquez Plato
 */
public final class Cerradura extends Dispositivo implements Activable {
    private boolean estado;
    /**
     * Constructor con tres parámetros.
     * @param descripcion descripción del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     * @param estadoInicial estado inicial del dispositivo (cerradura abierta o cerrada)
     * @throws IllegalArgumentException si el número de habitación no es válido
     */
    public Cerradura(String descripcion, int ubicacion, boolean estadoInicial) throws IllegalArgumentException {
        super(descripcion, ubicacion);
        this.estado = estadoInicial;
    }
    /**
     * Constructor con dos parámetros.
     * @param descripcion descripción del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     * @throws IllegalArgumentException si el número de habitación no es válido
     */
    public Cerradura(String descripcion, int ubicacion) throws IllegalArgumentException {
        this(descripcion, ubicacion, false);
    }
    /**
     * Obtiene el estado actual de la cerradura. 
     * El valor true significa que la cerradura está cerrada. El valor false indica que está abierta.
     * @return estado actual de la cerradura.
     */
    @Override
    public boolean getEstado() {
        return this.estado;
    }
    /**
     * Activa la cerradura (cierra)
     * @throws IllegalStateException si la cerradura ya está cerrada (activada)
     */
    @Override
    public void on() throws IllegalStateException {
        if (this.estado == true) {
            throw new IllegalStateException("Cerradura ya activada (" + (this.estado ? "cerrada" : "abierta") + ")");
        }
        this.estado = true;
    }
    /**
     * Desactiva la cerradura (abre).
     * @throws IllegalStateException si la cerradura ya está abierta (desactivada)
     */
    @Override
    public void off()throws IllegalStateException {
        if (this.estado == false) {
            throw new IllegalStateException("Cerradura ya desactivada (" + (this.estado ? "cerrada" : "abierta") + ")");
        }
        this.estado = false;
    }
    /**
     * Devuelve una cadena que representa el estado de la cerradura de forma textual.
     * @return cadena que representa el estado de la cerradura de forma textual
     */
    @Override
    public String toString() {
        return String.format("%s estado:%s",
                super.toString(),
                this.estado ? "cerrada" : "abierta");
    }
}
