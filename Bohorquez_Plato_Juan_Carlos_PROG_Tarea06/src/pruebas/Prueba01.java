package pruebas;

import domotica.dispositivos.Activable;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;
import domotica.dispositivos.Dispositivo;

/**
 * Programa de pruebas de las clases Dispositivo
 */

public class Prueba01 {

    public static void main(String[] args) {


        //----------------------------------------------
        //           PRUEBA DE DISPOSITIVOS
        //----------------------------------------------
        Dispositivo[] listaDispositivos;
        System.out.println("-------------------------");
        System.out.println("1. PRUEBA DE DISPOSITIVOS");
        System.out.println("-------------------------");
        System.out.println();

        // Reservamos espacio para el array de dispositivos de prueba
        listaDispositivos = new Dispositivo[6];

        // Instanciamos dispositivos
        listaDispositivos[0] = new Bombilla("b1.1", 1);
        listaDispositivos[1] = new Cerradura("c1.1", 1);
        listaDispositivos[2] = new Cerradura("c2.1", 1);
        listaDispositivos[3] = new Bombilla("b3.2", 2);
        listaDispositivos[4] = new Bombilla("b4.3", 3);
        listaDispositivos[5] = new Bombilla("b5.4", 4);

        System.out.println("Dispositivos creados");
        System.out.println("--------------------");
        Utilidades.mostrarContenidoArrayDisp(listaDispositivos);
        System.out.println();

        // Cerramos todas las cerraduras
        System.out.println("Cerramos todas las cerraduras");
        System.out.println("-----------------------------");
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof Cerradura) {
                try {
                    System.out.printf("Activando cerradura %s.", dispositivo.getId());
                    ((Cerradura) dispositivo).on();
                } catch (IllegalStateException ex) {
                    System.out.printf("Error: %s.", ex.getMessage());
                }
                System.out.println();
            }
        }
        System.out.println();

        // Incrementamos en +2 la intensidad de cada bombilla
        System.out.println("Incrementamos en +2 la intensidad de cada bombilla");
        System.out.println("--------------------------------------------------");
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof Bombilla) {
                System.out.printf("Incrementando intensidad de la bombilla %s.\n", dispositivo.getId());
                ((Bombilla) dispositivo).up();
                ((Bombilla) dispositivo).up();
            }
        }
        System.out.println();

        Utilidades.mostrarContenidoArrayDisp(listaDispositivos);

        // Intentamos activar todos los dispositivos activables
        System.out.println("Intentamos activar todos los dispositivos activables.");
        System.out.println("-----------------------------------------------------");
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof Activable) {
                try {
                    System.out.printf("Activando dispositivo %s.", dispositivo.getId());
                    ((Activable) dispositivo).on();
                } catch (IllegalStateException ex) {
                    System.out.printf("Error: %s.", ex.getMessage());
                }
                System.out.println();
            }
        }
        System.out.println();

        // Intentamos desactivar todos los dispositivos activables
        System.out.println("Intentamos desactivar todos los dispositivos activables.");
        System.out.println("--------------------------------------------------------");
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof Activable) {
                try {
                    System.out.printf("Desactivando dispositivo %s.", dispositivo.getId());
                    ((Activable) dispositivo).off();
                } catch (IllegalStateException ex) {
                    System.out.printf("Error: %s.", ex.getMessage());
                }
                System.out.println();
            }
        }
        System.out.println();

        Utilidades.mostrarContenidoArrayDisp(listaDispositivos);

    }

}
