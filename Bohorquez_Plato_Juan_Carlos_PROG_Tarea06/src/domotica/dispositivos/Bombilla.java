package domotica.dispositivos;
/**
 * Clase Bombilla. Representa una lámpara domótica "inteligente". Permite la regulación de su intensidad.
 * @author Juan Carlos Bohórquez Plato
 */
public final class Bombilla extends Dispositivo implements Regulable, Activable {
    /**
     * Mínima intensidad posible para una bombilla: @value(MIN_INTENSIDAD).
     */
    public final int MIN_INTENSIDAD = 0;
    /**
     * Máxima intensidad posible para una bombilla: @value(MAX_INTENSIDAD).
     */
    public final int MAX_INTENSIDAD = 10;
    private int intensidad;
    private int numVecMan = 0;
    /**
     * Constructor de la clase bombilla.
     * @param descripcion nombre del dispositivo
     * @param ubicacion ubicación (número de habitación) del dispositivo
     * @throws IllegalArgumentException  si el número de habitación no es válido
     */
    public Bombilla(String descripcion, int ubicacion) throws IllegalArgumentException {
        super(descripcion, ubicacion);
        this.intensidad = 0;
    }
    /**
     * Obtiene el número de veces que la bombilla ha sido encendida, apagada, subida o bajada de intensidad.
     * @return número de veces que la bombilla ha sido encendida, apagada, subida o bajada de intensidad
     */
    public int getNumVecesManipulada() {
        return this.numVecMan;
    }
    /**
     * Obtiene la intensidad actual de la bombilla.
     * @return intensidad actual del bombilla
     */
    @Override
    public int getIntensidad() {
        return this.intensidad;
    }
    /**
     * Incrementa en un punto la intensidad lumínica de la bombilla. 
     * Si ya se ha alcanzado la intensidad máxima, se permanece en la intensidad máxima.
     * @return intensidad alcanzada tras la operación.
     */
    @Override
    public int up() {
        if (this.intensidad < this.MAX_INTENSIDAD) {
            this.intensidad++;
            this.numVecMan++;
        }
        return this.intensidad;
    }
    /**
     * Decrementa en un punto la intensidad lumínica de la bombilla. 
     * Si ya se ha alcanzado la intensidad mínima, se permanece en la intensidad mínima.
     * @return intensidad alcanzada tras la operación.
     */
    @Override
    public int down() {
        if (this.intensidad > this.MIN_INTENSIDAD) {
            this.intensidad--;
            this.numVecMan++;
        }
        return this.intensidad;
    }
    /**
     * Obtiene el estado actual de la bombilla. 
     * El valor true significa que la bombilla está encendida (en cualquier intensidad menos la mínima). 
     * El valor false que está apagada (mínima intensidad posible).
     * @return estado actual de la bombilla.
     */
    @Override
    public boolean getEstado() {
        boolean estado;
        estado = this.intensidad != 0;
        return estado;
    }
    /**
     * Enciende la bombilla. Se establece su intensidad al valor máximo.
     * @throws IllegalStateException si la bombilla ya está encendida
     */
    @Override
    public void on() throws IllegalStateException {
        if (this.intensidad != this.MIN_INTENSIDAD) {
            throw new IllegalStateException("Bombilla ya encendia");
        }
        this.intensidad = this.MAX_INTENSIDAD;
        this.numVecMan++;
    }
    /**
     * Apaga la bombilla. Se establece su intensidad al valor mínimo.
     * @throws IllegalStateException si la bombilla ya está apagada 0
     */
    @Override
    public void off() throws IllegalStateException {
        if (this.intensidad == this.MIN_INTENSIDAD) {
            throw new IllegalStateException("Bombilla ya encendia");
        }
        this.intensidad = this.MIN_INTENSIDAD;
        this.numVecMan++;
    }
    /**
     * Devuelve una cadena que representa el estado de la bombilla de forma textual.
     * @return cadena que representa el estado de la bombilla de forma textual
     */
    @Override
    public String toString() {
        return String.format("%s estado:%s int:%d NVM:%s",
                super.toString(),
                this.getEstado() ? "encendida" : "apagada",
                this.intensidad,
                this.numVecMan);
    }
}
