/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import domotica.dispositivos.Dispositivo;

/**
 *
 * @author profe
 */
public final class Utilidades {

    private Utilidades () {
        
    }
    

    public static void mostrarContenidoArrayDisp (Dispositivo[] listaDispositivos) {
            for (int i = 0; i < listaDispositivos.length; i++) {
            Dispositivo disp = listaDispositivos[i];
            System.out.printf("Dispositivo %d: %s\n", i, disp);
        }
        System.out.println();
    }

    
    
}
