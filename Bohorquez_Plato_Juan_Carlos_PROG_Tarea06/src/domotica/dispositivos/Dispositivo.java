package domotica.dispositivos;
import domotica.Domotica;
/**
 * Clase abstracta que representa un dispositivo domótico genérico. 
 * Contendrá información relativa a su identificación única, una descripción y su ubicación en la vivienda.
 * @author Juan Carlos Bohórquez Plato
 */
public abstract class Dispositivo {
    private int id;
    private String descripcion;
    private int ubicacion;
    private static int totalDispositivos = 0;
    /**
     * Constructor de dispositivo domótico
     * @param descripcion  descripcion del dispositivo
     * @param ubicacion (número de habitación) del dispositivo
     * @throws IllegalArgumentException si el número de habitación no es válido
     */
    public Dispositivo(String descripcion, int ubicacion) throws IllegalArgumentException {
        if (ubicacion < Domotica.MIN_UBICACION || ubicacion > Domotica.MAX_UBICACION) {
            throw new IllegalArgumentException("Ubicación no válida: " + ubicacion);
        }
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        Dispositivo.totalDispositivos++;
        this.id = Dispositivo.totalDispositivos;
    }
    /**
     * Obtiene el id del dispositivo
     * @return id del dispositivo
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el descripcion del dispositivo
     * @return descripcion del dispositivo
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Obtiene la ubicación del dispositivo
     * @return ubicación del dispositivo
     */
    public int getUbicacion() {
        return ubicacion;
    }
    /**
     * Devuelve una cadena que representa el estado del dispositivo de forma textual.
     * @return cadena que representa el estado del dispositivo
     */
    @Override
    public String toString() {
        return String.format("tipo:%-9s id:%d descripción:\"%s\" ubicación:%d",
                this.getClass().getSimpleName(),
                this.id,
                this.descripcion,
                this.ubicacion);
    }
}
