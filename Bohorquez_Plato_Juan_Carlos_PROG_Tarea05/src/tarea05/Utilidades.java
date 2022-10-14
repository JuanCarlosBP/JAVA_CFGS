package tarea05;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utilidades para los programas de pruebas de la clase <code>ChipBici</code>.
 * @author profe
 */
public class Utilidades {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    public static final  DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
    private static final int RETARDO=1000;
    
    // Declaramos un constructor privado para que la clase no sea instanciable
    // Es una "toolbox" o "caja de herramientas"
    private Utilidades() {

    }

    public static ChipBici constructor3Parametros(LocalDate fechaAdquisicion, int version, int revision) {
        ChipBici bici = null;
        try {
            System.out.printf("Intentando crear objeto con los parámetros: %s, %d, %d.\n",
                    fechaAdquisicion!= null ? fechaAdquisicion.format(FORMATO_FECHA) : null, 
                            version, revision);
            bici = new ChipBici(fechaAdquisicion, version, revision);
            System.out.printf("Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return bici;
    }

    public static ChipBici constructor2Parametros(int version, int revision) {
        ChipBici bici = null;
        try {
            System.out.printf("Intentando crear objeto con los parámetros: %d, %d.\n",
                    version, revision);
            bici = new ChipBici(version, revision);
            System.out.printf("Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return bici;
    }

    public static ChipBici constructorSinParametros() {
        ChipBici bici = null;
        try {
            System.out.printf("Intentando crear objeto sin parámetros.\n");
            bici = new ChipBici();
            System.out.printf("Objeto creado con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return bici;
    }

    public static ChipBici[] crearArrayChipBici(int cantidad) {
        ChipBici[] arrayChipBici=null;
        try {
            System.out.printf("Intentando crear array de %d objetos.\n", cantidad);
            arrayChipBici = ChipBici.crearArrayChipBici(cantidad);
            System.out.printf("Array de Objetos creado con éxito.\n");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.printf("Error. %s.\n", ex.getMessage());
        }
        return arrayChipBici;
    }



    public static void alquilarBici(ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando alquilar bici %s", bici.getNumSerie())) );
            bici.alquilar();
            consulta.append("Bici alquilada correctamente.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(String.format("Bici alquilada: %b.\n", bici.isAlquilada()));
            consulta.append(consultaFechasBici(bici));
            consulta.append(String.format("Número de bicis alquiladas: %d\n", ChipBici.getNumBicisAlquiladas()));
        }
        try {
            Thread.sleep(RETARDO); // Para que la siguiente fecha sea al menos un segundo más tarde
        } catch (InterruptedException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }
        System.out.print(consulta);
    }

    public static void devolverBici(ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando devolver bici %s", bici.getNumSerie())));
            bici.devolver();
            consulta.append("Bici devuelta correctamente.\n");
        } catch (IllegalStateException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(String.format("Bici alquilada: %b.\n", bici.isAlquilada()) );
            consulta.append(consultaFechasBici(bici));
            consulta.append(String.format("Número de bicis alquiladas: %d\n", ChipBici.getNumBicisAlquiladas()) );
        }
        try {
            Thread.sleep(RETARDO); // Para que la siguiente fecha sea al menos un segundo más tarde
        } catch (InterruptedException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }
        System.out.print(consulta);
    }
    
    public static void recorrerTrayecto (ChipBici bici, double distancia) {
        StringBuilder consulta = new StringBuilder();
        double kilometros;
        try {
            consulta.append(cabecera(String.format("Intentando recorrer trayecto de %.2f km con la bici %s", distancia, bici.getNumSerie())));
            kilometros= bici.recorrerTrayecto(distancia);
            consulta.append(String.format ("Trayecto recorrido correctamente. El alquiler actual lleva: %.2f km.\n", kilometros));
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(consultaKilometrosBici(bici));
            consulta.append(String.format("Total de kilómetros recorridos entre todas las bicis: %.2f km.\n", ChipBici.getKilometrosTodasLasBicis()));
        }
        try {
            Thread.sleep(RETARDO); // Para que la siguiente fecha sea al menos un segundo más tarde
        } catch (InterruptedException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }
        System.out.print(consulta);        
    } 

    public static void recorrerTrayecto (ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        double kilometros;
        try {
            consulta.append(cabecera(String.format("Intentando recorrer el trayecto máximo con la bici %s", bici.getNumSerie())));
            kilometros= bici.recorrerTrayecto();
            consulta.append(String.format ("Trayecto recorrido correctamente. El alquiler actual lleva: %.2f km.\n", kilometros));
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(consultaKilometrosBici(bici));
            consulta.append(String.format("Total de kilómetros recorridos entre todas las bicis: %.2f km.\n", ChipBici.getKilometrosTodasLasBicis()));
        }
        try {
            Thread.sleep(RETARDO); // Para que la siguiente fecha sea al menos un segundo más tarde
        } catch (InterruptedException ex) {
            System.out.printf ("Error: %s\n", ex.getMessage());
        }
        System.out.print(consulta);        
    } 
    
    
/*    
    public static void recorrerTrayecto (ChipBici bici, double horas, double velocidadMedia ) {
        StringBuilder consulta = new StringBuilder();
        double kilometros;
        try {
            consulta.append(cabecera(String.format("Intentando recorrer trayecto con la bici %s durante %.2f horas a %.2f km/h", 
                    bici.getNumSerie(), horas, velocidadMedia )));
            kilometros= bici.recorrerTrayecto(horas, velocidadMedia);
            consulta.append(String.format ("Trayecto recorrido correctamente. El alquiler actual lleva: %.2f km.\n", kilometros));
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(consultaKilometrosBici(bici));
            consulta.append(String.format("Total de kilómetros recorridos entre todas las bicis: %.2f km\n", ChipBici.getKilometrosTodasLasBicis()));
        }
        System.out.print(consulta);        
    } 
  */  
    
    public static void actualizarFirmware (ChipBici bici, int version, int revision) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando actualizar firmware de la bici %s a la versión %d.%d", 
                    bici.getNumSerie(), version, revision)));
            consulta.append(String.format("Versión del firwmare antes del intento: %s\n",
                    bici.getVersionRevision()));
            bici.actualizarFirmware(version, revision);
            consulta.append("Firmware actualizado correctamente.\n");
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(String.format("Versión del firwmare tras el intento: %s\n",
                    bici.getVersionRevision()));
        }
        System.out.print(consulta);        
    } 


    public static void actualizarFirmware (ChipBici bici, int version) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando actualizar firmware de la bici %s a la versión %d", 
                    bici.getNumSerie(), version)));
            consulta.append(String.format("Versión del firwmare antes del intento: %s\n",
                    bici.getVersionRevision()));
            bici.actualizarFirmware(version);
            consulta.append("Firmware actualizado correctamente.\n");
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        } finally {
            consulta.append(String.format("Versión del firwmare tras el intento: %s\n",
                    bici.getVersionRevision()));
        }
        System.out.print(consulta);        
    } 

    
    public static void reset (ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        try {
            consulta.append(cabecera(String.format("Intentando resetear la bici %s", bici.getNumSerie())) );
            bici.reset();
            consulta.append("Reset realizado correctamente.\n");
        } catch (IllegalStateException | IllegalArgumentException ex) {
            consulta.append(String.format("Error. %s\n", ex.getMessage()) );
        }
        System.out.print(consulta);        
    } 

    
    public static String consultaAtributosPublicosClase() {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera("CONSULTA DE ATRIBUTOS PÚBLICOS DE CLASE CHIPBICI"));
        consulta.append(String.format("MINIMA_FECHA_ADQUISICION: %s\n", ChipBici.MIN_FECHA_ADQUISICION.format(FORMATO_FECHA)));
        consulta.append(String.format("MAX_DISTANCIA_TRAYECTO: %5.2f\n", ChipBici.MAX_DISTANCIA_TRAYECTO));
        consulta.append(String.format("MINIMA_VERSION:   %2d\n", ChipBici.MIN_VERSION));
        consulta.append(String.format("MAXIMA_VERSION:   %2d\n", ChipBici.MAX_VERSION));
        consulta.append(String.format("DEFAULT_VERSION:  %2d\n", ChipBici.DEFAULT_VERSION));
        consulta.append(String.format("MINIMA_REVISION:  %2d\n", ChipBici.MIN_REVISION));
        consulta.append(String.format("MAXIMA_REVISION:  %2d\n", ChipBici.MAX_REVISION));
        consulta.append(String.format("DEFAULT_REVISION: %2d\n", ChipBici.DEFAULT_REVISION));
        return consulta.toString();
    }

    public static String consultaEstadoClase() {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera("CONSULTA DE INFORMACIÓN DE CLASE CHIPBICI"));
        consulta.append(String.format("Número total de bicis: %s\n", ChipBici.getNumBicis()));
        consulta.append(String.format("Número de bicis alquiladas: %d\n", ChipBici.getNumBicisAlquiladas()));
        consulta.append(String.format("Total de kilómetros recorridos entre todas las bicis: %.2f km\n", ChipBici.getKilometrosTodasLasBicis()));
        return consulta.toString();
    }
    
    public static String consultaEstadoObjeto(ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(cabecera("CONSULTA DE INFORMACIÓN DE OBJETO CHIPBICI")));
        consulta.append(String.format("Número de serie: %s.\n", bici.getNumSerie()));
        consulta.append(String.format("Fecha de adquisición: %s.\n",
                bici.getFechaAdquisicion() != null ? bici.getFechaAdquisicion().format(FORMATO_FECHA) : null));
        consulta.append(String.format("Está alquilada: %s.\n", bici.isAlquilada() ? "sí" : "no"));
        consulta.append(String.format("Versión: %d.\n", bici.getVersion()));
        consulta.append(String.format("Revisión: %d.\n", bici.getRevision()));
        consulta.append(String.format("Versión y revisión: %s.\n", bici.getVersionRevision()));
        consulta.append(String.format("Registro del inicio del alquiler actual: %s.\n",
                bici.getRegistroInicioAlquilerActual() != null ? bici.getRegistroInicioAlquilerActual().format(FORMATO_FECHA_HORA) : null));
        consulta.append(String.format("Kilómetros recorridos en el alquiler actual: %.2f km.\n", bici.getKilometrosRecorridosAlquilerActual()));
        consulta.append(String.format("Kilómetros totales recorridos por la bici: %.2f km.\n", bici.getKilometrosTotales()));
        consulta.append(String.format("Registro del inicio del último alquiler: %s.\n",
                bici.getRegistroInicioUltimoAlquiler() != null ? bici.getRegistroInicioUltimoAlquiler().format(FORMATO_FECHA_HORA) : null));
        consulta.append(String.format("Registro del fin del último alquiler: %s.\n",
                bici.getRegistroFinUltimoAlquiler() != null ? bici.getRegistroFinUltimoAlquiler().format(FORMATO_FECHA_HORA) : null));
        return consulta.toString();
    }
    
    public static String consultaFechasBici(ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format("Registro del inicio del alquiler actual: %s.\n",
                bici.getRegistroInicioAlquilerActual() != null ? bici.getRegistroInicioAlquilerActual().format(FORMATO_FECHA_HORA) : null));
        consulta.append(String.format("Registro del inicio del último alquiler: %s.\n",
                bici.getRegistroInicioUltimoAlquiler() != null ? bici.getRegistroInicioUltimoAlquiler().format(FORMATO_FECHA_HORA) : null));
        consulta.append(String.format("Registro del fin del último alquiler: %s.\n",
                bici.getRegistroFinUltimoAlquiler() != null ? bici.getRegistroFinUltimoAlquiler().format(FORMATO_FECHA_HORA) : null));
        return consulta.toString();
    }

    
    public static String consultaKilometrosBici(ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format("Kilómetros recorridos en el alquiler actual: %.2f km.\n", bici.getKilometrosRecorridosAlquilerActual()));
        consulta.append(String.format("Kilómetros totales recorridos por la bici: %.2f km.\n", bici.getKilometrosTotales()));
        return consulta.toString();
    }
    
    
    public static String consultaToString (ChipBici bici) {
        StringBuilder consulta = new StringBuilder();
        consulta.append(cabecera(String.format("MÉTODO TO STRING DE OBJETO CHIPBICI %s", bici.getNumSerie())));
        consulta.append(String.format("Resultado del toString de la bici %s:\n", bici.getNumSerie()));
        consulta.append(String.format("%s\n", bici.toString()));
        return consulta.toString();        
    }
    
    

    public static String cabecera(String texto) {
        StringBuilder cabecera = new StringBuilder();
        String lineas = "-".repeat(texto.length());
        cabecera.append(lineas).append("\n").append(texto).append("\n").append(lineas).append("\n");

        return cabecera.toString();
    }

}
