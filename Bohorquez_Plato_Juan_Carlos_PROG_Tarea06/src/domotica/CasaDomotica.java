package domotica;
import domotica.dispositivos.Activable;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;
import domotica.dispositivos.Dispositivo;
/**
 * Clase que representa una vivienda domótica con un conjunto de dispositivos domóticos de distintos tipos.
 * @author Juan Carlos Bohórquez Plato
 */
public class CasaDomotica {
    private final Dispositivo[] elemento;
    private final String propietario;
    private final String descripcion;
    /**
     * Constructor para una vivenda domótica.
     * @param propietario propietario de la vivienda
     * @param descripcion descripción de la vivienda
     * @param dispositivos lista variable de dispositivos domóticos integrados en la vivienda
     */
    public CasaDomotica(String propietario, String descripcion, Dispositivo... dispositivos) {
        elemento = new Dispositivo[dispositivos.length];
        System.arraycopy(dispositivos, 0, elemento, 0, dispositivos.length);
        this.propietario = propietario;
        this.descripcion = descripcion;
    }
    /**
     * Obtiene el número de dispositivos integrados en la vivienda.
     * @return número de dispositivos integrados en la vivienda
     */
    public int getNumDispositivos() {
        return elemento.length;
    }
    /**
     * Obtiene el número de dispositivos de tipo Bombilla integrados en la vivienda.
     * @return número de bombiilas instaladas en la vivienda
     */
    public int getNumBombillas() {
        int bombillas = 0;
        for (Dispositivo i : elemento) {
            if (i instanceof Bombilla) {
                bombillas++;
            }
        }
        return bombillas;
    }
    /**
     * Obtiene el número de dispositivos de tipo Cerradura integrados en la vivienda.
     * @return número de cerraduras instaladas en la vivienda
     */
    public int getNumCerraduras() {
        int cerraduras = 0;
        for (Dispositivo i : elemento) {
            if (i instanceof Cerradura) {
                cerraduras++;
            }
        }
        return cerraduras;
    }
    /**
     * Cierra todas las cerraduras de la casa que estén aún sin cerrar.
     * @return el número de cerraduras que se han activado (cerrado)
     */
    public int cerrarCerraduras() {
        int cerradas = 0;
        for (Dispositivo i : elemento) {
            if (i instanceof Cerradura) {
                try {
                    ((Cerradura) i).on();
                    cerradas++;
                } catch (IllegalStateException e) {
                }
            }
        }
        return cerradas;
    }
    /**
     * Activa todos los dispositivos de la casa que estén aún sin activar.
     * @return el número de dispositivos que se han activado
     */
    public int activarDispositivosActivables() {
        int activadas = 0;
        for (Dispositivo i : elemento) {
            if (i instanceof Activable) {
                try {
                    ((Activable) i).on();
                    activadas++;
                } catch (IllegalStateException e) {
                }
            }
        }
        return activadas;
    }
    /**
     * Obtiene una cadena de texto con toda la información de un objeto CasaDomotica
     * @return cadena de texto con toda la información de un objeto CasaDomotica
     */
    @Override
    public String toString() {
        int[] dispXEstancias = {3, 0, 2, 2, 0};
        int contadorElementos = 0;
        int filas = 4;
        int columnas = 100;
        int longitud = 0;
        String salida = "";
        for (int estancia = 0; estancia <= dispXEstancias.length; estancia++) {
            if (estancia == 0) {
                for (int fila = 0; fila <= filas; fila++) {
                    if (fila != 0) {
                        salida = salida + "\n";
                    }
                    for (int columna = 0; columna < columnas; columna++) {
                        if ((fila == 0 || fila == filas) && (columna == 0 || columna == columnas - 1)) {
                            salida = salida + "+";
                        } else if (fila == 0 || fila == filas) {
                            salida = salida + "-";
                        } else if (columna == 0 || columna == columnas - 1) {
                            salida = salida + "|";
                        } else if (columna == 1 && fila == 1) {
                            salida = salida + "CASA DOMOTICA";
                        } else if (columna > 13 && fila == 1) {
                            salida = salida + " ";
                        } else if (columna == 1 && fila == 2) {
                            salida = salida + "Propietario: " + this.propietario;
                        } else if (columna > 13 + (this.propietario.length()) && fila == 2) {
                            salida = salida + " ";
                        } else if (columna == 1 && fila == 3) {
                            salida = salida + "Descripción: " + this.descripcion;
                        } else if (columna > 13 + this.descripcion.length() && fila == 3) {
                            salida = salida + " ";
                        }
                    }
                }
            } else {
                filas = dispXEstancias[estancia - 1] + 3;
                for (int fila = 0; fila < filas; fila++) {
                    salida = salida + "\n";
                    for (int columna = 0; columna < columnas; columna++) {
                        if ((fila == filas - 1) && (columna == 0 || columna == columnas - 1)) {
                            salida = salida + "+";
                        } else if (fila == filas - 1) {
                            salida = salida + "-";
                        } else if (columna == 0 || columna == columnas - 1) {
                            salida = salida + "|";
                        } else if (columna == 1 && fila == 0) {
                            salida = salida + "Estancia: " + estancia;
                        } else if (columna > 11 && fila == 0) {
                            salida = salida + " ";
                        } else if (fila == 1) {
                            salida = salida + " ";
                        } else if (columna == 1) {
                            salida = salida + this.elemento[contadorElementos].toString();
                            longitud = this.elemento[contadorElementos].toString().length();
                            contadorElementos++;
                        } else if (columna > longitud && fila != 0) {
                            salida = salida + " ";
                        }
                        if (estancia == dispXEstancias.length && fila == filas) {
                            contadorElementos = 0;
                        }
                    }
                }
            }
        }
        return String.format("%s\n", salida);
    }
}
