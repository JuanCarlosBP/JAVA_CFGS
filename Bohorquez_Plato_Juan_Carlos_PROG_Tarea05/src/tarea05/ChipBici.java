package tarea05;
//Se agregan los import necesarios para poder trabajar con las clases de tiempo requeridas.
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 * Clase que representa un <b>microdispositivo de bicicleta</b> que se acopla
 * a las bicis de alquiler de un establecmiento deportes de ocio y aventura.
 * <p>Los objetos de esta clase permiten almacenar y gestionar información sobre la versión de firmware en el chip de la bici,
 * así como fecha y hora del alquiler actual de la bici, si es que está alquilada, datos sobre distancia recorrida,
 * fecha del último alquiler, etc.</p>
 * <p> La clase también dispone de información general independiente de los objetosconcretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><b>número total de chips</b> insertados hasta el momento o lo que es lo mismo, <b>número total de bicis;</b></li>
 * <li><b>número de bicis alquiladas</b> en el momento actual, o</li>
 * <li><b>distancia global</b> recorrida por todas las bicis.</li>
 * </ul>
 * @author Juan Carlos Bohórquez Plato.
 */
public class ChipBici {
    //Atributos de objeto variables
    private int version;//Versión del firmware
    private int revision;//Revisión del firmware
    private double kmTotales;//km totales desde adquisición
    private double kmAlqAct;//kilometros recorridos hasta la fecha en el alquiler actual
    private double kmAlqUlt;//kilometros recorridos en el último alquiler 
    private LocalDateTime fecHorIniAlqAct;//fecha y hora de inicio del alquiler actual
    private LocalDateTime fecHorIniAlqUlt;//fecha y hora de inicio del último alquiler 
    private LocalDateTime fecHorFinAlqUlt;//fecha y hora de fini del último alquiler 
    //Atributos de objeto booleanos
    private boolean alquilada;//estado alquilada o no
    //Atributos de clase variables
    private static int totalBicis = 0;//Cantidad total de objetos Chipbici instanciados
    private static int totalBicisAlqAct;//Cantidad total de bicis alquiladas en este momento
    private static double totalKmTodBicis;//Cantidad total de km recorridos entre todas las bicis hasta el momento
    //Atributos de objeto constantes
    private final int numSerie = totalBicis + 1;//Número de serie
    private final LocalDate fAdq;//fecha de adquisición
    //Atributos de clase constantes
    /**
     * Máximo trayecto permitido para realizar a una bici: {@value #MAX_DISTANCIA_TRAYECTO} km
     */
    public static final double MAX_DISTANCIA_TRAYECTO = 140;
    /**
     * Mínima versión del firmware permitida {@value #MIN_VERSION} 
     */
    public static final int MIN_VERSION = 1;
    /**
     * Máxima versión del firmware permitida: {@value #MAX_VERSION} 
     */
    public static final int MAX_VERSION = 10;
    /**
     * Mínima revisión del firmware permitida: {@value #MIN_REVISION} 
     */
    public static final int MIN_REVISION = 0;
    /**
     * Máxima revisión del firmware permitida: {@value #MAX_REVISION} 
     */
    public static final int MAX_REVISION = 9;
    /**
     * Valor por omisión para la versión del firmware: {@value #DEFAULT_VERSION} 
     */
    public static final int DEFAULT_VERSION = 1;
    /**
     * Valor por omisión para la revision del firmware: {@value #DEFAULT_REVISION} 
     */
    public static final int DEFAULT_REVISION = 0;
    /**
     * Mínima fecha de adquisición permitida: 2020/6/15
     */
    public static final LocalDate MIN_FECHA_ADQUISICION = LocalDate.of(2020, 6, 15);
    /**
     * Constructor con 3 parámetros basado en la fecha de adquisición de la bici, así como en la versión y la 
     * revisión del firmware (v.r). 
     * Crea un nuevo objeto ChipBici con la versión y revisión de firmware y la fecha de adquisición indicadas. 
     * La versión debe estar entre ChipBici.MIN_VERSION y ChipBici.MAX_VERSION. La revisión debe estar entre 
     * ChipBici.MIN_REVISION y ChipBici.MAX_REVISION. La fecha de adquisición no puede ser anterior a 
     * ChipBici.MIN_FECHA_ADQUISICION ni posterior a la fecha actual.
     * @param fecha fecha de adquisición de la bici
     * @param version  versión del firmware
     * @param revision  revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici(LocalDate fecha, int version, int revision) throws IllegalArgumentException {
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha incorrecta: null");
        } else if (fecha.isBefore(MIN_FECHA_ADQUISICION) || fecha.isAfter(LocalDate.now())) {
            DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            String fechaError = fecha.format(FORMATO_FECHA);
            throw new IllegalArgumentException("Fecha incorrecta: " + fechaError);
        }
        if (version < MIN_VERSION || version > MAX_VERSION) {
            throw new IllegalArgumentException("Versión incorrecta: " + version);
        }
        if (revision < MIN_REVISION || revision > MAX_REVISION) {
            throw new IllegalArgumentException("Revisión incorrecta: " + revision);
        }
        this.fAdq = fecha;
        this.version = version;
        this.revision = revision;
        ChipBici.totalBicis++;
    }
    /**
     * Constructor con 2 parámetros basado en la versión y la revisión del firmware (v.r). 
     * Crea un nuevo objeto ChipBici con la versión y revisión de firmwareindicadas. 
     * La versión debe estar entre ChipBici.MIN_VERSION y ChipBici.MAX_VERSION. 
     * La revisión debe estar entre ChipBici.MIN_REVISION y ChipBici.MAX_REVISION.
     * @param version  versión del firmware
     * @param revision  revision del firmware
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici(int version, int revision) throws IllegalArgumentException {
        this(LocalDate.now(), version, revision);
    }
    /**
     * Constructor sin parámetros. Crea un nuevo objeto ChipBici con la fecha actual como 
     * fecha de adquisición y con los valores por omisión para la versión y la revisión.
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public ChipBici() throws IllegalArgumentException {
        this(LocalDate.now(), DEFAULT_VERSION, DEFAULT_REVISION);
    }
    /**
     * Método "fábrica" creador de un array de objetos ChipBici. 
     * Crea un array de referencias a objetos ChipBici con los parámetros por omisión. 
     * El tamaño del array será indicado por el parámetro cantidad.
     * @param cantidadDeBicis tamaño del array a devolver
     * @return array de referencias a objetos ChipBici
     * @throws IllegalArgumentException si la cantidad es inferior a 1
     */
    public static ChipBici[] crearArrayChipBici(int cantidadDeBicis) throws IllegalArgumentException {
        if (cantidadDeBicis < 1) {
            throw new IllegalArgumentException("Cantidad no válida: " + cantidadDeBicis);
        }
        ChipBici[] referencias = new ChipBici[cantidadDeBicis];
        for (int contadorBusqueda = 0; contadorBusqueda < cantidadDeBicis; contadorBusqueda++) {
            referencias[contadorBusqueda] = new ChipBici();
        }
        return referencias;
    }
    //Métodos getters sobre objetos
    /**
     * Obtiene el número de serie de la bici.
     * @return número de serie de la bici en string
     */
    public String getNumSerie() {
        String numeroSerie = String.valueOf(this.numSerie);
        return numeroSerie;
    }
    /**
     * Obtiene la fecha de adquisición de la bici.
     * @return fecha de adquisición de la bici
     */
    public LocalDate getFechaAdquisicion() {
        return this.fAdq;
    }
    /**
     * Obtiene la versión del firmware instalado en el chip de la bici.
     * @return versión del firmware del chip de la bici
     */
    public int getVersion() {
        return this.version;
    }
    /**
     * Obtiene la revisión del firmware instalado en el chip de la bici.
     * @return revisión del firmware del chip de la bici
     */
    public int getRevision() {
        return this.revision;
    }
    /**
     * Obtiene la versión y revisión del firmware simultáneamente.
     * @return String con la versión y revisión del firmware instalado en el chip. Formato "versión.revisión"
     */
    public String getVersionRevision() {
        String versionRevision = String.format("%s.%s", this.version, this.revision);
        return versionRevision;
    }
    /**
     * Indica si la bici está alquilada.
     * @return si la bici está alquilada o no
     */
    public boolean isAlquilada() {
        return this.alquilada;
    }
    /**
     * Obtiene el total de kilómetros recorridos hasta el momento por la bici.
     * @return kilómetros recorridos hasta el momento.
     */
    public double getKilometrosTotales() {
        return this.kmTotales;
    }
    /**
     * Obtiene la fecha y hora del alquiler actual de la bici, si es que está alquilada. 
     * Si la bici no está alquilada, devolverá null.
     * @return fecha y hora del alquiler actual. Si no está alquilada devuelve null.
     */
    public LocalDateTime getRegistroInicioAlquilerActual() {
        if (this.alquilada == false) {
            this.fecHorIniAlqAct = null;
        }
        return this.fecHorIniAlqAct;
    }
    /**
     * Obtiene los kilómetros recorridos hasta el momento por la bici durante el alquiler actual, si es que está alquilada. 
     * Si la bici no está alquilada, devolverá 0.
     * @return kilómetros recorridos durante el alquiler actual. Si no está alquilada devuelve 0.
     */
    public double getKilometrosRecorridosAlquilerActual() {
        if (this.alquilada == false) {
            this.kmAlqAct = 0;
        }
        return this.kmAlqAct;
    }
    /**
     * Obtiene la fecha y hora de inicio del último alquiler de la bici (anterior al actual, si es que estuviera alquilada). 
     * Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será null.
     * @return fecha y hora de inicio del último alquiler.
     */
    public LocalDateTime getRegistroInicioUltimoAlquiler() {
        if (this.fecHorFinAlqUlt == null) {
            this.fecHorIniAlqUlt = null;
        }
        return this.fecHorIniAlqUlt;
    }
    /**
     *Obtiene la fecha y hora de fin del último alquiler de la bici (anterior al actual, si es que estuviera alquilada). 
     * Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será null.
     * @return fecha y hora de fin del último alquiler.
     */
    public LocalDateTime getRegistroFinUltimoAlquiler() {
        return this.fecHorFinAlqUlt;
    }
    /**
     * Obtiene el total de kilómetros recorridos por la bici durante el último alquiler. 
     * Si todavía no ha llegado finalizar ningún alquiler (aún no ha sido alquilada y devuelta), será 0.
     * @return kilómetros recorridos durante el último alquiler.
     */
    public double getKilometrosRecorridosUltimoAlquiler() {
        return this.kmAlqUlt;
    }
    //Métodos getters sobre clase
    /**
     * Obtiene la cantidad de chips (y por tanto de bicis) creados hasta el momento.
     * @return cantidad de bicis registradas
     */
    public static int getNumBicis() {
        return ChipBici.totalBicis;
    }
    /**
     * Obtiene la cantidad de bicis alquiladas en ese momento.
     * @return cantidad de bicis alquiladas
     */
    public static int getNumBicisAlquiladas() {
        return ChipBici.totalBicisAlqAct;
    }
    /**
     * Obtiene el total de kilómetros recorridos entre todas las bicis hasta el momento.
     * @return total de kilómetros recorridos entre todas las bicis hasta el momento
     */
    public static double getKilometrosTodasLasBicis() {
        return ChipBici.totalKmTodBicis;
    }
    /**
     * Pasa el estado de la bici a "alquilada". Si ya está alquilada no se puede volver a alquilar.
     * @throws IllegalStateException si ya está alquilada
     */
    public void alquilar() throws IllegalStateException {
        if (this.alquilada == true) {
            throw new IllegalStateException("Bici ya alquilada");
        }
        this.alquilada = true;
        this.fecHorIniAlqAct = LocalDateTime.now();
        ChipBici.totalBicisAlqAct++;
    }
    /**
     * Pasa el estado de la bici a "no alquilada". Si no está alquilada no puede llevarse a cabo esta operación.
     * @throws IllegalStateException si no está alquilada
     */
    public void devolver() throws IllegalStateException {
        if (this.alquilada == false) {
            throw new IllegalStateException("Bici no alquilada");
        }
        this.kmAlqUlt = this.kmAlqAct;
        this.fecHorIniAlqUlt = this.fecHorIniAlqAct;
        this.fecHorFinAlqUlt = LocalDateTime.now();
        ChipBici.totalBicisAlqAct--;
        this.kmAlqAct = 0;
        this.alquilada = false;
    }
    /**
     * Recorre un trayecto de una determinada distancia con la bici. 
     * No se puede superar la máxima ditancia permitida por trayecto. 
     * No se permiten distancias negativas. Sí se permite la distancia 0.
     * @param distanciaKm longitud del trayecto (en kilómetros
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @throws IllegalStateException si la bici no está alquilada
     * @throws IllegalArgumentException si la distancia no es válida
     */
    public double recorrerTrayecto(double distanciaKm) throws IllegalStateException, IllegalArgumentException {
        if (this.alquilada == false) {
            throw new IllegalStateException("Bici no alquilada");
        }
        if (distanciaKm < 0 || distanciaKm > ChipBici.MAX_DISTANCIA_TRAYECTO) {
            throw new IllegalArgumentException(String.format("Distancia incorrecta: %.2f", distanciaKm));
        }
        this.kmAlqAct = this.kmAlqAct + distanciaKm;
        this.kmTotales = this.kmTotales + distanciaKm;
        ChipBici.totalKmTodBicis = ChipBici.totalKmTodBicis + distanciaKm;
        return this.kmAlqAct;
    }
    /**
     * Recorre la máxima distancia que se puede recorrer en un trayecto con la bici.
     * @return la cantidad de kilómetros que se llevan recorridos con el alquiler actual
     * @throws IllegalStateException si la bici no está alquilada
     */
    public double recorrerTrayecto() throws IllegalStateException {
        recorrerTrayecto(MAX_DISTANCIA_TRAYECTO);
        return this.kmAlqAct;
    }
    /**
     * Lleva a cabo una actualización del firmware del chip. 
     * Siempre debe de ser un upgrade, es decir, debe ser a una revisión superior válida de la versión 
     * actual o bien a cualquier revisión válida de una versión superior. Si la bici está alquilada no 
     * se permite la actualización
     * @param version versión de actualización
     * @param revision revisión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException si la versión o revisión es incorrecta o bien no es un upgrade
     */
    public void actualizarFirmware(int version, int revision) throws IllegalStateException, IllegalArgumentException {
        if (this.alquilada == true) {
            throw new IllegalStateException("No se puede actualizar el firmware a una bici alquilada");
        }
        if (version < ChipBici.MIN_VERSION || version > ChipBici.MAX_VERSION) {
            throw new IllegalArgumentException(String.format("Versión incorrecta: %d", version));
        }
        if (revision < ChipBici.MIN_REVISION || revision > ChipBici.MAX_REVISION) {
            throw new IllegalArgumentException(String.format("Revisión incorrecta: %d", revision));
        }
        if (version < this.version) {
            throw new IllegalArgumentException(String.format("Es necesario actualizar a una versión superior a "
                    + "la actual: %d.%d <= %d.%d", version, revision, this.version, this.revision));
        } else if (version == this.version && revision <= this.revision) {
            throw new IllegalArgumentException(String.format("Es necesario actualizar a una versión superior a "
                    + "la actual: %d.%d <= %d.%d", version, revision, this.version, this.revision));
        }
        this.version = version;
        this.revision = revision;
    }
    /**
     * Lleva a cabo una actualización del firmware del chip. 
     * Solo se indica la versión. La revisón será la 0. Siempre debe de ser un upgrade, es decir, debe ser a 
     * versión superior válida a la versión actual. Si la bici está alquilada no se permite la actualización.
     * @param version versión de actualización
     * @throws IllegalStateException si la bici está alquilada
     * @throws IllegalArgumentException si la versión o revisión es incorrecta o bien no es un upgrade
     */
    public void actualizarFirmware(int version) throws IllegalStateException, IllegalArgumentException {
        actualizarFirmware(version, DEFAULT_REVISION);
    }
    /**
     * Resetea el chip a los valores de fábrica. 
     * Solo puede ser reseteado si la bici no está alquilada. El firmware volverá a la versión por omisión. 
     * Se perderán todos los registros de alquileres, incluyedo cualquier fecha y dato kilométrico. 
     * Tan solo se mantendrán el número de serie y la fecha de adquisición.
     * @throws IllegalStateException si la bici está alquilada
     */
    public void reset() throws IllegalStateException {
        if (this.alquilada == true) {
            throw new IllegalStateException("No se puede resetear un chip de una bici que esté alquilada");
        }
        this.version = ChipBici.DEFAULT_VERSION;
        this.revision = ChipBici.DEFAULT_REVISION;
        this.fecHorFinAlqUlt = null;
        this.fecHorIniAlqAct = null;
        this.fecHorIniAlqUlt = null;
        this.kmAlqAct = 0;
        this.kmAlqUlt = 0;
        this.kmTotales = 0;
    }
    /**
     * <p>Devuelve una cadena que representa el estado de un objeto ChipBici. 
     * El resultado devuelto representará el estado del chip y tendrá la siguiente estructura:</p>
     * <ol>
     * <li>un inicio de bloque o llave (carácter '{');</li>
     * <li>la etiqueta "NS: " junto con el número de serie;</li>
     * <li>la fecha de adquisción de la bici;</li>
     * <li>la etiqueta "fw: " y a continuación la versión y revisión del firmware;</li>
     * <li>si la bici está o no alquilada;</li>
     * <li>cantidad de kilómetros totales recorridos por la bici hasta el momento;</li>
     * <li>información sobre el alquiler actual: fecha y hora de inicio del alquiler actual y 
     * kilómetros recorridos durante ese alquiler;</li>
     * <li>información sobre el último alquiler realizado: fecha y hora de inicio y de 
     * fin de ese alquiler junto con los kilómetros realizados durante el mismo;</li>
     * <li>un fin de bloque o llave (carácter '}').</li>
     * </ol>
     * <p>Un ejemplo de cadena devuelta podría ser:</p>
     * <p>{ NS: 33; 15/09/2021; fw: 2.1; no alquilada; 150,00 km totales; Alquiler actual: ---, 0,00 km; 
     * Último alquiler: 09/12/2021 12:33:36, 09/12/2021 22:02:57, 57,28 km }</p>
     * <p>donde podríamos observar la siguiente información:</p>
     * <ul>
     * <li>el número de serie de la bici es 33;</li>
     * <li>la fecha de adquisición es el 15 de septiembre de 2021;</li>
     * <li>la versión y revisión del firmware es 2.1;</li>
     * <li>la bici no está alquilada en este momento;</li>
     * <li>la cantidad de kilómetros recorridos por la bici hasta el momento es de 150,00 kilómetros;</li>
     * <li>la información sobre el alquiler actual será nula: fecha/hora con "---" y kilómetros a cero, 
     * pues no está alquilada;</li>
     * <li>la información sobre el último alquiler completado será: los registros "09/12/2021 12:33:36" 
     * para el inicio y "09/12/2021 22:02:57" para el fin del alquiler junto con los 57,28 km realizados 
     * durante ese alquiler.</li>
     * </ul>
     * @return una cadena que representa el estado de un objeto microdispositivo ChipBici
     */
    @Override
    public String toString() {
        String alquiladaONo;
        String fechaAdq;
        String fechaHoraIniAct;
        String fechaHoraFinUlt;
        String fechaHoraIniUlt;
        DateTimeFormatter FORMATO_FECHA;
        DateTimeFormatter FORMATO_FECHA_HORA;
        FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        fechaAdq = this.fAdq.format(FORMATO_FECHA);
        if (this.alquilada == true) {
            alquiladaONo = "alquilada";
            fechaHoraIniAct = this.fecHorIniAlqAct.format(FORMATO_FECHA_HORA);
        } else {
            alquiladaONo = "no alquilada";
            fechaHoraIniAct = "---";
        }
        if (this.fecHorIniAlqUlt == null) {
            fechaHoraFinUlt = "---";
            fechaHoraIniUlt = "---";
            this.kmAlqUlt = 0;
        } else {
            fechaHoraFinUlt = this.fecHorFinAlqUlt.format(FORMATO_FECHA_HORA);
            fechaHoraIniUlt = this.fecHorIniAlqUlt.format(FORMATO_FECHA_HORA);
        }
        return String.format("{ NS: %d; %s; fw: %d.%d; %s; %.2f km totales; Alquiler actual: %s, %.2f km; Último alquiler: %s, %s, %.2f km }",
                this.numSerie,
                fechaAdq,
                this.version,
                this.revision,
                alquiladaONo,
                this.kmTotales,
                fechaHoraIniAct,
                this.kmAlqAct,
                fechaHoraIniUlt,
                fechaHoraFinUlt,
                this.kmAlqUlt);
    }
}
